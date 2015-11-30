package discoverylab.telebot.slave.arms.gui;

import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArms;
import discoverylab.telebot.slave.arms.listeners.TSlaveArmsListener;

public class TelebotSlaveArmsController implements TSlaveArmsListener.DataListenerInterface
{
	private TelebotSlaveArmsView view;
	
	public TelebotSlaveArmsController(TelebotSlaveArmsView view)
	{
		this.view = view;
	}
	
	public void callback(int[] data)
	{
		if(data[0] == 10)
		{
			view.setPosServoID10(Integer.toString(data[1]));
		}
		else if(data[0] == 11)
		{
			view.setPosServoID11(Integer.toString(data[1]));
		}
		else if(data[0] == 20)
		{
			view.setPosServoID20(Integer.toString(data[1]));
		}
		else if(data[0] == 21)
		{
			view.setPosServoID21(Integer.toString(data[1]));
		}
		else if(data[0] == 22)
		{
			view.setPosServoID22(Integer.toString(data[1]));
		}
		else if(data[0] == 23)
		{
			view.setPosServoID23(Integer.toString(data[1]));
		}
		else if(data[0] == 24)
		{
			view.setPosServoID24(Integer.toString(data[1]));
		}
		else if(data[0] == 25)
		{
			view.setPosServoID25(Integer.toString(data[1]));
		}
		else if(data[0] == 30)
		{
			view.setPosServoID30(Integer.toString(data[1]));
		}
		else if(data[0] == 31)
		{
			view.setPosServoID31(Integer.toString(data[1]));
		}
		else if(data[0] == 32)
		{
			view.setPosServoID32(Integer.toString(data[1]));
		}
		else if(data[0] == 33)
		{
			view.setPosServoID33(Integer.toString(data[1]));
		}
		else if(data[0] == 34)
		{
			view.setPosServoID34(Integer.toString(data[1]));
		}
		else if(data[0] == 35)
		{
			view.setPosServoID35(Integer.toString(data[1]));
		}
	}

}
