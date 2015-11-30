package discoverylab.telebot.slave.arms.gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelebotSlaveArmsView extends JFrame
{
	private JLabel labelPosServoID10,
	labelPosServoID11,
	labelPosServoID20,
	labelPosServoID21,
	labelPosServoID22,
	labelPosServoID23,
	labelPosServoID24,
	labelPosServoID25,
	labelPosServoID30,
	labelPosServoID31,
	labelPosServoID32,
	labelPosServoID33,
	labelPosServoID34,
	labelPosServoID35;
	
	private JTextField textPosServoID10,
	textPosServoID11,
	textPosServoID20,
	textPosServoID21,
	textPosServoID22,
	textPosServoID23,
	textPosServoID24,
	textPosServoID25,
	textPosServoID30,
	textPosServoID31,
	textPosServoID32,
	textPosServoID33,
	textPosServoID34,
	textPosServoID35;
	
	public TelebotSlaveArmsView()
	{
		labelPosServoID10 = new JLabel("Servo ID 10 Position: ");
		labelPosServoID11 = new JLabel("Servo ID 11 Position: ");
		labelPosServoID20 = new JLabel("Servo ID 20 Position: ");
		labelPosServoID21 = new JLabel("Servo ID 21 Position: ");
		labelPosServoID22 = new JLabel("Servo ID 22 Position: ");
		labelPosServoID23 = new JLabel("Servo ID 23 Position: ");
		labelPosServoID24 = new JLabel("Servo ID 24 Position: ");
		labelPosServoID25 = new JLabel("Servo ID 25 Position: ");
		labelPosServoID30 = new JLabel("Servo ID 30 Position: ");
		labelPosServoID31 = new JLabel("Servo ID 31 Position: ");
		labelPosServoID32 = new JLabel("Servo ID 32 Position: ");
		labelPosServoID33 = new JLabel("Servo ID 33 Position: ");
		labelPosServoID34 = new JLabel("Servo ID 34 Position: ");
		labelPosServoID35 = new JLabel("Servo ID 35 Position: ");
		
		textPosServoID10 = new JTextField();
		textPosServoID11 = new JTextField();
		textPosServoID20 = new JTextField();
		textPosServoID21 = new JTextField();
		textPosServoID22 = new JTextField();
		textPosServoID23 = new JTextField();
		textPosServoID24 = new JTextField();
		textPosServoID25 = new JTextField();
		textPosServoID30 = new JTextField();
		textPosServoID31 = new JTextField();
		textPosServoID32 = new JTextField();
		textPosServoID33 = new JTextField();
		textPosServoID34 = new JTextField();
		textPosServoID35 = new JTextField();
		
		GridLayout gridLayout = new GridLayout(14, 2, 1, 1);
//		GridBagConstraints constraints = new GridBagConstraints();
//		constraints.gridheight = 12;
//		constraints.gridwidth = 2;
		
		JPanel panel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 700);
		
		panel.setLayout(gridLayout);
		
		panel.add(labelPosServoID10);
		panel.add(textPosServoID10);
		
		panel.add(labelPosServoID11);
		panel.add(textPosServoID11);
		
		panel.add(labelPosServoID20);
		panel.add(textPosServoID20);
		
		panel.add(labelPosServoID21);
		panel.add(textPosServoID21);
		
		panel.add(labelPosServoID22);
		panel.add(textPosServoID22);
	
		panel.add(labelPosServoID23);
		panel.add(textPosServoID23);
		
		panel.add(labelPosServoID24);
		panel.add(textPosServoID24);
		
		panel.add(labelPosServoID25);
		panel.add(textPosServoID25);
		
		panel.add(labelPosServoID30);
		panel.add(textPosServoID30);

		panel.add(labelPosServoID31);
		panel.add(textPosServoID31);
		
		panel.add(labelPosServoID32);
		panel.add(textPosServoID32);
		
		panel.add(labelPosServoID33);
		panel.add(textPosServoID33);
	
		panel.add(labelPosServoID34);
		panel.add(textPosServoID34);
	
		panel.add(labelPosServoID35);
		panel.add(textPosServoID35);
		
		this.add(panel);
	}
	
	public int getPosServoID10()
	{
		return Integer.parseInt(textPosServoID10.getText());
	}
	
	public void setPosServoID10(String data)
	{
		textPosServoID10.setText(data);
	}
	
	public int getPosServoID11()
	{
		return Integer.parseInt(textPosServoID11.getText());
	}
	
	public void setPosServoID11(String data)
	{
		textPosServoID11.setText(data);
	}
	
	public int getPosServoID20()
	{
		return Integer.parseInt(textPosServoID20.getText());
	}
	
	public void setPosServoID20(String data)
	{
		textPosServoID20.setText(data);
	}
	
	public int getPosServoID21()
	{
		return Integer.parseInt(textPosServoID21.getText());
	}
	
	public void setPosServoID21(String data)
	{
		textPosServoID21.setText(data);
	}
	
	public int getPosServoID22()
	{
		return Integer.parseInt(textPosServoID22.getText());
	}
	
	public void setPosServoID22(String data)
	{
		textPosServoID22.setText(data);
	}
	
	public int getPosServoID23()
	{
		return Integer.parseInt(textPosServoID23.getText());
	}
	
	public void setPosServoID23(String data)
	{
		textPosServoID23.setText(data);
	}
	
	public int getPosServoID24()
	{
		return Integer.parseInt(textPosServoID24.getText());
	}
	
	public void setPosServoID24(String data)
	{
		textPosServoID24.setText(data);
	}
	
	public int getPosServoID25()
	{
		return Integer.parseInt(textPosServoID25.getText());
	}
	
	public void setPosServoID25(String data)
	{
		textPosServoID25.setText(data);
	}
	
	public int getPosServoID30()
	{
		return Integer.parseInt(textPosServoID30.getText());
	}
	
	public void setPosServoID30(String data)
	{
		textPosServoID30.setText(data);
	}
	
	public int getPosServoID31()
	{
		return Integer.parseInt(textPosServoID31.getText());
	}
	
	public void setPosServoID31(String data)
	{
		textPosServoID31.setText(data);
	}
	
	public int getPosServoID32()
	{
		return Integer.parseInt(textPosServoID32.getText());
	}
	
	public void setPosServoID32(String data)
	{
		textPosServoID32.setText(data);
	}
	
	public int getPosServoID33()
	{
		return Integer.parseInt(textPosServoID33.getText());
	}
	
	public void setPosServoID33(String data)
	{
		textPosServoID33.setText(data);
	}
	
	public int getPosServoID34()
	{
		return Integer.parseInt(textPosServoID34.getText());
	}
	
	public void setPosServoID34(String data)
	{
		textPosServoID34.setText(data);
	}
	
	public int getPosServoID35()
	{
		return Integer.parseInt(textPosServoID35.getText());
	}
	
	public void setPosServoID35(String data)
	{
		textPosServoID35.setText(data);
	}
	
}
