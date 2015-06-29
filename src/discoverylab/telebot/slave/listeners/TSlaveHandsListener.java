package discoverylab.telebot.slave.listeners;

import jssc.SerialPortException;
import TelebotDDSCore.Source.Java.Generated.master.hands.TMasterToHands;
import TelebotDDSCore.Source.Java.Generated.master.hands.TMasterToHandsDataReader;
import TelebotDDSCore.Source.Java.Generated.master.hands.TMasterToHandsSeq;

import com.rti.dds.infrastructure.RETCODE_NO_DATA;
import com.rti.dds.infrastructure.ResourceLimitsQosPolicy;
import com.rti.dds.subscription.DataReader;
import com.rti.dds.subscription.InstanceStateKind;
import com.rti.dds.subscription.SampleInfo;
import com.rti.dds.subscription.SampleInfoSeq;
import com.rti.dds.subscription.SampleStateKind;
import com.rti.dds.subscription.ViewStateKind;

import discoverylab.telebot.slave.core.readers.CoreDataReaderAdapter;

/**
 * 
 * @author Irvin Steve Cardenas
 *
 */
public class TSlaveHandsListener extends CoreDataReaderAdapter{
	
	public void on_data_available(DataReader reader) {
		TMasterToHandsDataReader tMasterToHandsDataReader = (TMasterToHandsDataReader) reader;
		TMasterToHandsSeq dataSeq = new TMasterToHandsSeq();
		SampleInfoSeq infoSeq = new SampleInfoSeq();
		
		try {
			tMasterToHandsDataReader.read(
					dataSeq, 
					infoSeq,
					ResourceLimitsQosPolicy.LENGTH_UNLIMITED,
                    SampleStateKind.ANY_SAMPLE_STATE,
                    ViewStateKind.ANY_VIEW_STATE,
                    InstanceStateKind.ANY_INSTANCE_STATE);
			
			for(int i = 0; i < dataSeq.size(); i++) {
				SampleInfo info = (SampleInfo) infoSeq.get(i);
				
				if(info.valid_data) {					
					TMasterToHands command = (TMasterToHands)dataSeq.get(i);
					String commandStr = command.lPinky + " " + 
							command.lRing + " " + 
							command.lMiddle + " " +
							command.lIndex + " " +
							command.lThumbFlexion + " " +
							command.lThumbOpposition + "\r";
					
					System.out.println(commandStr);
					getSerialPort().writeString(commandStr);
				}
			}
		} catch (RETCODE_NO_DATA noData) {
            // No data to process
        } 
		catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
        	tMasterToHandsDataReader.return_loan(dataSeq, infoSeq);
        }
	}
}
