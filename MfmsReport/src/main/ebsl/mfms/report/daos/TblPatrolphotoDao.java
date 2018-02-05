package ebsl.mfms.report.daos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.models.eos.TblPatrolphotoEo;
import ebsl.mfms.report.models.sos.TblPatrolphotoSo;
public class TblPatrolphotoDao extends DaoBase<TblPatrolphotoEo>{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private final String SELECT_SQL=
			"select " + 
			"pp_Key " + 
			",pp_SiteKey " + 
			",pp_RouteDefKey " + 
			",pp_PatrolResultKey " + 
			",pp_PhotoPath " + 
			",pp_LocationKey " + 
			",pp_Remark " + 
			",pp_CreateBy " + 
			",pp_CreateTime " + 
			",pp_LastModifyBy " + 
			",pp_LastModifyTime " + 
			",pp_Deleted " + 
			",pp_LastModifyTimeForSync " + 
			"from tbl_patrolphoto ";
	private final String INSERT_SQL=
			"insert " + 
			"into " + 
			"tbl_patrolphoto " + 
			"( " + 
			"pp_Key " + 
			",pp_SiteKey " + 
			",pp_RouteDefKey " + 
			",pp_PatrolResultKey " + 
			",pp_PhotoPath " + 
			",pp_LocationKey " + 
			",pp_Remark " + 
			",pp_CreateBy " + 
			",pp_CreateTime " + 
			",pp_LastModifyBy " + 
			",pp_LastModifyTime " + 
			",pp_Deleted " + 
			",pp_LastModifyTimeForSync " + 
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
			") ";
	private final String UPDATE_SQL=
			"update " + 
			"tbl_patrolphoto " + 
			"set " + 
			"pp_Key= ? " + 
			",pp_SiteKey= ? " + 
			",pp_RouteDefKey= ? " + 
			",pp_PatrolResultKey= ? " + 
			",pp_PhotoPath= ? " + 
			",pp_LocationKey= ? " + 
			",pp_Remark= ? " + 
			",pp_CreateBy= ? " + 
			",pp_CreateTime= ? " + 
			",pp_LastModifyBy= ? " + 
			",pp_LastModifyTime= ? " + 
			",pp_Deleted= ? " + 
			",pp_LastModifyTimeForSync= ? " + 
			"where pp_Key = ? ";
	private final String DELETE_SQL=
			"delete " + 
			"from " + 
			"tbl_patrolphoto " + 
			"where pp_Key = ? ";
	private String getClassName(){
		return this.getClass().getName();
	}
	public TblPatrolphotoDao() throws Exception {
		super();
	}
	public TblPatrolphotoDao(String connectionType) throws Exception {
		super(connectionType);
	}
	@Override
	public List<TblPatrolphotoEo> read(Object so) throws Exception{
		List<TblPatrolphotoEo> tblPatrolphotoEoList = null;
		StringBuilder whereSql = null;
		PreparedStatement preparedStatement = null;
		try{
			if (so instanceof TblPatrolphotoSo == false) {
				throw new Exception("so is not an instanceof TblPatrolphotoSo");
			}
			TblPatrolphotoSo tblPatrolphotoSo = (TblPatrolphotoSo) so;
			whereSql = new StringBuilder("where ");
			int wcount = 0;
			if(tblPatrolphotoSo.getPpKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pp_Key = ? ");
			}
			if(tblPatrolphotoSo.getPpSiteKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pp_SiteKey = ? ");
			}
			if(tblPatrolphotoSo.getPpRouteDefKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pp_RouteDefKey = ? ");
			}
			if(tblPatrolphotoSo.getPpPatrolResultKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pp_PatrolResultKey = ? ");
			}
			if(tblPatrolphotoSo.getPpPhotoPath() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pp_PhotoPath = ? ");
			}
			if(tblPatrolphotoSo.getPpLocationKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pp_LocationKey = ? ");
			}
			if(tblPatrolphotoSo.getPpRemark() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pp_Remark = ? ");
			}
			if(tblPatrolphotoSo.getPpCreateBy() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pp_CreateBy = ? ");
			}
			if(tblPatrolphotoSo.getPpCreateTime() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pp_CreateTime = ? ");
			}
			if(tblPatrolphotoSo.getPpLastModifyBy() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pp_LastModifyBy = ? ");
			}
			if(tblPatrolphotoSo.getPpLastModifyTime() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pp_LastModifyTime = ? ");
			}
			if(tblPatrolphotoSo.getPpDeleted() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pp_Deleted = ? ");
			}
			if(tblPatrolphotoSo.getPpLastModifyTimeForSync() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("pp_LastModifyTimeForSync = ? ");
			}
			int pcount = 1;
			preparedStatement = connection.prepareStatement(SELECT_SQL + whereSql.toString());
			if(tblPatrolphotoSo.getPpKey() != null){
				preparedStatement.setInt(pcount, tblPatrolphotoSo.getPpKey());
				pcount++;
			}
			if(tblPatrolphotoSo.getPpSiteKey() != null){
				preparedStatement.setInt(pcount, tblPatrolphotoSo.getPpSiteKey());
				pcount++;
			}
			if(tblPatrolphotoSo.getPpRouteDefKey() != null){
				preparedStatement.setInt(pcount, tblPatrolphotoSo.getPpRouteDefKey());
				pcount++;
			}
			if(tblPatrolphotoSo.getPpPatrolResultKey() != null){
				preparedStatement.setInt(pcount, tblPatrolphotoSo.getPpPatrolResultKey());
				pcount++;
			}
			if(tblPatrolphotoSo.getPpPhotoPath() != null){
				preparedStatement.setString(pcount, tblPatrolphotoSo.getPpPhotoPath());
				pcount++;
			}
			if(tblPatrolphotoSo.getPpLocationKey() != null){
				preparedStatement.setInt(pcount, tblPatrolphotoSo.getPpLocationKey());
				pcount++;
			}
			if(tblPatrolphotoSo.getPpRemark() != null){
				preparedStatement.setString(pcount, tblPatrolphotoSo.getPpRemark());
				pcount++;
			}
			if(tblPatrolphotoSo.getPpCreateBy() != null){
				preparedStatement.setInt(pcount, tblPatrolphotoSo.getPpCreateBy());
				pcount++;
			}
			if(tblPatrolphotoSo.getPpCreateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(tblPatrolphotoSo.getPpCreateTime()));
				pcount++;
			}
			if(tblPatrolphotoSo.getPpLastModifyBy() != null){
				preparedStatement.setInt(pcount, tblPatrolphotoSo.getPpLastModifyBy());
				pcount++;
			}
			if(tblPatrolphotoSo.getPpLastModifyTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(tblPatrolphotoSo.getPpLastModifyTime()));
				pcount++;
			}
			if(tblPatrolphotoSo.getPpDeleted() != null){
				preparedStatement.setString(pcount, tblPatrolphotoSo.getPpDeleted());
				pcount++;
			}
			if(tblPatrolphotoSo.getPpLastModifyTimeForSync() != null){
				preparedStatement.setTimestamp(pcount, miscUtils.convertUtilDate2Timestamp(tblPatrolphotoSo.getPpLastModifyTimeForSync()));
				pcount++;
			}
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				if (tblPatrolphotoEoList == null){
					tblPatrolphotoEoList = new ArrayList<TblPatrolphotoEo>();
				}
				TblPatrolphotoEo eo = new TblPatrolphotoEo();
				Integer ppKey = rs.getInt("pp_Key");
				eo.setPpKey(ppKey);
				Integer ppSiteKey = rs.getInt("pp_SiteKey");
				eo.setPpSiteKey(ppSiteKey);
				Integer ppRouteDefKey = rs.getInt("pp_RouteDefKey");
				eo.setPpRouteDefKey(ppRouteDefKey);
				Integer ppPatrolResultKey = rs.getInt("pp_PatrolResultKey");
				eo.setPpPatrolResultKey(ppPatrolResultKey);
				String ppPhotoPath = rs.getString("pp_PhotoPath");
				eo.setPpPhotoPath(ppPhotoPath);
				Integer ppLocationKey = rs.getInt("pp_LocationKey");
				eo.setPpLocationKey(ppLocationKey);
				String ppRemark = rs.getString("pp_Remark");
				eo.setPpRemark(ppRemark);
				Integer ppCreateBy = rs.getInt("pp_CreateBy");
				eo.setPpCreateBy(ppCreateBy);
				Date ppCreateTime = rs.getDate("pp_CreateTime");
				eo.setPpCreateTime(ppCreateTime);
				Integer ppLastModifyBy = rs.getInt("pp_LastModifyBy");
				eo.setPpLastModifyBy(ppLastModifyBy);
				Date ppLastModifyTime = rs.getDate("pp_LastModifyTime");
				eo.setPpLastModifyTime(ppLastModifyTime);
				String ppDeleted = rs.getString("pp_Deleted");
				eo.setPpDeleted(ppDeleted);
				Date ppLastModifyTimeForSync = rs.getTimestamp("pp_LastModifyTimeForSync");
				eo.setPpLastModifyTimeForSync(ppLastModifyTimeForSync);
				tblPatrolphotoEoList.add(eo);
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
		return tblPatrolphotoEoList;
	} // end select function
	@Override
	public Integer create(TblPatrolphotoEo eo) throws Exception{
		PreparedStatement preparedStatement = null;
		Integer noOfAffectedRow = null;
		try{
			int pcount = 1;
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			if(eo.getPpKey() != null){
				preparedStatement.setInt(pcount, eo.getPpKey());
				pcount++;
			}
			if(eo.getPpSiteKey() != null){
				preparedStatement.setInt(pcount, eo.getPpSiteKey());
				pcount++;
			}
			if(eo.getPpRouteDefKey() != null){
				preparedStatement.setInt(pcount, eo.getPpRouteDefKey());
				pcount++;
			}
			if(eo.getPpPatrolResultKey() != null){
				preparedStatement.setInt(pcount, eo.getPpPatrolResultKey());
				pcount++;
			}
			if(eo.getPpPhotoPath() != null){
				preparedStatement.setString(pcount, eo.getPpPhotoPath());
				pcount++;
			}
			if(eo.getPpLocationKey() != null){
				preparedStatement.setInt(pcount, eo.getPpLocationKey());
				pcount++;
			}
			if(eo.getPpRemark() != null){
				preparedStatement.setString(pcount, eo.getPpRemark());
				pcount++;
			}
			if(eo.getPpCreateBy() != null){
				preparedStatement.setInt(pcount, eo.getPpCreateBy());
				pcount++;
			}
			if(eo.getPpCreateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getPpCreateTime()));
				pcount++;
			}
			if(eo.getPpLastModifyBy() != null){
				preparedStatement.setInt(pcount, eo.getPpLastModifyBy());
				pcount++;
			}
			if(eo.getPpLastModifyTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getPpLastModifyTime()));
				pcount++;
			}
			if(eo.getPpDeleted() != null){
				preparedStatement.setString(pcount, eo.getPpDeleted());
				pcount++;
			}
			if(eo.getPpLastModifyTimeForSync() != null){
				preparedStatement.setTimestamp(pcount, miscUtils.convertUtilDate2Timestamp(eo.getPpLastModifyTimeForSync()));
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
	public Integer update(TblPatrolphotoEo eo) throws Exception{
		PreparedStatement preparedStatement = null;
		Integer noOfAffectedRow = null;
		try{
			int pcount = 1;
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			if(eo.getPpKey() != null){
				preparedStatement.setInt(pcount, eo.getPpKey());
				pcount++;
			}
			if(eo.getPpSiteKey() != null){
				preparedStatement.setInt(pcount, eo.getPpSiteKey());
				pcount++;
			}
			if(eo.getPpRouteDefKey() != null){
				preparedStatement.setInt(pcount, eo.getPpRouteDefKey());
				pcount++;
			}
			if(eo.getPpPatrolResultKey() != null){
				preparedStatement.setInt(pcount, eo.getPpPatrolResultKey());
				pcount++;
			}
			if(eo.getPpPhotoPath() != null){
				preparedStatement.setString(pcount, eo.getPpPhotoPath());
				pcount++;
			}
			if(eo.getPpLocationKey() != null){
				preparedStatement.setInt(pcount, eo.getPpLocationKey());
				pcount++;
			}
			if(eo.getPpRemark() != null){
				preparedStatement.setString(pcount, eo.getPpRemark());
				pcount++;
			}
			if(eo.getPpCreateBy() != null){
				preparedStatement.setInt(pcount, eo.getPpCreateBy());
				pcount++;
			}
			if(eo.getPpCreateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getPpCreateTime()));
				pcount++;
			}
			if(eo.getPpLastModifyBy() != null){
				preparedStatement.setInt(pcount, eo.getPpLastModifyBy());
				pcount++;
			}
			if(eo.getPpLastModifyTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getPpLastModifyTime()));
				pcount++;
			}
			if(eo.getPpDeleted() != null){
				preparedStatement.setString(pcount, eo.getPpDeleted());
				pcount++;
			}
			if(eo.getPpLastModifyTimeForSync() != null){
				preparedStatement.setTimestamp(pcount, miscUtils.convertUtilDate2Timestamp(eo.getPpLastModifyTimeForSync()));
				pcount++;
			}
			if(eo.getPpKey() != null){
				preparedStatement.setInt(pcount, eo.getPpKey());
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
	public Integer delete(TblPatrolphotoEo eo) throws Exception{
		PreparedStatement preparedStatement = null;
		Integer noOfAffectedRow = null;
		try{
			int pcount = 1;
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			if(eo.getPpKey() != null){
				preparedStatement.setInt(pcount, eo.getPpKey());
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