package discoverylab.telebot.slave.core.readers;

import jssc.SerialPort;

import com.rti.dds.subscription.DataReader;
import com.rti.dds.subscription.DataReaderAdapter;
import com.rti.dds.subscription.LivelinessChangedStatus;
import com.rti.dds.subscription.RequestedDeadlineMissedStatus;
import com.rti.dds.subscription.RequestedIncompatibleQosStatus;
import com.rti.dds.subscription.SampleLostStatus;
import com.rti.dds.subscription.SampleRejectedStatus;
import com.rti.dds.subscription.SubscriptionMatchedStatus;

/**
 * 
 * @author Irvin Steve Cardenas
 *
 */
public abstract class CoreDataReaderAdapter extends DataReaderAdapter {
	SerialPort serialPort = null;
	
	public CoreDataReaderAdapter(){
	}
	
	public void setSerialPort(SerialPort serialPort) {
		this.serialPort = serialPort;
	}
	
	public SerialPort getSerialPort(){
		return this.serialPort;
	}
	
	public void on_requested_deadline_missed(
		DataReader dataReader,
        RequestedDeadlineMissedStatus status) {
		System.out.println("ReaderListener: on_requested_deadline_missed()");
    }    
   
    public void on_requested_incompatible_qos(
        DataReader dataReader,
        RequestedIncompatibleQosStatus status) {
        System.out.println("ReaderListener: on_requested_incompatible_qos()"); 
        }
    
    public void on_sample_rejected(
        DataReader dataReader,
        SampleRejectedStatus status) {
        System.out.println("ReaderListener: on_sample_rejected()");
    }
    
    public void on_liveliness_changed(
        DataReader dataReader,
        LivelinessChangedStatus status) {
        System.out.println("ReaderListener: on_liveliness_changed()");
        System.out.print("  Alive writers: " + status.alive_count + "\n");
    }

    public void on_sample_lost(
        DataReader dataReader,
        SampleLostStatus status) {
        System.out.println("ReaderListener: on_sample_lost()");
    }   
    
    public void on_subscription_matched(
        DataReader dataReader,
        SubscriptionMatchedStatus status) {
    	System.out.println("ReaderListener: on_subscription_matched()");
    }
}
