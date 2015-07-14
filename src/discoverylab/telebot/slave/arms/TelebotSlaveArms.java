package discoverylab.telebot.slave.arms;

import com.rti.dds.topic.Topic;

import jssc.SerialPort;
import discoverylab.telebot.slave.core.CoreSlaveComponent;

/**
 * 
 * @author Irvin Steve Cardenas
 *
 */
public class TelebotSlaveArms extends CoreSlaveComponent{

	public TelebotSlaveArms(){
		
	}
	public TelebotSlaveArms(SerialPort serialPort){
		super(serialPort);
	}
	
	public TelebotSlaveArms(String serialPortName, int baudRate, int dataBits,
			int stopBits, int parityType, int eveMask) {
		super(serialPortName, baudRate, dataBits, stopBits, parityType, eveMask);
	}
	
	@Override
	public boolean calibrate() {
		// TODO Auto-generated method stub
		return true;
	}
}
