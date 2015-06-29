package discoverylab.telebot.slave.arms.test;

import static discoverylab.util.LogUtils.*;
import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArms;
import TelebotDDSCore.Source.Java.Generated.master.arms.TOPIC_MASTER_TO_SLAVE_ARMS;
import TelebotDDSCore.Source.Java.Generated.master.hands.TOPIC_MASTER_TO_SLAVE_HANDS;
import discoverylab.telebot.slave.arms.configurations.SlaveArmsConfig;
import discoverylab.telebot.slave.arms.listeners.TSlaveArmsListener;

/**
 * 
 * @author 	Irvin Steve Cardenas
 * @twitter	kPatch
 *
 */
public class TelebotSlaveArmsTest {
	
	public static String TAG = makeLogTag(TelebotSlaveArmsTest.class);
	
	public static void main(String [] args){
		
		TelebotSlaveArms telebotSlaveArms = new TelebotSlaveArms(
				  SlaveArmsConfig.DEFAULT_SERIAL_PORT_NAME
				, SlaveArmsConfig.DEFAULT_SERIAL_BAUD_RATE
				, SlaveArmsConfig.DEFAULT_SERIAL_DATA_BITS
				, SlaveArmsConfig.DEFAULT_SERIAL_STOP_BITS
				, SlaveArmsConfig.DEFAULT_SERIAL_PARITY_TYPE
				, SlaveArmsConfig.DEFAULT_SERIAL_EVENT_MASK);
		
// 1. INITIATE Slave Component DEVICE
		if( telebotSlaveArms.initiate()){
			LOGI(TAG, "Hand Initiation Complete");
		}
		else {
			LOGI(TAG, "Hand Initiation Failed");
		}
		
// 2. CALIBRATE
		if( telebotSlaveArms.calibrate() ){
			LOGI(TAG, "Hand Calibration Complete");
		}
		else {
			LOGI(TAG, "Hand Calibration Failed");
		}
		
// 3. INITIATE Transmission PROTOCOL
		TSlaveArmsListener listener = new TSlaveArmsListener();
		
		if( telebotSlaveArms.initiateTransmissionProtocol(
				TOPIC_MASTER_TO_SLAVE_ARMS.VALUE
				, TMasterToArms.class
				, listener) ) {
			LOGI(TAG, "Protocol Sequence Initiated");
		}
		else {
			LOGI(TAG, "Protocol Sequence Failed");
		}
		
// 4. INITIATE Transmission SEQUENCE		
		
	}
}