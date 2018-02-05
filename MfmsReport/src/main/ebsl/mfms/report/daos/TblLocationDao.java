package ebsl.mfms.report.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.models.eos.TblLocationEo;
import ebsl.mfms.report.models.sos.TblLocationSo;

public class TblLocationDao extends DaoBase<TblLocationEo>{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
//	private DbUtils mySqlDbUtils;
//	private static DbUtils db2DbUtils;
//	private static DbUtils msSqlDbUtils;

	private final String SELECT_SQL=
			"select " + 
			"l_Key " + 
			",l_SiteKey " + 
			",l_Code " + 
			",l_Name " + 
			",l_Desc " + 
			",l_TagID " + 
			",l_ParentKey " + 
			",l_LevelKey " + 
			",l_Chain " + 
			",l_CreateBy " + 
			",l_CreateDateTime " + 
			",l_LastModifyBy " + 
			",l_LastModifyDateTime " + 
			",l_Deleted " + 
			",l_LastModifyTimeForSync " + 
			"from tbl_location ";
	
	private final String INSERT_SQL=
			"insert " + 
			"into " + 
			"tbl_location " + 
			"(" + 
			"l_Key " + 
			",l_SiteKey " + 
			",l_Code " + 
			",l_Name " + 
			",l_Desc " + 
			",l_TagID " + 
			",l_ParentKey " + 
			",l_LevelKey " + 
			",l_Chain " + 
			",l_CreateBy " + 
			",l_CreateDateTime " + 
			",l_LastModifyBy " + 
			",l_LastModifyDateTime " + 
			",l_Deleted " + 
			",l_LastModifyTimeForSync " + 
			") " + 
			"values" + 
			"( " + 
			"? " + 
			",? " + 
			",? " + 
			",? " + 
			",? " + 
			",? " + 
			",? " + 
			",? " + 
			",? " + 
			",? " + 
			",? " + 
			",? " + 
			",? " + 
			",? " + 
			",? " + 
			") ";
	private final String UPDATE_SQL=
			"update " + 
			"tbl_location " + 
			"set " +
			"l_Key= ? " + 
			",l_SiteKey= ? " + 
			",l_Code= ? " + 
			",l_Name= ? " + 
			",l_Desc= ? " + 
			",l_TagID= ? " + 
			",l_ParentKey= ? " + 
			",l_LevelKey= ? " + 
			",l_Chain= ? " + 
			",l_CreateBy= ? " + 
			",l_CreateDateTime= ? " + 
			",l_LastModifyBy= ? " + 
			",l_LastModifyDateTime= ? " + 
			",l_Deleted= ? " + 
			",l_LastModifyTimeForSync= ? " + 
			"where l_Key = ? ";
	private final String DELETE_SQL=
			"delete " + 
			"from " + 
			"tbl_location " + 
			"where l_Key = ? ";	
	
	private String getClassName() {
		return this.getClass().getName();
	}
	
