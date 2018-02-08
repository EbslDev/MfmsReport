package ebsl.mfms.report.factories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.bundles.MysqlDbProperties;
import ebsl.mfms.report.bundles.ReportProperties;
import ebsl.mfms.report.bundles.SysProperties;
import ebsl.mfms.report.factories.builders.BundlesBuilder;
import ebsl.mfms.report.factories.builders.MysqlDbBundlesBuilder;
import ebsl.mfms.report.factories.builders.ReportBundlesBuilder;
import ebsl.mfms.report.factories.builders.SysBundlesBuilder;

public class PropertiesFactory {
	private final static Logger logger = LoggerFactory.getLogger(PropertiesFactory.class);
	private final static String className = PropertiesFactory.class.getName();
	
	
	private BundlesBuilder<SysProperties> sysBundlesBuilder;
	private BundlesBuilder<ReportProperties> reportBundleBuilder;
	private final String SYS_PROPERTIES_FILE = "sys.properties";
	private final String MYSQL_DB_PROPERTIES_FILE = "mysql.db.properties";
	private final String REPORT_PROPERTIES_FILE = "report.properties";
	private static PropertiesFactory propertiesFactory;
	private static MysqlDbProperties mysqlDbProperties;
	private static SysProperties sysProperties;
	private static ReportProperties reportProperties;
	private String getClassName() {
		String className = this.getClassName();
		return className;
	}
	private PropertiesFactory() throws Exception{
		try {
			init();
		} catch (Exception e) {
			logger.error(getClassName() + ".PropertiesFactory()", e);
		}
	}

	private void init() throws Exception {
		try {


		} catch (Exception e) {
			logger.error(getClassName() + ".BundlesFactory()", e);
		}
	}
	
	public static PropertiesFactory getInstanceOfPropertiesFactory() throws Exception {
		try {
			if (propertiesFactory == null) {
				propertiesFactory = new PropertiesFactory();
			}
		} catch (Exception e) {
			logger.error(className + ".getInstanceOfPropertiesFactory() - ", e);
		}
		return propertiesFactory;
	}
	
	public MysqlDbProperties getInstanceOfMySqlDbProperties() throws Exception {
		try {
			if (mysqlDbProperties == null) {
				BundlesBuilder<MysqlDbProperties> mysqlDbBundlesBuilder = new MysqlDbBundlesBuilder(MYSQL_DB_PROPERTIES_FILE);
				mysqlDbProperties = mysqlDbBundlesBuilder.build();
			}

		} catch (Exception e) {
			logger.error(className + ".getInstanceOfMySqlDbProperties() - ", e);
		}
		return mysqlDbProperties;
	}
	
	public SysProperties getInstanceOfSysProperties() throws Exception {
		try {
			if(sysBundlesBuilder == null) {
				sysBundlesBuilder = new SysBundlesBuilder(SYS_PROPERTIES_FILE);
			}
			sysProperties = (SysProperties) sysBundlesBuilder.build();
			if (sysProperties == null) {
				throw new Exception(SYS_PROPERTIES_FILE + " does not exist!");
			}

		} catch (Exception ex) {
			logger.error(className + ".getInstanceOfSysProperties() - ", ex);
			throw ex;
		}
		return sysProperties;
	}
	
	public ReportProperties getInstanceOfReportProperties() throws Exception {
		try {
			if(reportBundleBuilder == null) {
				reportBundleBuilder = new ReportBundlesBuilder(REPORT_PROPERTIES_FILE);
			}
			reportProperties = (ReportProperties) reportBundleBuilder.build();
			if (reportProperties == null) {
				throw new Exception(REPORT_PROPERTIES_FILE + " does not exist!");
			}

		} catch (Exception ex) {
			logger.error(className + ".getInstanceOfReportProperties() - ", ex);
			throw ex;
		}
		return reportProperties;
	}

}
