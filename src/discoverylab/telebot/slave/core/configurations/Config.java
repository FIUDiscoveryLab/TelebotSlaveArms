package discoverylab.telebot.slave.core.configurations;

import jssc.SerialPort;

/**
 * 
 * @author Irvin Steve Cardenas
 *
 */
public class Config {
	
	public static final String	AUTHORS				= 	"Irvin Steve Cardenas @kPatch";
	public static final String 	VERSION				=	"v0.5";
	public static final String 	SERIAL_PORT_NAME 	=	"/dev/ttyUSB0";
	public static final int 	SERIAL_BAUD_RATE 	=	57600;
	public static final int 	SERIAL_DATA_BITS 	=	SerialPort.DATABITS_8;
	public static final int		SERIAL_STOP_BITS 	=	SerialPort.STOPBITS_1;
	public static final int		SERIAL_PARITY_TYPE 	=	SerialPort.PARITY_NONE;
	public static final int 	SERIAL_EVENT_MASK	=	SerialPort.MASK_RXCHAR;
}