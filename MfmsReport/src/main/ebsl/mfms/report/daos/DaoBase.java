package ebsl.mfms.report.daos;

import java.sql.Connection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.factories.DbUtilsFactory;
import ebsl.mfms.report.factories.GeneralUtilsFactory;
import ebsl.mfms.report.models.eos.TblLocationEo;
import ebsl.mfms.report.utils.DbUtils;
import ebsl.mfms.report.utils.MiscUtils;

public abstract class DaoBase <T>{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	public final static String CONNECTION_TYPE_JDBC = "jdbc";
	public final static String CONNECTION_TYPE_JNDI = "jndi";
	protected DbUtilsFactory dbUtilsFactory;
	protected DbUtils dbUtils;
	protected GeneralUtilsFactory generalUtilsFactory;
	protected MiscUtils miscUtils;
	protected Connection connection;
	protected String connectionType;
	private String getClassName() {
		String className = this.getClass().getName();
		return className;
	}
	public DaoBase() throws Exception {
		try {
			init();
		} catch (Exception e) {
			logger.error(getClassName() + ".DaoBase() - ", e);
			throw e;
		}
	}

	public DaoBase(String connectionType) throws Exception {
		try {
			init(connectionType);
		} catch (Exception e) {
			logger.error(getClassName() + ".DaoBase() - connectionType=" + connectionType, e);
			throw e;
		}
	}
	public void init() throws Exception {
		try {
			init(null);
		} catch (Exception e) {
			logger.error(getClassName() + ".init() - connectionType=" + connectionType, e);
			throw e;
		}
	}
	public void init(String connectionType) throws Exception {
		try {
			if (connectionType == null) {
				this.connectionType = CONNECTION_TYPE_JNDI;
			} else {
				this.connectionType = connectionType;
			}
			
			dbUtilsFactory = DbUtilsFactory.getInstanceOfDbUtilsFactory();
			dbUtils = dbUtilsFactory.getInstanceOfMySqlDbUtils();
			generalUtilsFactory = GeneralUtilsFactory.getInstanceOfGeneralUtilsFactory();
			miscUtils = generalUtilsFactory.getInstanceOfMiscUtils();
			connection = dbUtils.getConnection();
		} catch (Exception e) {
			logger.error(getClassName() + ".init() - connectionType=" + connectionType, e);
			throw e;
		}
	}
	public abstract List<T> read(Object so) throws Exception;
	public abstract Integer create(T eo) throws Exception;
	public abstract Integer update(T eo) throws Exception;
	public abstract Integer delete(T eo) throws Exception;

	
}
