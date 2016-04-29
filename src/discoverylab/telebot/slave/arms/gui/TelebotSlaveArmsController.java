package discoverylab.telebot.slave.arms.gui;

import discoverylab.telebot.slave.arms.listeners.TSlaveArmsListener.DataListener;

public class TelebotSlaveArmsController implements DataListener
{
	private TelebotSlaveArmsView view;
	
	public TelebotSlaveArmsController(TelebotSlaveArmsView view)
	{
		this.view = view;
	}
	
	public void callback(String[] data)
	{
		if(data[0].equals("10"))
		{
			view.setPosServoID10(data[1]);
		}
		else if(data[0].equals("11"))
		{
			view.setPosServoID11(data[1]);
		}
		else if(data[0].equals("20"))
		{
			view.setPosServoID20(data[1]);
		}
		else if(data[0].equals("21"))
		{
			view.setPosServoID21(data[1]);
		}
		else if(data[0].equals("22"))
		{
			view.setPosServoID22(data[1]);
		}
		else if(data[0].equals("23"))
		{
			view.setPosServoID23(data[1]);
		}
		else if(data[0].equals("24"))
		{
			view.setPosServoID24(data[1]);
		}
		else if(data[0].equals("25"))
		{
			view.setPosServoID25(data[1]);
		}
		else if(data[0].equals("30"))
		{
			view.setPosServoID30(data[1]);
		}
		else if(data[0].equals("31"))
		{
			view.setPosServoID31(data[1]);
		}
		else if(data[0].equals("32"))
		{
			view.setPosServoID32(data[1]);
		}
		else if(data[0].equals("33"))
		{
			view.setPosServoID33(data[1]);
		}
		else if(data[0].equals("34"))
		{
			view.setPosServoID34(data[1]);
		}
		else if(data[0].equals("35"))
		{
			view.setPosServoID35(data[1]);
		}
	}

}
