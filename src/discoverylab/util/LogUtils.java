package discoverylab.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LogUtils {
	
//	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); Java Utils Logger = No Bueno
	private final static Logger logger = LoggerFactory.getLogger(LogUtils.class);
	
	private static final String LOG_PREFIX = "discoverylab";
	private static final int LOG_PREFIX_LENGTH = LOG_PREFIX.length();
	private static final int MAX_LOG_TAG_LENGTH = 23;
	
	public static String makeLogTag(String str) {
		if(str.length() > MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH){
			return LOG_PREFIX + str.substring(0, MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH);
		}
		return LOG_PREFIX + str;
	}
	
	public static String makeLogTag(Class cls) {
		return makeLogTag(cls.getSimpleName());
	}
	
	public static void LOGI(final String tag, String message) {
		logger.info(tag, message);
	}
	
	public static void LOGI(final String tag, String message, Throwable cause) {
		logger.info(tag, message, cause);
	}
	
	public static void LOGW(final String tag, String message) {
		logger.warn(tag, message);
	}
	
	public static void LOGW(final String tag, String message, Throwable cause) {
		logger.warn(tag, message, cause);
	}
	
	public static void LOGE(final String tag, String message){
		logger.error(tag, message);
	}
	
	public static void LEGE(final String tag, String message, Throwable cause){
		logger.error(tag, message, cause);
	}
	
	private LogUtils() {
		
	}
}
