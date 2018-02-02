package ebsl.mfms.report.factories.builders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ebsl.mfms.report.bundles.SysProperties;
public class SysBundlesBuilder extends BundlesBuilder<SysProperties>{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private String className;
	public SysBundlesBuilder(String fileName) throws Exception{
		super(fileName);
	}
	private String getClassName(){
		if(className == null){
			className = this.getClass().getName();
		}
		return className;
	}
	@Override
	public SysProperties build() throws Exception{
		 SysProperties sysProperties= null;
		try{
			sysProperties = new SysProperties();
			String database = getPropValues("database");
			sysProperties.setDatabase(database);
			String deployType = getPropValues("deploy_type");
			sysProperties.setDeployType(deployType);
		} catch (Exception e) {
			this.logger.error(getClassName() + ".build() - this.fileName=" + this.fileName, e);
			throw e;
		}
		return sysProperties;
	}
}
