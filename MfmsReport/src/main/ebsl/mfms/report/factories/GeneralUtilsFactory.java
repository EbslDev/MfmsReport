package ebsl.mfms.report.factories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.utils.MiscUtils;

public class GeneralUtilsFactory {
	private final static Logger logger = LoggerFactory.getLogger(getClassName());
	private static GeneralUtilsFactory generalUtilsFactory;
	private static MiscUtils miscUtils;
	public static String getClassName() {
		String className = GeneralUtilsFactory.class.getName();
		return className;
	}
	public static GeneralUtilsFactory getInstanceOfGeneralUtilsFactory() {
		if (generalUtilsFactory == null) {
			generalUtilsFactory = new GeneralUtilsFactory();
		}
		return generalUtilsFactory;
	}
	public MiscUtils getInstanceOfMiscUtils() {
		if (miscUtils == null) {
			miscUtils = new MiscUtils();
		}
		return miscUtils;
	}
}
