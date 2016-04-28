package discoverylab.telebot.slave.arms.listeners;

import jssc.SerialPortException;
import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArms;
import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArmsDataReader;
import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArmsSeq;

import com.rti.dds.infrastructure.RETCODE_NO_DATA;
import com.rti.dds.infrastructure.ResourceLimitsQosPolicy;
import com.rti.dds.subscription.DataReader;
import com.rti.dds.subscription.InstanceStateKind;
import com.rti.dds.subscription.SampleInfo;
import com.rti.dds.subscription.SampleInfoSeq;
import com.rti.dds.subscription.SampleStateKind;
import com.rti.dds.subscription.ViewStateKind;

import discoverylab.telebot.slave.arms.gui.TelebotSlaveArmsController;
import discoverylab.telebot.slave.core.readers.CoreDataReaderAdapter;

/**
 * 
 * @author Irvin Steve Cardenas
 *
 */
public class TSlaveArmsListener extends CoreDataReaderAdapter{
	
	private DataListenerInterface eventListener;
	private TelebotSlaveArmsController controller;
	
	public TSlaveArmsListener(TelebotSlaveArmsController controller)
	{
		this.controller = controller;
	}
	
	public DataListenerInterface getCallbackInterface()
	{
		return eventListener;
	}

	public void on_data_available(DataReader reader) {
		// STEP 1: Create Data Reader
		TMasterToArmsDataReader tMasterToArmsDataReader = (TMasterToArmsDataReader) reader;
		// STEP 2: Create Data Sequence
		TMasterToArmsSeq dataSeq = new TMasterToArmsSeq();
		// STEP 3: Create Sample Info Sequence
		SampleInfoSeq infoSeq = new SampleInfoSeq();
		try {
			tMasterToArmsDataReader.read(
					dataSeq, 
					infoSeq,
					ResourceLimitsQosPolicy.LENGTH_UNLIMITED,
                    SampleStateKind.ANY_SAMPLE_STATE,
                    ViewStateKind.ANY_VIEW_STATE,
                    InstanceStateKind.ANY_INSTANCE_STATE);
			
			for(int i = 0; i < dataSeq.size(); i++) {
				SampleInfo info = (SampleInfo) infoSeq.get(i);
				
				if(info.valid_data) {					
					TMasterToArms command = (TMasterToArms)dataSeq.get(i);
					String commandStr = "<" +  command.servoId + " " + 
							command.servoPositon + " " + 
							command.servoSpeed + ">";
					
					int[] data = new int[2];
					data[0] = command.servoId;
					data[1] = command.servoPositon;
					
//					getCallbackInterface().callback(data);
					controller.callback(data);
					System.out.println(commandStr);
					try {
						getSerialPort().writeString(commandStr);
					} catch (SerialPortException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (RETCODE_NO_DATA noData) {
            // No data to process
        } 
//		catch (SerialPortException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		finally {
			tMasterToArmsDataReader.return_loan(dataSeq, infoSeq);
        }
	}
	
	public interface DataListenerInterface
	{
		public void callback(int[] data);
	}
}
