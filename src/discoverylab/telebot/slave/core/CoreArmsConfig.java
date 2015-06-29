package discoverylab.telebot.slave.core;

import jssc.SerialPort;

/**
 * 
 * @author Irvin Steve Cardenas
 *
 */
public class CoreArmsConfig {
	
	public static final String 	DEFAULT_SERIAL_PORT_NAME 	=	"/dev/ttyTelebotHands";
	public static final int 	DEFAULT_SERIAL_BAUD_RATE 	=	57600;
	public static final int 	DEFAULT_SERIAL_DATA_BITS 	=	SerialPort.DATABITS_8;
	public static final int		DEFAULT_SERIAL_STOP_BITS 	=	SerialPort.STOPBITS_1;
	public static final int		DEFAULT_SERIAL_PARITY_TYPE 	=	SerialPort.PARITY_NONE;
	public static final int 	DEFAULT_SERIAL_EVENT_MASK	=	SerialPort.MASK_RXCHAR;
}