	public TblLocationDao() throws Exception {
		super();
	}
	public TblLocationDao(String connectionType) throws Exception {
		super(connectionType);
	}
	public List<TblLocationEo> read(Object so) throws Exception{
		List<TblLocationEo> tblLocationEoList = null;
		StringBuilder whereSql = null;
		PreparedStatement preparedStatement = null;
		try{
			if (so instanceof TblLocationSo == false) {
				throw new Exception("so is not an instanceof TblLocationSo");
			}
			TblLocationSo tblLocationSo = (TblLocationSo) so;
			whereSql = new StringBuilder("where ");
			int wcount = 0;
			if(tblLocationSo.getlKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("l_Key = ? ");
			}
			if(tblLocationSo.getlSiteKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("l_SiteKey = ? ");
			}
			if(tblLocationSo.getlCode() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("l_Code = ? ");
			}
			if(tblLocationSo.getlName() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("l_Name = ? ");
			}
			if(tblLocationSo.getlDesc() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("l_Desc = ? ");
			}
			if(tblLocationSo.getlTagID() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("l_TagID = ? ");
			}
			if(tblLocationSo.getlParentKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("l_ParentKey = ? ");
			}
			if(tblLocationSo.getlLevelKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("l_LevelKey = ? ");
			}
			if(tblLocationSo.getlChain() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("l_Chain = ? ");
			}
			if(tblLocationSo.getlCreateBy() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("l_CreateBy = ? ");
			}
			if(tblLocationSo.getlCreateDateTime() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("l_CreateDateTime = ? ");
			}
			if(tblLocationSo.getlLastModifyBy() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("l_LastModifyBy = ? ");
			}
			if(tblLocationSo.getlLastModifyDateTime() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("l_LastModifyDateTime = ? ");
			}
			if(tblLocationSo.getlDeleted() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("l_Deleted = ? ");
			}
			if(tblLocationSo.getlLastModifyTimeForSync() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("l_LastModifyTimeForSync = ? ");
			}
			int pcount = 1;
			preparedStatement = connection.prepareStatement(SELECT_SQL + whereSql.toString());
			if(tblLocationSo.getlKey() != null){
				preparedStatement.setInt(pcount, tblLocationSo.getlKey());
				pcount++;
			}
			if(tblLocationSo.getlSiteKey() != null){
				preparedStatement.setInt(pcount, tblLocationSo.getlSiteKey());
				pcount++;
			}
			if(tblLocationSo.getlCode() != null){
				preparedStatement.setString(pcount, tblLocationSo.getlCode());
				pcount++;
			}
			if(tblLocationSo.getlName() != null){
				preparedStatement.setString(pcount, tblLocationSo.getlName());
				pcount++;
			}
			if(tblLocationSo.getlDesc() != null){
				preparedStatement.setString(pcount, tblLocationSo.getlDesc());
				pcount++;
			}
			if(tblLocationSo.getlTagID() != null){
				preparedStatement.setString(pcount, tblLocationSo.getlTagID());
				pcount++;
			}
			if(tblLocationSo.getlParentKey() != null){
				preparedStatement.setInt(pcount, tblLocationSo.getlParentKey());
				pcount++;
			}
			if(tblLocationSo.getlLevelKey() != null){
				preparedStatement.setInt(pcount, tblLocationSo.getlLevelKey());
				pcount++;
			}
			if(tblLocationSo.getlChain() != null){
				preparedStatement.setString(pcount, tblLocationSo.getlChain());
				pcount++;
			}
			if(tblLocationSo.getlCreateBy() != null){
				preparedStatement.setInt(pcount, tblLocationSo.getlCreateBy());
				pcount++;
			}
			if(tblLocationSo.getlCreateDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(tblLocationSo.getlCreateDateTime()));
				pcount++;
			}
			if(tblLocationSo.getlLastModifyBy() != null){
				preparedStatement.setInt(pcount, tblLocationSo.getlLastModifyBy());
				pcount++;
			}
			if(tblLocationSo.getlLastModifyDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(tblLocationSo.getlLastModifyDateTime()));
				pcount++;
			}
			if(tblLocationSo.getlDeleted() != null){
				preparedStatement.setString(pcount, tblLocationSo.getlDeleted());
				pcount++;
			}
			if(tblLocationSo.getlLastModifyTimeForSync() != null){
				preparedStatement.setTimestamp(pcount, miscUtils.convertUtilDate2Timestamp(tblLocationSo.getlLastModifyTimeForSync()));
				pcount++;
			}
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				if (tblLocationEoList == null){
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
				String lDesc = rs.getString("l_Desc");
				eo.setlDesc(lDesc);
				String lTagID = rs.getString("l_TagID");
				eo.setlTagID(lTagID);
				Integer lParentKey = rs.getInt("l_ParentKey");
				eo.setlParentKey(lParentKey);
				Integer lLevelKey = rs.getInt("l_LevelKey");
				eo.setlLevelKey(lLevelKey);
				String lChain = rs.getString("l_Chain");
				eo.setlChain(lChain);
				Integer lCreateBy = rs.getInt("l_CreateBy");
				eo.setlCreateBy(lCreateBy);
				Date lCreateDateTime = rs.getTimestamp("l_CreateDateTime");
				eo.setlCreateDateTime(lCreateDateTime);
				Integer lLastModifyBy = rs.getInt("l_LastModifyBy");
				eo.setlLastModifyBy(lLastModifyBy);
				Date lLastModifyDateTime = rs.getTimestamp("l_LastModifyDateTime");
				eo.setlLastModifyDateTime(lLastModifyDateTime);
				String lDeleted = rs.getString("l_Deleted");
				eo.setlDeleted(lDeleted);
				Date lLastModifyTimeForSync = rs.getTimestamp("l_LastModifyTimeForSync");
				eo.setlLastModifyTimeForSync(lLastModifyTimeForSync);
				tblLocationEoList.add(eo);
			}
		}
		catch (Exception e){
			logger.error(getClassName() + ".read() - so=" + so, e);
			throw e;
		} // end try ... catch
		finally {
			if(preparedStatement != null){
				preparedStatement.close();
				preparedStatement = null;
			}
			if (connectionType.equals(CONNECTION_TYPE_JDBC)){
				if(connection != null) {
					connection.close();
					connection = null;
				}
			}
		}
		return tblLocationEoList;
	} // end select function

	@Override
	public Integer create(TblLocationEo eo) throws Exception {
		PreparedStatement preparedStatement = null;
		Integer noOfAffectedRow = null;
		try{
			int pcount = 1;
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			if(eo.getlKey() != null){
				preparedStatement.setInt(pcount, eo.getlKey());
				pcount++;
			}
			if(eo.getlSiteKey() != null){
				preparedStatement.setInt(pcount, eo.getlSiteKey());
				pcount++;
			}
			if(eo.getlCode() != null){
				preparedStatement.setString(pcount, eo.getlCode());
				pcount++;
			}
			if(eo.getlName() != null){
				preparedStatement.setString(pcount, eo.getlName());
				pcount++;
			}
			if(eo.getlDesc() != null){
				preparedStatement.setString(pcount, eo.getlDesc());
				pcount++;
			}
			if(eo.getlTagID() != null){
				preparedStatement.setString(pcount, eo.getlTagID());
				pcount++;
			}
			if(eo.getlParentKey() != null){
				preparedStatement.setInt(pcount, eo.getlParentKey());
				pcount++;
			}
			if(eo.getlLevelKey() != null){
				preparedStatement.setInt(pcount, eo.getlLevelKey());
				pcount++;
			}
			if(eo.getlChain() != null){
				preparedStatement.setString(pcount, eo.getlChain());
				pcount++;
			}
			if(eo.getlCreateBy() != null){
				preparedStatement.setInt(pcount, eo.getlCreateBy());
				pcount++;
			}
			if(eo.getlCreateDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getlCreateDateTime()));
				pcount++;
			}
			if(eo.getlLastModifyBy() != null){
				preparedStatement.setInt(pcount, eo.getlLastModifyBy());
				pcount++;
			}
			if(eo.getlLastModifyDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getlLastModifyDateTime()));
				pcount++;
			}
			if(eo.getlDeleted() != null){
				preparedStatement.setString(pcount, eo.getlDeleted());
				pcount++;
			}
			if(eo.getlLastModifyTimeForSync() != null){
				preparedStatement.setTimestamp(pcount, miscUtils.convertUtilDate2Timestamp(eo.getlLastModifyTimeForSync()));
				pcount++;
			}

			noOfAffectedRow = preparedStatement.executeUpdate();
			if (noOfAffectedRow.intValue() != 1) {
				throw new Exception("insert failed! affectedRow=" + noOfAffectedRow);
			}
		}
		catch (Exception e){
			logger.error(getClassName() + ".create() - eo=" + eo, e);
			throw e;
		} // end try ... catch
		finally {
			if(preparedStatement != null){
				preparedStatement.close();
				preparedStatement = null;
			}
			if (connectionType.equals(CONNECTION_TYPE_JDBC)){
				if(connection != null) {
					connection.close();
					connection = null;
				}
			}
		}	
		return noOfAffectedRow;
	}

	@Override
	public Integer update(TblLocationEo eo) throws Exception {
		PreparedStatement preparedStatement = null;
		Integer noOfAffectedRow = null;
		try{
			int pcount = 1;
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			if(eo.getlKey() != null){
				preparedStatement.setInt(pcount, eo.getlKey());
				pcount++;
			}
			if(eo.getlSiteKey() != null){
				preparedStatement.setInt(pcount, eo.getlSiteKey());
				pcount++;
			}
			if(eo.getlCode() != null){
				preparedStatement.setString(pcount, eo.getlCode());
				pcount++;
			}
			if(eo.getlName() != null){
				preparedStatement.setString(pcount, eo.getlName());
				pcount++;
			}
			if(eo.getlDesc() != null){
				preparedStatement.setString(pcount, eo.getlDesc());
				pcount++;
			}
			if(eo.getlTagID() != null){
				preparedStatement.setString(pcount, eo.getlTagID());
				pcount++;
			}
			if(eo.getlParentKey() != null){
				preparedStatement.setInt(pcount, eo.getlParentKey());
				pcount++;
			}
			if(eo.getlLevelKey() != null){
				preparedStatement.setInt(pcount, eo.getlLevelKey());
				pcount++;
			}
			if(eo.getlChain() != null){
				preparedStatement.setString(pcount, eo.getlChain());
				pcount++;
			}
			if(eo.getlCreateBy() != null){
				preparedStatement.setInt(pcount, eo.getlCreateBy());
				pcount++;
			}
			if(eo.getlCreateDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getlCreateDateTime()));
				pcount++;
			}
			if(eo.getlLastModifyBy() != null){
				preparedStatement.setInt(pcount, eo.getlLastModifyBy());
				pcount++;
			}
			if(eo.getlLastModifyDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getlLastModifyDateTime()));
				pcount++;
			}
			if(eo.getlDeleted() != null){
				preparedStatement.setString(pcount, eo.getlDeleted());
				pcount++;
			}
			if(eo.getlLastModifyTimeForSync() != null){
				preparedStatement.setTimestamp(pcount, miscUtils.convertUtilDate2Timestamp(eo.getlLastModifyTimeForSync()));
				pcount++;
			}
			if(eo.getlKey() != null){
				preparedStatement.setInt(pcount, eo.getlKey());
				pcount++;
			}
			noOfAffectedRow = preparedStatement.executeUpdate();
			if (noOfAffectedRow.intValue() != 1) {
				throw new Exception("insert failed! affectedRow=" + noOfAffectedRow);
			}
		}
		catch (Exception e){
			logger.error(getClassName() + ".update() - eo=" + eo, e);
			throw e;
		} // end try ... catch
		finally {
			if(preparedStatement != null){
				preparedStatement.close();
				preparedStatement = null;
			}
			if (connectionType.equals(CONNECTION_TYPE_JDBC)){
				if(connection != null) {
					connection.close();
					connection = null;
				}
			}
		}	
		return noOfAffectedRow;
	}

	@Override
	public Integer delete(TblLocationEo eo) throws Exception {
		PreparedStatement preparedStatement = null;
		Integer noOfAffectedRow = null;
		try{
			int pcount = 1;
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			if(eo.getlKey() != null){
				preparedStatement.setInt(pcount, eo.getlKey());
				pcount++;
			}
			noOfAffectedRow = preparedStatement.executeUpdate();
			if (noOfAffectedRow.intValue() != 1) {
				throw new Exception("delete failed! affectedRow=" + noOfAffectedRow);
			}
		}
		catch (Exception e){
			logger.error(getClassName() + ".delete() - eo=" + eo, e);
			throw e;
		} // end try ... catch
		finally {
			if(preparedStatement != null){
				preparedStatement.close();
				preparedStatement = null;
			}
			if (connectionType.equals(CONNECTION_TYPE_JDBC)){
				if(connection != null) {
					connection.close();
					connection = null;
				}
			}
		}	
		return noOfAffectedRow;
	}


}
