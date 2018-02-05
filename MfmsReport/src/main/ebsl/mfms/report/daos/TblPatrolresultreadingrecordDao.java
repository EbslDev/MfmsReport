package ebsl.mfms.report.daos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.models.eos.TblPatrolresultreadingrecordEo;
import ebsl.mfms.report.models.sos.TblPatrolresultreadingrecordSo;
public class TblPatrolresultreadingrecordDao extends DaoBase<TblPatrolresultreadingrecordEo>{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private final String SELECT_SQL=
			"select " + 
			"prrr_Key " + 
			",prrr_SiteKey " + 
			",prrr_PatrolResultKey " + 
			",prrr_PatrolScheduleKey " + 
			",prrr_RouteDefKey " + 
			",prrr_LocationKey " + 
			",prrr_ReadingResult " + 
			",prrr_RecordStatus " + 
			",prrr_EnableChecking " + 
			",prrr_CreateBy " + 
			",prrr_CreateDateTime " + 
			",prrr_LastModifyBy " + 
			",prrr_LastModifyDateTime " + 
			",prrr_LastModifyTimeForSync " + 
			",prrr_MinRange " + 
			",prrr_MaxRange " + 
			"from tbl_patrolresultreadingrecord ";
	private final String INSERT_SQL=
			"insert " + 
			"into " + 
			"tbl_patrolresultreadingrecord " + 
			"( " + 
			"prrr_Key " + 
			",prrr_SiteKey " + 
			",prrr_PatrolResultKey " + 
			",prrr_PatrolScheduleKey " + 
			",prrr_RouteDefKey " + 
			",prrr_LocationKey " + 
			",prrr_ReadingResult " + 
			",prrr_RecordStatus " + 
			",prrr_EnableChecking " + 
			",prrr_CreateBy " + 
			",prrr_CreateDateTime " + 
			",prrr_LastModifyBy " + 
			",prrr_LastModifyDateTime " + 
			",prrr_LastModifyTimeForSync " + 
			",prrr_MinRange " + 
			",prrr_MaxRange " + 
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
			",? " + 
			") ";
	private final String UPDATE_SQL=
			"update " + 
			"tbl_patrolresultreadingrecord " + 
			"set " + 
			"prrr_Key= ? " + 
			",prrr_SiteKey= ? " + 
			",prrr_PatrolResultKey= ? " + 
			",prrr_PatrolScheduleKey= ? " + 
			",prrr_RouteDefKey= ? " + 
			",prrr_LocationKey= ? " + 
			",prrr_ReadingResult= ? " + 
			",prrr_RecordStatus= ? " + 
			",prrr_EnableChecking= ? " + 
			",prrr_CreateBy= ? " + 
			",prrr_CreateDateTime= ? " + 
			",prrr_LastModifyBy= ? " + 
			",prrr_LastModifyDateTime= ? " + 
			",prrr_LastModifyTimeForSync= ? " + 
			",prrr_MinRange= ? " + 
			",prrr_MaxRange= ? " + 
			"where prrr_Key = ? ";
	private final String DELETE_SQL=
			"delete " + 
			"from " + 
			"tbl_patrolresultreadingrecord " + 
			"where prrr_Key = ? ";
	private String getClassName(){
		return this.getClass().getName();
	}
	public TblPatrolresultreadingrecordDao() throws Exception {
		super();
	}
	public TblPatrolresultreadingrecordDao(String connectionType) throws Exception {
		super(connectionType);
	}
	@Override
	public List<TblPatrolresultreadingrecordEo> read(Object so) throws Exception{
		List<TblPatrolresultreadingrecordEo> tblPatrolresultreadingrecordEoList = null;
		StringBuilder whereSql = null;
		PreparedStatement preparedStatement = null;
		try{
			if (so instanceof TblPatrolresultreadingrecordSo == false) {
				throw new Exception("so is not an instanceof TblPatrolresultreadingrecordSo");
			}
			TblPatrolresultreadingrecordSo tblPatrolresultreadingrecordSo = (TblPatrolresultreadingrecordSo) so;
			whereSql = new StringBuilder("where ");
			int wcount = 0;
			if(tblPatrolresultreadingrecordSo.getPrrrKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("prrr_Key = ? ");
			}
			if(tblPatrolresultreadingrecordSo.getPrrrSiteKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("prrr_SiteKey = ? ");
			}
			if(tblPatrolresultreadingrecordSo.getPrrrPatrolResultKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("prrr_PatrolResultKey = ? ");
			}
			if(tblPatrolresultreadingrecordSo.getPrrrPatrolScheduleKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("prrr_PatrolScheduleKey = ? ");
			}
			if(tblPatrolresultreadingrecordSo.getPrrrRouteDefKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("prrr_RouteDefKey = ? ");
			}
			if(tblPatrolresultreadingrecordSo.getPrrrLocationKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("prrr_LocationKey = ? ");
			}
			if(tblPatrolresultreadingrecordSo.getPrrrReadingResult() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("prrr_ReadingResult = ? ");
			}
			if(tblPatrolresultreadingrecordSo.getPrrrRecordStatus() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("prrr_RecordStatus = ? ");
			}
			if(tblPatrolresultreadingrecordSo.getPrrrEnableChecking() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("prrr_EnableChecking = ? ");
			}
			if(tblPatrolresultreadingrecordSo.getPrrrCreateBy() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("prrr_CreateBy = ? ");
			}
			if(tblPatrolresultreadingrecordSo.getPrrrCreateDateTime() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("prrr_CreateDateTime = ? ");
			}
			if(tblPatrolresultreadingrecordSo.getPrrrLastModifyBy() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("prrr_LastModifyBy = ? ");
			}
			if(tblPatrolresultreadingrecordSo.getPrrrLastModifyDateTime() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("prrr_LastModifyDateTime = ? ");
			}
			if(tblPatrolresultreadingrecordSo.getPrrrLastModifyTimeForSync() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("prrr_LastModifyTimeForSync = ? ");
			}
			if(tblPatrolresultreadingrecordSo.getPrrrMinRange() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("prrr_MinRange = ? ");
			}
			if(tblPatrolresultreadingrecordSo.getPrrrMaxRange() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("prrr_MaxRange = ? ");
			}
			int pcount = 1;
			preparedStatement = connection.prepareStatement(SELECT_SQL + whereSql.toString());
			if(tblPatrolresultreadingrecordSo.getPrrrKey() != null){
				preparedStatement.setInt(pcount, tblPatrolresultreadingrecordSo.getPrrrKey());
				pcount++;
			}
			if(tblPatrolresultreadingrecordSo.getPrrrSiteKey() != null){
				preparedStatement.setInt(pcount, tblPatrolresultreadingrecordSo.getPrrrSiteKey());
				pcount++;
			}
			if(tblPatrolresultreadingrecordSo.getPrrrPatrolResultKey() != null){
				preparedStatement.setInt(pcount, tblPatrolresultreadingrecordSo.getPrrrPatrolResultKey());
				pcount++;
			}
			if(tblPatrolresultreadingrecordSo.getPrrrPatrolScheduleKey() != null){
				preparedStatement.setInt(pcount, tblPatrolresultreadingrecordSo.getPrrrPatrolScheduleKey());
				pcount++;
			}
			if(tblPatrolresultreadingrecordSo.getPrrrRouteDefKey() != null){
				preparedStatement.setInt(pcount, tblPatrolresultreadingrecordSo.getPrrrRouteDefKey());
				pcount++;
			}
			if(tblPatrolresultreadingrecordSo.getPrrrLocationKey() != null){
				preparedStatement.setInt(pcount, tblPatrolresultreadingrecordSo.getPrrrLocationKey());
				pcount++;
			}
			if(tblPatrolresultreadingrecordSo.getPrrrReadingResult() != null){
				preparedStatement.setString(pcount, tblPatrolresultreadingrecordSo.getPrrrReadingResult());
				pcount++;
			}
			if(tblPatrolresultreadingrecordSo.getPrrrRecordStatus() != null){
				preparedStatement.setString(pcount, tblPatrolresultreadingrecordSo.getPrrrRecordStatus());
				pcount++;
			}
			if(tblPatrolresultreadingrecordSo.getPrrrEnableChecking() != null){
				preparedStatement.setString(pcount, tblPatrolresultreadingrecordSo.getPrrrEnableChecking());
				pcount++;
			}
			if(tblPatrolresultreadingrecordSo.getPrrrCreateBy() != null){
				preparedStatement.setInt(pcount, tblPatrolresultreadingrecordSo.getPrrrCreateBy());
				pcount++;
			}
			if(tblPatrolresultreadingrecordSo.getPrrrCreateDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(tblPatrolresultreadingrecordSo.getPrrrCreateDateTime()));
				pcount++;
			}
			if(tblPatrolresultreadingrecordSo.getPrrrLastModifyBy() != null){
				preparedStatement.setInt(pcount, tblPatrolresultreadingrecordSo.getPrrrLastModifyBy());
				pcount++;
			}
			if(tblPatrolresultreadingrecordSo.getPrrrLastModifyDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(tblPatrolresultreadingrecordSo.getPrrrLastModifyDateTime()));
				pcount++;
			}
			if(tblPatrolresultreadingrecordSo.getPrrrLastModifyTimeForSync() != null){
				preparedStatement.setTimestamp(pcount, miscUtils.convertUtilDate2Timestamp(tblPatrolresultreadingrecordSo.getPrrrLastModifyTimeForSync()));
				pcount++;
			}
			if(tblPatrolresultreadingrecordSo.getPrrrMinRange() != null){
				preparedStatement.setString(pcount, tblPatrolresultreadingrecordSo.getPrrrMinRange());
				pcount++;
			}
			if(tblPatrolresultreadingrecordSo.getPrrrMaxRange() != null){
				preparedStatement.setString(pcount, tblPatrolresultreadingrecordSo.getPrrrMaxRange());
				pcount++;
			}
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				if (tblPatrolresultreadingrecordEoList == null){
					tblPatrolresultreadingrecordEoList = new ArrayList<TblPatrolresultreadingrecordEo>();
				}
				TblPatrolresultreadingrecordEo eo = new TblPatrolresultreadingrecordEo();
				Integer prrrKey = rs.getInt("prrr_Key");
				eo.setPrrrKey(prrrKey);
				Integer prrrSiteKey = rs.getInt("prrr_SiteKey");
				eo.setPrrrSiteKey(prrrSiteKey);
				Integer prrrPatrolResultKey = rs.getInt("prrr_PatrolResultKey");
				eo.setPrrrPatrolResultKey(prrrPatrolResultKey);
				Integer prrrPatrolScheduleKey = rs.getInt("prrr_PatrolScheduleKey");
				eo.setPrrrPatrolScheduleKey(prrrPatrolScheduleKey);
				Integer prrrRouteDefKey = rs.getInt("prrr_RouteDefKey");
				eo.setPrrrRouteDefKey(prrrRouteDefKey);
				Integer prrrLocationKey = rs.getInt("prrr_LocationKey");
				eo.setPrrrLocationKey(prrrLocationKey);
				String prrrReadingResult = rs.getString("prrr_ReadingResult");
				eo.setPrrrReadingResult(prrrReadingResult);
				String prrrRecordStatus = rs.getString("prrr_RecordStatus");
				eo.setPrrrRecordStatus(prrrRecordStatus);
				String prrrEnableChecking = rs.getString("prrr_EnableChecking");
				eo.setPrrrEnableChecking(prrrEnableChecking);
				Integer prrrCreateBy = rs.getInt("prrr_CreateBy");
				eo.setPrrrCreateBy(prrrCreateBy);
				Date prrrCreateDateTime = rs.getDate("prrr_CreateDateTime");
				eo.setPrrrCreateDateTime(prrrCreateDateTime);
				Integer prrrLastModifyBy = rs.getInt("prrr_LastModifyBy");
				eo.setPrrrLastModifyBy(prrrLastModifyBy);
				Date prrrLastModifyDateTime = rs.getDate("prrr_LastModifyDateTime");
				eo.setPrrrLastModifyDateTime(prrrLastModifyDateTime);
				Date prrrLastModifyTimeForSync = rs.getTimestamp("prrr_LastModifyTimeForSync");
				eo.setPrrrLastModifyTimeForSync(prrrLastModifyTimeForSync);
				String prrrMinRange = rs.getString("prrr_MinRange");
				eo.setPrrrMinRange(prrrMinRange);
				String prrrMaxRange = rs.getString("prrr_MaxRange");
				eo.setPrrrMaxRange(prrrMaxRange);
				tblPatrolresultreadingrecordEoList.add(eo);
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
		return tblPatrolresultreadingrecordEoList;
	} // end select function
	@Override
	public Integer create(TblPatrolresultreadingrecordEo eo) throws Exception{
		PreparedStatement preparedStatement = null;
		Integer noOfAffectedRow = null;
		try{
			int pcount = 1;
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			if(eo.getPrrrKey() != null){
				preparedStatement.setInt(pcount, eo.getPrrrKey());
				pcount++;
			}
			if(eo.getPrrrSiteKey() != null){
				preparedStatement.setInt(pcount, eo.getPrrrSiteKey());
				pcount++;
			}
			if(eo.getPrrrPatrolResultKey() != null){
				preparedStatement.setInt(pcount, eo.getPrrrPatrolResultKey());
				pcount++;
			}
			if(eo.getPrrrPatrolScheduleKey() != null){
				preparedStatement.setInt(pcount, eo.getPrrrPatrolScheduleKey());
				pcount++;
			}
			if(eo.getPrrrRouteDefKey() != null){
				preparedStatement.setInt(pcount, eo.getPrrrRouteDefKey());
				pcount++;
			}
			if(eo.getPrrrLocationKey() != null){
				preparedStatement.setInt(pcount, eo.getPrrrLocationKey());
				pcount++;
			}
			if(eo.getPrrrReadingResult() != null){
				preparedStatement.setString(pcount, eo.getPrrrReadingResult());
				pcount++;
			}
			if(eo.getPrrrRecordStatus() != null){
				preparedStatement.setString(pcount, eo.getPrrrRecordStatus());
				pcount++;
			}
			if(eo.getPrrrEnableChecking() != null){
				preparedStatement.setString(pcount, eo.getPrrrEnableChecking());
				pcount++;
			}
			if(eo.getPrrrCreateBy() != null){
				preparedStatement.setInt(pcount, eo.getPrrrCreateBy());
				pcount++;
			}
			if(eo.getPrrrCreateDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getPrrrCreateDateTime()));
				pcount++;
			}
			if(eo.getPrrrLastModifyBy() != null){
				preparedStatement.setInt(pcount, eo.getPrrrLastModifyBy());
				pcount++;
			}
			if(eo.getPrrrLastModifyDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getPrrrLastModifyDateTime()));
				pcount++;
			}
			if(eo.getPrrrLastModifyTimeForSync() != null){
				preparedStatement.setTimestamp(pcount, miscUtils.convertUtilDate2Timestamp(eo.getPrrrLastModifyTimeForSync()));
				pcount++;
			}
			if(eo.getPrrrMinRange() != null){
				preparedStatement.setString(pcount, eo.getPrrrMinRange());
				pcount++;
			}
			if(eo.getPrrrMaxRange() != null){
				preparedStatement.setString(pcount, eo.getPrrrMaxRange());
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
	} // end create function
	@Override
	public Integer update(TblPatrolresultreadingrecordEo eo) throws Exception{
		PreparedStatement preparedStatement = null;
		Integer noOfAffectedRow = null;
		try{
			int pcount = 1;
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			if(eo.getPrrrKey() != null){
				preparedStatement.setInt(pcount, eo.getPrrrKey());
				pcount++;
			}
			if(eo.getPrrrSiteKey() != null){
				preparedStatement.setInt(pcount, eo.getPrrrSiteKey());
				pcount++;
			}
			if(eo.getPrrrPatrolResultKey() != null){
				preparedStatement.setInt(pcount, eo.getPrrrPatrolResultKey());
				pcount++;
			}
			if(eo.getPrrrPatrolScheduleKey() != null){
				preparedStatement.setInt(pcount, eo.getPrrrPatrolScheduleKey());
				pcount++;
			}
			if(eo.getPrrrRouteDefKey() != null){
				preparedStatement.setInt(pcount, eo.getPrrrRouteDefKey());
				pcount++;
			}
			if(eo.getPrrrLocationKey() != null){
				preparedStatement.setInt(pcount, eo.getPrrrLocationKey());
				pcount++;
			}
			if(eo.getPrrrReadingResult() != null){
				preparedStatement.setString(pcount, eo.getPrrrReadingResult());
				pcount++;
			}
			if(eo.getPrrrRecordStatus() != null){
				preparedStatement.setString(pcount, eo.getPrrrRecordStatus());
				pcount++;
			}
			if(eo.getPrrrEnableChecking() != null){
				preparedStatement.setString(pcount, eo.getPrrrEnableChecking());
				pcount++;
			}
			if(eo.getPrrrCreateBy() != null){
				preparedStatement.setInt(pcount, eo.getPrrrCreateBy());
				pcount++;
			}
			if(eo.getPrrrCreateDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getPrrrCreateDateTime()));
				pcount++;
			}
			if(eo.getPrrrLastModifyBy() != null){
				preparedStatement.setInt(pcount, eo.getPrrrLastModifyBy());
				pcount++;
			}
			if(eo.getPrrrLastModifyDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getPrrrLastModifyDateTime()));
				pcount++;
			}
			if(eo.getPrrrLastModifyTimeForSync() != null){
				preparedStatement.setTimestamp(pcount, miscUtils.convertUtilDate2Timestamp(eo.getPrrrLastModifyTimeForSync()));
				pcount++;
			}
			if(eo.getPrrrMinRange() != null){
				preparedStatement.setString(pcount, eo.getPrrrMinRange());
				pcount++;
			}
			if(eo.getPrrrMaxRange() != null){
				preparedStatement.setString(pcount, eo.getPrrrMaxRange());
				pcount++;
			}
			if(eo.getPrrrKey() != null){
				preparedStatement.setInt(pcount, eo.getPrrrKey());
				pcount++;
			}
			noOfAffectedRow = preparedStatement.executeUpdate();
			if (noOfAffectedRow.intValue() != 1) {
				throw new Exception("update failed! affectedRow=" + noOfAffectedRow);
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
	} // end update function
	@Override
	public Integer delete(TblPatrolresultreadingrecordEo eo) throws Exception{
		PreparedStatement preparedStatement = null;
		Integer noOfAffectedRow = null;
		try{
			int pcount = 1;
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			if(eo.getPrrrKey() != null){
				preparedStatement.setInt(pcount, eo.getPrrrKey());
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
	} // end delete function
} //end class
