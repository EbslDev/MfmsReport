package ebsl.mfms.report.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.factories.DbUtilsFactory;
import ebsl.mfms.report.models.eos.TblLocationEo;
import ebsl.mfms.report.models.sos.TblLocationSo;
import ebsl.mfms.report.utils.DbUtils;

public class TblLocationDao extends DaoBase<TblLocationEo>{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private static DbUtils mySqlDbUtils;
//	private static DbUtils db2DbUtils;
//	private static DbUtils msSqlDbUtils;
	private static DbUtilsFactory dbUtilsFactory;
	
	private final String selectSql = "select " +
	"l_Key, " + 
	"l_SiteKey, " +
	"l_Code, " +
	"l_Name, " +
	"l_Desc, " +
	"l_TagID, " +
	"l_ParentKey, " +
	"l_LevelKey, " +
	"l_Chain, " +
	"l_CreateBy, " +
	"l_CreateDateTime, " +
	"l_LastModifyBy, " +
	"l_LastModifyDateTime, " +
	"l_Deleted, " +
	"l_LastModifyTimeForSync " +
	"from " +
	"tbl_location ";
	
	private String getClassName() {
		return this.getClass().getName();
	}
	
	public TblLocationDao() throws Exception {
		super();
	}
	public TblLocationDao(String connectionType) throws Exception {
		super(connectionType);
	}
	@Override
	public List<TblLocationEo> read(Object so) throws Exception {
		List<TblLocationEo> tblLocationEoList = null;
		StringBuilder whereSql = null;
		PreparedStatement preparedStatement = null;
		try {

			if (so instanceof TblLocationSo == false) {
				throw new Exception("so is not an instanceof TblLocationSo");
			}
			TblLocationSo tblLocationSo = (TblLocationSo) so;
			
			whereSql = new StringBuilder("where ");
			int wcount = 0;
			
			if (tblLocationSo.getlKey() != null) {
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("l_Key = ? ");
				wcount++;
			}
			if (tblLocationSo.getlSiteKey() != null) {
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("l_SiteKey = ? ");
				wcount++;
			}
			if (tblLocationSo.getlCode() != null) {
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("l_Code = ? ");
				wcount++;
			}
			if (tblLocationSo.getlName() != null) {
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("l_Name = ? ");
				wcount++;
			}
			
			int pcount = 1;
			preparedStatement = connection.prepareStatement(selectSql + whereSql.toString());
			if (tblLocationSo.getlKey() != null) {
				preparedStatement.setInt(pcount, tblLocationSo.getlKey());
				pcount++;
			}
			if (tblLocationSo.getlSiteKey() != null) {
				preparedStatement.setInt(pcount, tblLocationSo.getlSiteKey());
				pcount++;
			}
			if (tblLocationSo.getlCode() != null) {
				preparedStatement.setString(pcount, tblLocationSo.getlCode());
				pcount++;
			}
			if (tblLocationSo.getlName() != null) {
				preparedStatement.setString(pcount, tblLocationSo.getlName());
				pcount++;
			}
			
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				if (tblLocationEoList == null) {
					tblLocationEoList = new ArrayList<TblLocationEo>();					
				}

				TblLocationEo eo = new TblLocationEo();
				Integer lKey = rs.getInt("l_Key");
				eo.setlKey(lKey);
				Integer lSiteKey = rs.getInt("l_SiteKey");
				eo.setlSiteKey(lSiteKey);
				String lCode = rs.getString("l_Code");
				eo.setlCode(lCode);
				String lName = rs.getString("l_Name");
				eo.setlName(lName);
				
				tblLocationEoList.add(eo);

			}
		}catch (Exception e) {
			logger.error(getClassName() + ".read() - so=" + so, e);
			throw e;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
				preparedStatement = null;
			}
			if (connectionType.equals(CONNECTION_TYPE_JDBC)) {
				if (connection != null) {
					connection.close();
					connection = null;
				}
			}
		}
		
		return tblLocationEoList;
	}
	@Override
	public void create(TblLocationEo eo) throws Exception {
		
		try {
			
		}catch (Exception e) {
			logger.error(getClassName() + ".create() - so=" + eo, e);
			throw e;
		}
	}
	@Override
	public void update(TblLocationEo eo) throws Exception {
		try {
			
		}catch (Exception e) {
			logger.error(getClassName() + ".update() - so=" + eo, e);
			throw e;
		}
		
	}
	@Override
	public void delete(TblLocationEo eo) throws Exception {
		try {
			
		}catch (Exception e) {
			logger.error(getClassName() + ".delete() - so=" + eo, e);
			throw e;
		}
		
	}


}
