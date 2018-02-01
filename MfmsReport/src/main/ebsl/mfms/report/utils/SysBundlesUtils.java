package ebsl.mfms.report.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.bundles.SysProperties;

public class SysBundlesUtils extends BundlesUtils <SysProperties>{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public SysBundlesUtils(String fileName) throws Exception {
		super(fileName);
	}


	private String getClassName(){
		String className = this.getClassName();
		return className;
	}
	@Override
	public SysProperties getProperties() throws Exception{
		SysProperties sysProperties = null;
		try{
			
			sysProperties = new SysProperties();
			String database = getPropValues("database");
			sysProperties.setDatabase(database);

			
			
		} catch (Exception e){
			logger.error(getClassName() + ".getSysProperties()", e);
			throw e;
		}
		return sysProperties;
	}







}
