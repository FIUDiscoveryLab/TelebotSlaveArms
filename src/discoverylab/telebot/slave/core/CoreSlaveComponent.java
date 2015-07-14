package discoverylab.telebot.slave.core;

import java.lang.reflect.InvocationTargetException;

import TelebotDDSCore.DDSCommunicator;

import com.rti.dds.infrastructure.InstanceHandle_t;
import com.rti.dds.infrastructure.StatusKind;
import com.rti.dds.subscription.DataReaderImpl;
import com.rti.dds.subscription.Subscriber;
import com.rti.dds.topic.Topic;

import discoverylab.telebot.slave.core.configurations.Config;
import discoverylab.telebot.slave.core.readers.CoreDataReaderAdapter;
import jssc.SerialPort;
import jssc.SerialPortException;
import static discoverylab.util.logging.LogUtils.*;

/**
 * Core Slave Component
 * @author Irvin Steve Cardenas
 * 
 * CoreSlaveComponent is the base class for any slave component. 
 * This can be a slave component that connects directly to a serial device such as the case of the Arms Slave Component.
 * Or this can be a "Driver" Slave Component, one that solely receives instructions (commands) from the Master side and executes these instructions
 * 		by making use of other Slave Component, through a Topic Publication. For example, the TelebotMasterVoiceControlTCP.
 * 
 * Overall the CoreSlaveComponent provides a layer of abstraction for DDS communication and Serial Communication. Allowing the Component developer
 * 		to simply extend the CoreSlaveComponent and pass the appropriate Serial configurations, if necessary, and the proper DDS Classes.
 */
public abstract class CoreSlaveComponent {

	public static String TAG = makeLogTag("CoreComponent");
	
//	Is it a Slave Component. This is set in the constructor
	private Boolean isSerialComponent 				= true;
	
//  Serial
	private SerialPort serialPort;
	protected Boolean serialConnected 				= false;
	private String serialPortName;
	private Integer baudRate;
	private Integer dataBits;
	private Integer stopBits; 
	private Integer parityType;
	private Integer eventMask;
	
//  DDS 
	private DDSCommunicator communicator;
	private static Topic topic 						= null;
	private static DataReaderImpl reader 			= null;
	private static CoreDataReaderAdapter listener	= null;
//	Object instance 								= new TMasterToHands();
	InstanceHandle_t instance_handle 				= InstanceHandle_t.HANDLE_NIL;
	
	/**
	 * Default Core Slave Component for non-serial components
	 */
	public CoreSlaveComponent(){
		this.isSerialComponent = false;
	}
	
	/**
	 * Default Constructor Uses Default Values For Serial Connection
	 * @param serialPort 
	 */
	public CoreSlaveComponent(SerialPort serialPort){
		
		this.serialPort = serialPort;
		
		LOGW(TAG, "Setting --Default-- Serial Configurations");
		this.baudRate 			= Config.SERIAL_BAUD_RATE;
		this.dataBits 			= Config.SERIAL_DATA_BITS;
		this.stopBits 			= Config.SERIAL_STOP_BITS;
		this.parityType 		= Config.SERIAL_PARITY_TYPE;
		this.eventMask 			= Config.SERIAL_EVENT_MASK;
	}
	
	/**
	 * 
	 * @param serialPortName
	 * @param baudRate
	 * @param dataBits
	 * @param stopBits
	 * @param parityType
	 * @param eventMask
	 */
	public CoreSlaveComponent(String serialPortName, int baudRate, int dataBits, int stopBits, int parityType, int eventMask){
		this.serialPortName 	= serialPortName;
		this.baudRate 			= baudRate;
		this.dataBits 			= dataBits;
		this.stopBits 			= stopBits;
		this.parityType 		= parityType;
		this.eventMask 			= eventMask;
		
		serialPort = new SerialPort(serialPortName);
	}
	
	/**
	 * Slave Hands Initiate - Open Hand Serial Connection
	 * @return
	 */
	@SuppressWarnings("finally")
	public boolean initiate(){
		try {
			serialPort.openPort();
			if(!checkSerialParams()){
				setSerialDefaultParams();
			}
			else {
				serialPort.setParams(baudRate
						, dataBits
						, stopBits
						, parityType);
				
				serialPort.setEventsMask(eventMask);
			}
		} catch (SerialPortException e) {
			LOGE(TAG, "Error opening SerialPort: " + serialPortName  + " with Baudrate: " + baudRate);
			e.printStackTrace();
		}
		finally{
			return serialPort.isOpened();
		}
	}
	
	/**
	 * Check if the user has defined Serial parameters
	 * @return
	 */
	private boolean checkSerialParams(){
		return(serialPortName != null && 
				baudRate != null && 
				dataBits != null && 
				stopBits != null && 
				parityType != null && 
				eventMask != null);
	}
	
	/**
	 * Utility method to set the default configuration parameters for a Serial object.
	 * This method is called if the user does not pass the Serial parameters.
	 */
	private void setSerialDefaultParams(){
		LOGW(TAG, "Setting Serial --Default-- Paramaters");
		try {
			serialPort.setParams(Config.SERIAL_BAUD_RATE
					, Config.SERIAL_DATA_BITS
					, Config.SERIAL_STOP_BITS
					, Config.SERIAL_PARITY_TYPE);
			
			serialPort.setEventsMask(Config.SERIAL_EVENT_MASK);
		} catch (SerialPortException e) {
			LOGE(TAG, "Error setting Serial parameters: " + serialPortName  + " with Baudrate: " + baudRate);
			e.printStackTrace();
		}
	}
	
	/**
	 * Perform Slave Component Calibration
	 * @return
	 */
	public abstract boolean calibrate();
	
	/**
	 * Initiate DDS Protocol with Serial
	 * @return
	 */
	public boolean initiateTransmissionProtocol(String topicName, Class type, CoreDataReaderAdapter listener){
		setListener(listener);
		
		if(isSerialComponent){
			getListener().setSerialPort(this.serialPort);
		}

		communicator = new DDSCommunicator();
		try {
			communicator.createParticipant();
			
		} catch (Exception e) {
			LOGE(TAG, "Error Creating Participant");
			e.printStackTrace();
		}
		try {
			communicator.createPublisher();
		} catch (Exception e) {
			LOGE(TAG, "Error Creating Publisher");
			e.printStackTrace();
		}
		try {
			communicator.createSubscriber();
		} catch (Exception e) {
			LOGE(TAG, "Error Creating Subscriber");
			e.printStackTrace();
		}
		
		try {
			this.topic = communicator.createTopic(topicName, type);
		} catch (ClassNotFoundException | NoSuchMethodException
				| SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| InstantiationException e) {
			LOGE(TAG, "Error Creating Topic");
			e.printStackTrace();
		}
		
		try {
			setReader((DataReaderImpl) communicator.getSubscriber()
						.create_datareader(
								topic, 
								Subscriber.DATAREADER_QOS_USE_TOPIC_QOS, 
								getListener(),
								StatusKind.STATUS_MASK_ALL));
		} catch (Exception e) {
			LOGE(TAG, "Error Creating Reader");
			e.printStackTrace();
		}
		
		//TODO Get assertion of Participant
		return true;
	}

	private static CoreDataReaderAdapter getListener() {
		return listener;
	}

	private static void setListener(CoreDataReaderAdapter listener) {
		CoreSlaveComponent.listener = listener;
	}

	private static DataReaderImpl getReader() {
		return reader;
	}

	private static void setReader(DataReaderImpl reader) {
		CoreSlaveComponent.reader = reader;
	}

}