package ebsl.mfms.report.daos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.models.eos.TblPatrolresultEo;
import ebsl.mfms.report.models.sos.ExportPatrolRoutineSo;
import ebsl.mfms.report.models.sos.TblPatrolresultSo;
import ebsl.mfms.report.models.vos.ExportPatrolRoutineVo;
public class TblPatrolresultDao extends DaoBase<TblPatrolresultEo>{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private final String SELECT_SQL=
			"select " + 
			"pr_Key " + 
			",pr_SiteKey " + 
			",pr_RouteDefKey " + 
			",pr_GroupNum " + 
			",pr_CoLocationKey " + 
			",pr_LocationKey " + 
			",pr_SeqNum " + 
			",pr_TimeAttended " + 
			",pr_PersonAttended " + 
			",pr_Reason " + 
			",pr_Completed " + 
			",pr_CreateBy " + 
			",pr_CreateDateTime " + 
			",pr_LastModifyBy " + 
			",pr_LastModifyDateTime " + 
			",pr_Deleted " + 
			",pr_LastModifyTimeForSync " + 
			",pr_PatrolScheduleKey " + 
			",pr_PatrolStatus " + 
			",pr_MinPtDur " + 
			",pr_MinPtDurUnit " + 
			",pr_MaxPtDur " + 
			",pr_MaxPtDurUnit " + 
			"from tbl_patrolresult ";
	private final String INSERT_SQL=
			"insert " + 
			"into " + 
			"tbl_patrolresult " + 
			"( " + 
			"pr_Key " + 
			",pr_SiteKey " + 
			",pr_RouteDefKey " + 
			",pr_GroupNum " + 
			",pr_CoLocationKey " + 
			",pr_LocationKey " + 
			",pr_SeqNum " + 
			",pr_TimeAttended " + 
			",pr_PersonAttended " + 
			",pr_Reason " + 
			",pr_Completed " + 
			",pr_CreateBy " + 
			",pr_CreateDateTime " + 
			",pr_LastModifyBy " + 
			",pr_LastModifyDateTime " + 
			",pr_Deleted " + 
			",pr_LastModifyTimeForSync " + 
			",pr_PatrolScheduleKey " + 
			",pr_PatrolStatus " + 
			",pr_MinPtDur " + 
			",pr_MinPtDurUnit " + 
			",pr_MaxPtDur " + 
			",pr_MaxPtDurUnit " + 
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
			"tbl_patrolresult " + 
			"set " + 
			"pr_Key= ? " + 
			",pr_SiteKey= ? " + 
			",pr_RouteDefKey= ? " + 
			",pr_GroupNum= ? " + 
			",pr_CoLocationKey= ? " + 
			",pr_LocationKey= ? " + 
			",pr_SeqNum= ? " + 
			",pr_TimeAttended= ? " + 
			",pr_PersonAttended= ? " + 
			",pr_Reason= ? " + 
			",pr_Completed= ? " + 
			",pr_CreateBy= ? " + 
			",pr_CreateDateTime= ? " + 
			",pr_LastModifyBy= ? " + 
			",pr_LastModifyDateTime= ? " + 
			",pr_Deleted= ? " + 
			",pr_LastModifyTimeForSync= ? " + 
			",pr_PatrolScheduleKey= ? " + 
			",pr_PatrolStatus= ? " + 
			",pr_MinPtDur= ? " + 
			",pr_MinPtDurUnit= ? " + 
			",pr_MaxPtDur= ? " + 
			",pr_MaxPtDurUnit= ? " + 
			"where pr_Key = ? ";
	private final String DELETE_SQL=
			"delete " + 
			"from " + 
			"tbl_patrolresult " + 
			"where pr_Key = ? ";
	private final String SELECT_JOIN_SQL = 
			"select " +
		    "rd.rd_Code, " +
			"prrr.prrr_PatrolResultKey, " +
		    "l.l_Code, " +
			"l.l_Name, " +
		    "pr.pr_TimeAttended " +
			"from " +
		    "tbl_patrolresult pr " +
			"inner join tbl_patrolresultreadingrecord prrr " +
		    "on prrr.prrr_PatrolResultKey = pr.pr_Key " +
			"inner join tbl_routedef rd on " +
		    "pr.pr_RouteDefKey = rd.rd_Key " +
			"inner join tbl_location l on " +
		    "pr.pr_LocationKey = l.l_Key ";
	private String getClassName(){
		return this.getClass().getName();
	}
	public TblPatrolresultDao() throws Exception {
		super();
	}
	public TblPatrolresultDao(String connectionType) throws Exception {
		super(connectionType);
	}
	public List<ExportPatrolRoutineVo> readByExportPatrolRoutineSo(Object so) throws Exception{
		List<ExportPatrolRoutineVo> exportPatrolRoutineVoList = null;
		StringBuilder whereSql = null;
		PreparedStatement preparedStatement = null;
		try{
			if (so instanceof ExportPatrolRoutineSo == false) {
				throw new Exception("so is not an instanceof ExportPatrolRoutineSo");
			}
			ExportPatrolRoutineSo exportPatrolRoutineSo = (ExportPatrolRoutineSo) so;
			whereSql = new StringBuilder("where ");
			int wcount = 0;
			
			if(exportPatrolRoutineSo.getSiteKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr.pr_SiteKey = ? ");
				wcount++;
			}
			if(exportPatrolRoutineSo.getResultStartDate() != null && exportPatrolRoutineSo.getResultEndDate() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("(pr.pr_TimeAttended between ? and ?) ");
				wcount++;
			}
			if(exportPatrolRoutineSo.getRouteKeyList() != null && 
					exportPatrolRoutineSo.getRouteKeyList().size() > 0){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				
				
				whereSql.append("pr.pr_RouteDefKey in ");
				whereSql.append("( ");
				
				List<String> routeKeyList = exportPatrolRoutineSo.getRouteKeyList();
				
				for (int i =0; i < routeKeyList.size(); i ++) {
					String routeKey = routeKeyList.get(i);
					if (i > 0) {
						whereSql.append(", ");
					}
					whereSql.append(routeKey + " ");	
				}
				whereSql.append(") ");
				wcount++;
				
			}
			if(exportPatrolRoutineSo.getRouteLocationKeyList() != null && 
					exportPatrolRoutineSo.getRouteLocationKeyList().size() > 0){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				
				
				whereSql.append("pr.pr_LocationKey in ");
				whereSql.append("( ");
				
				List<String> routeLocationKeyList = exportPatrolRoutineSo.getRouteLocationKeyList();
				
				for (int i =0; i < routeLocationKeyList.size(); i ++) {
					String routeLocationKey = routeLocationKeyList.get(i);
					if (i > 0) {
						whereSql.append(", ");
					}
					whereSql.append(routeLocationKey + " ");	
				}
				whereSql.append(") ");
				wcount++;
			}
			
			int pcount = 1;
			preparedStatement = connection.prepareStatement(SELECT_JOIN_SQL + whereSql.toString());
			
			if(exportPatrolRoutineSo.getSiteKey() != null){
				preparedStatement.setInt(pcount, exportPatrolRoutineSo.getSiteKey());
				pcount++;
			}
			if(exportPatrolRoutineSo.getResultStartDate() != null && 
					exportPatrolRoutineSo.getResultEndDate() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(exportPatrolRoutineSo.getResultStartDate()));
				pcount++;
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(exportPatrolRoutineSo.getResultEndDate()));
				pcount++;
			}
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				if (exportPatrolRoutineVoList == null){
					exportPatrolRoutineVoList = new ArrayList<ExportPatrolRoutineVo>();
				}
				ExportPatrolRoutineVo vo = new ExportPatrolRoutineVo();
				String routeCode = rs.getString("rd_Code");
				vo.setRouteCode(routeCode);
				Integer patrolResultKey = rs.getInt("prrr_PatrolResultKey");
				vo.setReadingResult(patrolResultKey);
				String locationCode = rs.getString("l_Code");
				vo.setLocationCode(locationCode);
				String locationName = rs.getString("l_Name");
				vo.setLocationName(locationName);
				Date timeAttended = rs.getDate("pr_timeAttended");
				vo.setCollectionDateTime(timeAttended);
				String timeAttendedString = dateUtils.convertDate2ParamDateString(timeAttended);
				vo.setCollectionDateTimeString(timeAttendedString);
				exportPatrolRoutineVoList.add(vo);
			}
		}
		catch (Exception e){
			logger.error(getClassName() + ".readByExportPatrolRoutineSo() - so=" + so, e);
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
		return exportPatrolRoutineVoList;
	} // end select function
	
	
	
	@Override
	public List<TblPatrolresultEo> read(Object so) throws Exception{
		List<TblPatrolresultEo> tblPatrolresultEoList = null;
		StringBuilder whereSql = null;
		PreparedStatement preparedStatement = null;
		try{
			if (so instanceof TblPatrolresultSo == false) {
				throw new Exception("so is not an instanceof TblPatrolresultSo");
			}
			TblPatrolresultSo tblPatrolresultSo = (TblPatrolresultSo) so;
			whereSql = new StringBuilder("where ");
			int wcount = 0;
			if(tblPatrolresultSo.getPrKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_Key = ? ");
			}
			if(tblPatrolresultSo.getPrSiteKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_SiteKey = ? ");
			}
			if(tblPatrolresultSo.getPrRouteDefKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_RouteDefKey = ? ");
			}
			if(tblPatrolresultSo.getPrGroupNum() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_GroupNum = ? ");
			}
			if(tblPatrolresultSo.getPrCoLocationKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_CoLocationKey = ? ");
			}
			if(tblPatrolresultSo.getPrLocationKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_LocationKey = ? ");
			}
			if(tblPatrolresultSo.getPrSeqNum() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_SeqNum = ? ");
			}
			if(tblPatrolresultSo.getPrTimeAttended() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_TimeAttended = ? ");
			}
			if(tblPatrolresultSo.getPrPersonAttended() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_PersonAttended = ? ");
			}
			if(tblPatrolresultSo.getPrReason() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_Reason = ? ");
			}
			if(tblPatrolresultSo.getPrCompleted() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_Completed = ? ");
			}
			if(tblPatrolresultSo.getPrCreateBy() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_CreateBy = ? ");
			}
			if(tblPatrolresultSo.getPrCreateDateTime() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_CreateDateTime = ? ");
			}
			if(tblPatrolresultSo.getPrLastModifyBy() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_LastModifyBy = ? ");
			}
			if(tblPatrolresultSo.getPrLastModifyDateTime() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_LastModifyDateTime = ? ");
			}
			if(tblPatrolresultSo.getPrDeleted() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_Deleted = ? ");
			}
			if(tblPatrolresultSo.getPrLastModifyTimeForSync() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_LastModifyTimeForSync = ? ");
			}
			if(tblPatrolresultSo.getPrPatrolScheduleKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_PatrolScheduleKey = ? ");
			}
			if(tblPatrolresultSo.getPrPatrolStatus() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_PatrolStatus = ? ");
			}
			if(tblPatrolresultSo.getPrMinPtDur() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_MinPtDur = ? ");
			}
			if(tblPatrolresultSo.getPrMinPtDurUnit() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_MinPtDurUnit = ? ");
			}
			if(tblPatrolresultSo.getPrMaxPtDur() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_MaxPtDur = ? ");
			}
			if(tblPatrolresultSo.getPrMaxPtDurUnit() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pr_MaxPtDurUnit = ? ");
			}
			int pcount = 1;
			preparedStatement = connection.prepareStatement(SELECT_SQL + whereSql.toString());
			if(tblPatrolresultSo.getPrKey() != null){
				preparedStatement.setInt(pcount, tblPatrolresultSo.getPrKey());
				pcount++;
			}
			if(tblPatrolresultSo.getPrSiteKey() != null){
				preparedStatement.setInt(pcount, tblPatrolresultSo.getPrSiteKey());
				pcount++;
			}
			if(tblPatrolresultSo.getPrRouteDefKey() != null){
				preparedStatement.setInt(pcount, tblPatrolresultSo.getPrRouteDefKey());
				pcount++;
			}
			if(tblPatrolresultSo.getPrGroupNum() != null){
				preparedStatement.setInt(pcount, tblPatrolresultSo.getPrGroupNum());
				pcount++;
			}
			if(tblPatrolresultSo.getPrCoLocationKey() != null){
				preparedStatement.setInt(pcount, tblPatrolresultSo.getPrCoLocationKey());
				pcount++;
			}
			if(tblPatrolresultSo.getPrLocationKey() != null){
				preparedStatement.setInt(pcount, tblPatrolresultSo.getPrLocationKey());
				pcount++;
			}
			if(tblPatrolresultSo.getPrSeqNum() != null){
				preparedStatement.setInt(pcount, tblPatrolresultSo.getPrSeqNum());
				pcount++;
			}
			if(tblPatrolresultSo.getPrTimeAttended() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(tblPatrolresultSo.getPrTimeAttended()));
				pcount++;
			}
			if(tblPatrolresultSo.getPrPersonAttended() != null){
				preparedStatement.setInt(pcount, tblPatrolresultSo.getPrPersonAttended());
				pcount++;
			}
			if(tblPatrolresultSo.getPrReason() != null){
				preparedStatement.setString(pcount, tblPatrolresultSo.getPrReason());
				pcount++;
			}
			if(tblPatrolresultSo.getPrCompleted() != null){
				preparedStatement.setString(pcount, tblPatrolresultSo.getPrCompleted());
				pcount++;
			}
			if(tblPatrolresultSo.getPrCreateBy() != null){
				preparedStatement.setInt(pcount, tblPatrolresultSo.getPrCreateBy());
				pcount++;
			}
			if(tblPatrolresultSo.getPrCreateDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(tblPatrolresultSo.getPrCreateDateTime()));
				pcount++;
			}
			if(tblPatrolresultSo.getPrLastModifyBy() != null){
				preparedStatement.setInt(pcount, tblPatrolresultSo.getPrLastModifyBy());
				pcount++;
			}
			if(tblPatrolresultSo.getPrLastModifyDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(tblPatrolresultSo.getPrLastModifyDateTime()));
				pcount++;
			}
			if(tblPatrolresultSo.getPrDeleted() != null){
				preparedStatement.setString(pcount, tblPatrolresultSo.getPrDeleted());
				pcount++;
			}
			if(tblPatrolresultSo.getPrLastModifyTimeForSync() != null){
				preparedStatement.setTimestamp(pcount, miscUtils.convertUtilDate2Timestamp(tblPatrolresultSo.getPrLastModifyTimeForSync()));
				pcount++;
			}
			if(tblPatrolresultSo.getPrPatrolScheduleKey() != null){
				preparedStatement.setString(pcount, tblPatrolresultSo.getPrPatrolScheduleKey());
				pcount++;
			}
			if(tblPatrolresultSo.getPrPatrolStatus() != null){
				preparedStatement.setString(pcount, tblPatrolresultSo.getPrPatrolStatus());
				pcount++;
			}
			if(tblPatrolresultSo.getPrMinPtDur() != null){
				preparedStatement.setInt(pcount, tblPatrolresultSo.getPrMinPtDur());
				pcount++;
			}
			if(tblPatrolresultSo.getPrMinPtDurUnit() != null){
				preparedStatement.setInt(pcount, tblPatrolresultSo.getPrMinPtDurUnit());
				pcount++;
			}
			if(tblPatrolresultSo.getPrMaxPtDur() != null){
				preparedStatement.setInt(pcount, tblPatrolresultSo.getPrMaxPtDur());
				pcount++;
			}
			if(tblPatrolresultSo.getPrMaxPtDurUnit() != null){
				preparedStatement.setInt(pcount, tblPatrolresultSo.getPrMaxPtDurUnit());
				pcount++;
			}
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				if (tblPatrolresultEoList == null){
					tblPatrolresultEoList = new ArrayList<TblPatrolresultEo>();
				}
				TblPatrolresultEo eo = new TblPatrolresultEo();
				Integer prKey = rs.getInt("pr_Key");
				eo.setPrKey(prKey);
				Integer prSiteKey = rs.getInt("pr_SiteKey");
				eo.setPrSiteKey(prSiteKey);
				Integer prRouteDefKey = rs.getInt("pr_RouteDefKey");
				eo.setPrRouteDefKey(prRouteDefKey);
				Integer prGroupNum = rs.getInt("pr_GroupNum");
				eo.setPrGroupNum(prGroupNum);
				Integer prCoLocationKey = rs.getInt("pr_CoLocationKey");
				eo.setPrCoLocationKey(prCoLocationKey);
				Integer prLocationKey = rs.getInt("pr_LocationKey");
				eo.setPrLocationKey(prLocationKey);
				Integer prSeqNum = rs.getInt("pr_SeqNum");
				eo.setPrSeqNum(prSeqNum);
				Date prTimeAttended = rs.getDate("pr_TimeAttended");
				eo.setPrTimeAttended(prTimeAttended);
				Integer prPersonAttended = rs.getInt("pr_PersonAttended");
				eo.setPrPersonAttended(prPersonAttended);
				String prReason = rs.getString("pr_Reason");
				eo.setPrReason(prReason);
				String prCompleted = rs.getString("pr_Completed");
				eo.setPrCompleted(prCompleted);
				Integer prCreateBy = rs.getInt("pr_CreateBy");
				eo.setPrCreateBy(prCreateBy);
				Date prCreateDateTime = rs.getDate("pr_CreateDateTime");
				eo.setPrCreateDateTime(prCreateDateTime);
				Integer prLastModifyBy = rs.getInt("pr_LastModifyBy");
				eo.setPrLastModifyBy(prLastModifyBy);
				Date prLastModifyDateTime = rs.getDate("pr_LastModifyDateTime");
				eo.setPrLastModifyDateTime(prLastModifyDateTime);
				String prDeleted = rs.getString("pr_Deleted");
				eo.setPrDeleted(prDeleted);
				Date prLastModifyTimeForSync = rs.getTimestamp("pr_LastModifyTimeForSync");
				eo.setPrLastModifyTimeForSync(prLastModifyTimeForSync);
				String prPatrolScheduleKey = rs.getString("pr_PatrolScheduleKey");
				eo.setPrPatrolScheduleKey(prPatrolScheduleKey);
				String prPatrolStatus = rs.getString("pr_PatrolStatus");
				eo.setPrPatrolStatus(prPatrolStatus);
				Integer prMinPtDur = rs.getInt("pr_MinPtDur");
				eo.setPrMinPtDur(prMinPtDur);
				Integer prMinPtDurUnit = rs.getInt("pr_MinPtDurUnit");
				eo.setPrMinPtDurUnit(prMinPtDurUnit);
				Integer prMaxPtDur = rs.getInt("pr_MaxPtDur");
				eo.setPrMaxPtDur(prMaxPtDur);
				Integer prMaxPtDurUnit = rs.getInt("pr_MaxPtDurUnit");
				eo.setPrMaxPtDurUnit(prMaxPtDurUnit);
				tblPatrolresultEoList.add(eo);
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
		return tblPatrolresultEoList;
	} // end select function
	@Override
	public Integer create(TblPatrolresultEo eo) throws Exception{
		PreparedStatement preparedStatement = null;
		Integer noOfAffectedRow = null;
		try{
			int pcount = 1;
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			if(eo.getPrKey() != null){
				preparedStatement.setInt(pcount, eo.getPrKey());
				pcount++;
			}
			if(eo.getPrSiteKey() != null){
				preparedStatement.setInt(pcount, eo.getPrSiteKey());
				pcount++;
			}
			if(eo.getPrRouteDefKey() != null){
				preparedStatement.setInt(pcount, eo.getPrRouteDefKey());
				pcount++;
			}
			if(eo.getPrGroupNum() != null){
				preparedStatement.setInt(pcount, eo.getPrGroupNum());
				pcount++;
			}
			if(eo.getPrCoLocationKey() != null){
				preparedStatement.setInt(pcount, eo.getPrCoLocationKey());
				pcount++;
			}
			if(eo.getPrLocationKey() != null){
				preparedStatement.setInt(pcount, eo.getPrLocationKey());
				pcount++;
			}
			if(eo.getPrSeqNum() != null){
				preparedStatement.setInt(pcount, eo.getPrSeqNum());
				pcount++;
			}
			if(eo.getPrTimeAttended() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getPrTimeAttended()));
				pcount++;
			}
			if(eo.getPrPersonAttended() != null){
				preparedStatement.setInt(pcount, eo.getPrPersonAttended());
				pcount++;
			}
			if(eo.getPrReason() != null){
				preparedStatement.setString(pcount, eo.getPrReason());
				pcount++;
			}
			if(eo.getPrCompleted() != null){
				preparedStatement.setString(pcount, eo.getPrCompleted());
				pcount++;
			}
			if(eo.getPrCreateBy() != null){
				preparedStatement.setInt(pcount, eo.getPrCreateBy());
				pcount++;
			}
			if(eo.getPrCreateDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getPrCreateDateTime()));
				pcount++;
			}
			if(eo.getPrLastModifyBy() != null){
				preparedStatement.setInt(pcount, eo.getPrLastModifyBy());
				pcount++;
			}
			if(eo.getPrLastModifyDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getPrLastModifyDateTime()));
				pcount++;
			}
			if(eo.getPrDeleted() != null){
				preparedStatement.setString(pcount, eo.getPrDeleted());
				pcount++;
			}
			if(eo.getPrLastModifyTimeForSync() != null){
				preparedStatement.setTimestamp(pcount, miscUtils.convertUtilDate2Timestamp(eo.getPrLastModifyTimeForSync()));
				pcount++;
			}
			if(eo.getPrPatrolScheduleKey() != null){
				preparedStatement.setString(pcount, eo.getPrPatrolScheduleKey());
				pcount++;
			}
			if(eo.getPrPatrolStatus() != null){
				preparedStatement.setString(pcount, eo.getPrPatrolStatus());
				pcount++;
			}
			if(eo.getPrMinPtDur() != null){
				preparedStatement.setInt(pcount, eo.getPrMinPtDur());
				pcount++;
			}
			if(eo.getPrMinPtDurUnit() != null){
				preparedStatement.setInt(pcount, eo.getPrMinPtDurUnit());
				pcount++;
			}
			if(eo.getPrMaxPtDur() != null){
				preparedStatement.setInt(pcount, eo.getPrMaxPtDur());
				pcount++;
			}
			if(eo.getPrMaxPtDurUnit() != null){
				preparedStatement.setInt(pcount, eo.getPrMaxPtDurUnit());
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
	public Integer update(TblPatrolresultEo eo) throws Exception{
		PreparedStatement preparedStatement = null;
		Integer noOfAffectedRow = null;
		try{
			int pcount = 1;
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			if(eo.getPrKey() != null){
				preparedStatement.setInt(pcount, eo.getPrKey());
				pcount++;
			}
			if(eo.getPrSiteKey() != null){
				preparedStatement.setInt(pcount, eo.getPrSiteKey());
				pcount++;
			}
			if(eo.getPrRouteDefKey() != null){
				preparedStatement.setInt(pcount, eo.getPrRouteDefKey());
				pcount++;
			}
			if(eo.getPrGroupNum() != null){
				preparedStatement.setInt(pcount, eo.getPrGroupNum());
				pcount++;
			}
			if(eo.getPrCoLocationKey() != null){
				preparedStatement.setInt(pcount, eo.getPrCoLocationKey());
				pcount++;
			}
			if(eo.getPrLocationKey() != null){
				preparedStatement.setInt(pcount, eo.getPrLocationKey());
				pcount++;
			}
			if(eo.getPrSeqNum() != null){
				preparedStatement.setInt(pcount, eo.getPrSeqNum());
				pcount++;
			}
			if(eo.getPrTimeAttended() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getPrTimeAttended()));
				pcount++;
			}
			if(eo.getPrPersonAttended() != null){
				preparedStatement.setInt(pcount, eo.getPrPersonAttended());
				pcount++;
			}
			if(eo.getPrReason() != null){
				preparedStatement.setString(pcount, eo.getPrReason());
				pcount++;
			}
			if(eo.getPrCompleted() != null){
				preparedStatement.setString(pcount, eo.getPrCompleted());
				pcount++;
			}
			if(eo.getPrCreateBy() != null){
				preparedStatement.setInt(pcount, eo.getPrCreateBy());
				pcount++;
			}
			if(eo.getPrCreateDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getPrCreateDateTime()));
				pcount++;
			}
			if(eo.getPrLastModifyBy() != null){
				preparedStatement.setInt(pcount, eo.getPrLastModifyBy());
				pcount++;
			}
			if(eo.getPrLastModifyDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getPrLastModifyDateTime()));
				pcount++;
			}
			if(eo.getPrDeleted() != null){
				preparedStatement.setString(pcount, eo.getPrDeleted());
				pcount++;
			}
			if(eo.getPrLastModifyTimeForSync() != null){
				preparedStatement.setTimestamp(pcount, miscUtils.convertUtilDate2Timestamp(eo.getPrLastModifyTimeForSync()));
				pcount++;
			}
			if(eo.getPrPatrolScheduleKey() != null){
				preparedStatement.setString(pcount, eo.getPrPatrolScheduleKey());
				pcount++;
			}
			if(eo.getPrPatrolStatus() != null){
				preparedStatement.setString(pcount, eo.getPrPatrolStatus());
				pcount++;
			}
			if(eo.getPrMinPtDur() != null){
				preparedStatement.setInt(pcount, eo.getPrMinPtDur());
				pcount++;
			}
			if(eo.getPrMinPtDurUnit() != null){
				preparedStatement.setInt(pcount, eo.getPrMinPtDurUnit());
				pcount++;
			}
			if(eo.getPrMaxPtDur() != null){
				preparedStatement.setInt(pcount, eo.getPrMaxPtDur());
				pcount++;
			}
			if(eo.getPrMaxPtDurUnit() != null){
				preparedStatement.setInt(pcount, eo.getPrMaxPtDurUnit());
				pcount++;
			}
			if(eo.getPrKey() != null){
				preparedStatement.setInt(pcount, eo.getPrKey());
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
	public Integer delete(TblPatrolresultEo eo) throws Exception{
		PreparedStatement preparedStatement = null;
		Integer noOfAffectedRow = null;
		try{
			int pcount = 1;
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			if(eo.getPrKey() != null){
				preparedStatement.setInt(pcount, eo.getPrKey());
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
