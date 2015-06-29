package discoverylab.telebot.slave.test;

import static discoverylab.util.LogUtils.*;

import com.rti.dds.subscription.Subscriber;

import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArms;
import TelebotDDSCore.Source.Java.Generated.master.hands.TOPIC_MASTER_TO_SLAVE_HANDS;
import discoverylab.telebot.slave.configurations.Config;
import discoverylab.telebot.slave.listeners.TSlaveHandsListener;
/**
 * 
 * @author 	Irvin Steve Cardenas
 * @twitter	kPatch
 *
 */
public class Test {
	
	public static String TAG = makeLogTag(Test.class);
	
	public static void main(String [] args){
		
		TelebotSlaveArms telebotSlaveHands = new TelebotSlaveArms(
				Config.SERIAL_PORT_NAME, 
				Config.SERIAL_BAUD_RATE,
				Config.SERIAL_DATA_BITS,
				Config.SERIAL_STOP_BITS,
				Config.SERIAL_PARITY_TYPE,
				Config.SERIAL_EVENT_MASK);
		
// 1. INITIATE Slave Component DEVICE
		if( telebotSlaveHands.initiate()){
			LOGI(TAG, "Hand Initiation Complete");
		}
		else {
			LOGI(TAG, "Hand Initiation Failed");
		}
		
// 2. CALIBRATE
		if( telebotSlaveHands.calibrate() ){
			LOGI(TAG, "Hand Calibration Complete");
		}
		else {
			LOGI(TAG, "Hand Calibration Failed");
		}
		
// 3. INITIATE Transmission PROTOCOL
		TSlaveHandsListener listener = new TSlaveHandsListener();
		
		if( telebotSlaveHands.initiateTransmissionProtocol(TOPIC_MASTER_TO_SLAVE_HANDS.VALUE, TMasterToArms.class, listener) ) {
			LOGI(TAG, "Protocol Sequence Initiated");
		}
		else {
			LOGI(TAG, "Protocol Sequence Failed");
		}
		
// 4. INITIATE Transmission SEQUENCE		
		
	}
}
