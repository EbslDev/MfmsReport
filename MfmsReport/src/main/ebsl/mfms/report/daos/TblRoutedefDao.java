package ebsl.mfms.report.daos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.models.eos.TblRoutedefEo;
import ebsl.mfms.report.models.sos.TblRoutedefSo;
public class TblRoutedefDao extends DaoBase<TblRoutedefEo>{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private final String SELECT_SQL=
			"select " + 
			"rd_Key " + 
			",rd_SiteKey " + 
			",rd_Code " + 
			",rd_Name " + 
			",rd_DefMinPtDur " + 
			",rd_DefMinPtDurUnit " + 
			",rd_DefMaxPtDur " + 
			",rd_DefMaxPtDurUnit " + 
			",rd_CreateBy " + 
			",rd_CreateDateTime " + 
			",rd_LastModifyBy " + 
			",rd_LastModifyDateTime " + 
			",rd_Deleted " + 
			",rd_LastModifyTimeForSync " + 
			"from tbl_routedef ";
	private final String INSERT_SQL=
			"insert " + 
			"into " + 
			"tbl_routedef " + 
			"( " + 
			"rd_Key " + 
			",rd_SiteKey " + 
			",rd_Code " + 
			",rd_Name " + 
			",rd_DefMinPtDur " + 
			",rd_DefMinPtDurUnit " + 
			",rd_DefMaxPtDur " + 
			",rd_DefMaxPtDurUnit " + 
			",rd_CreateBy " + 
			",rd_CreateDateTime " + 
			",rd_LastModifyBy " + 
			",rd_LastModifyDateTime " + 
			",rd_Deleted " + 
			",rd_LastModifyTimeForSync " + 
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
			") ";
	private final String UPDATE_SQL=
			"update " + 
			"tbl_routedef " + 
			"set " + 
			"rd_Key= ? " + 
			",rd_SiteKey= ? " + 
			",rd_Code= ? " + 
			",rd_Name= ? " + 
			",rd_DefMinPtDur= ? " + 
			",rd_DefMinPtDurUnit= ? " + 
			",rd_DefMaxPtDur= ? " + 
			",rd_DefMaxPtDurUnit= ? " + 
			",rd_CreateBy= ? " + 
			",rd_CreateDateTime= ? " + 
			",rd_LastModifyBy= ? " + 
			",rd_LastModifyDateTime= ? " + 
			",rd_Deleted= ? " + 
			",rd_LastModifyTimeForSync= ? " + 
			"where rd_Key = ? ";
	private final String DELETE_SQL=
			"delete " + 
			"from " + 
			"tbl_routedef " + 
			"where rd_Key = ? ";
	private String getClassName(){
		return this.getClass().getName();
	}
	public TblRoutedefDao() throws Exception {
		super();
	}
	public TblRoutedefDao(String connectionType) throws Exception {
		super(connectionType);
	}
	@Override
	public List<TblRoutedefEo> read(Object so) throws Exception{
		List<TblRoutedefEo> tblRoutedefEoList = null;
		StringBuilder whereSql = null;
		PreparedStatement preparedStatement = null;
		try{
			if (so instanceof TblRoutedefSo == false) {
				throw new Exception("so is not an instanceof TblRoutedefSo");
			}
			TblRoutedefSo tblRoutedefSo = (TblRoutedefSo) so;
			whereSql = new StringBuilder("where ");
			int wcount = 0;
			if(tblRoutedefSo.getRdKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("rd_Key = ? ");
			}
			if(tblRoutedefSo.getRdSiteKey() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("rd_SiteKey = ? ");
			}
			if(tblRoutedefSo.getRdCode() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("rd_Code = ? ");
			}
			if(tblRoutedefSo.getRdName() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("rd_Name = ? ");
			}
			if(tblRoutedefSo.getRdDefMinPtDur() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("rd_DefMinPtDur = ? ");
			}
			if(tblRoutedefSo.getRdDefMinPtDurUnit() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("rd_DefMinPtDurUnit = ? ");
			}
			if(tblRoutedefSo.getRdDefMaxPtDur() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("rd_DefMaxPtDur = ? ");
			}
			if(tblRoutedefSo.getRdDefMaxPtDurUnit() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("rd_DefMaxPtDurUnit = ? ");
			}
			if(tblRoutedefSo.getRdCreateBy() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("rd_CreateBy = ? ");
			}
			if(tblRoutedefSo.getRdCreateDateTime() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("rd_CreateDateTime = ? ");
			}
			if(tblRoutedefSo.getRdLastModifyBy() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("rd_LastModifyBy = ? ");
			}
			if(tblRoutedefSo.getRdLastModifyDateTime() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("rd_LastModifyDateTime = ? ");
			}
			if(tblRoutedefSo.getRdDeleted() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("rd_Deleted = ? ");
			}
			if(tblRoutedefSo.getRdLastModifyTimeForSync() != null){
				if (wcount > 0) {
					whereSql.append("and ");
				}
				whereSql.append("rd_LastModifyTimeForSync = ? ");
			}
			int pcount = 1;
			preparedStatement = connection.prepareStatement(SELECT_SQL + whereSql.toString());
			if(tblRoutedefSo.getRdKey() != null){
				preparedStatement.setInt(pcount, tblRoutedefSo.getRdKey());
				pcount++;
			}
			if(tblRoutedefSo.getRdSiteKey() != null){
				preparedStatement.setInt(pcount, tblRoutedefSo.getRdSiteKey());
				pcount++;
			}
			if(tblRoutedefSo.getRdCode() != null){
				preparedStatement.setString(pcount, tblRoutedefSo.getRdCode());
				pcount++;
			}
			if(tblRoutedefSo.getRdName() != null){
				preparedStatement.setString(pcount, tblRoutedefSo.getRdName());
				pcount++;
			}
			if(tblRoutedefSo.getRdDefMinPtDur() != null){
				preparedStatement.setInt(pcount, tblRoutedefSo.getRdDefMinPtDur());
				pcount++;
			}
			if(tblRoutedefSo.getRdDefMinPtDurUnit() != null){
				preparedStatement.setInt(pcount, tblRoutedefSo.getRdDefMinPtDurUnit());
				pcount++;
			}
			if(tblRoutedefSo.getRdDefMaxPtDur() != null){
				preparedStatement.setInt(pcount, tblRoutedefSo.getRdDefMaxPtDur());
				pcount++;
			}
			if(tblRoutedefSo.getRdDefMaxPtDurUnit() != null){
				preparedStatement.setInt(pcount, tblRoutedefSo.getRdDefMaxPtDurUnit());
				pcount++;
			}
			if(tblRoutedefSo.getRdCreateBy() != null){
				preparedStatement.setInt(pcount, tblRoutedefSo.getRdCreateBy());
				pcount++;
			}
			if(tblRoutedefSo.getRdCreateDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(tblRoutedefSo.getRdCreateDateTime()));
				pcount++;
			}
			if(tblRoutedefSo.getRdLastModifyBy() != null){
				preparedStatement.setInt(pcount, tblRoutedefSo.getRdLastModifyBy());
				pcount++;
			}
			if(tblRoutedefSo.getRdLastModifyDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(tblRoutedefSo.getRdLastModifyDateTime()));
				pcount++;
			}
			if(tblRoutedefSo.getRdDeleted() != null){
				preparedStatement.setString(pcount, tblRoutedefSo.getRdDeleted());
				pcount++;
			}
			if(tblRoutedefSo.getRdLastModifyTimeForSync() != null){
				preparedStatement.setTimestamp(pcount, miscUtils.convertUtilDate2Timestamp(tblRoutedefSo.getRdLastModifyTimeForSync()));
				pcount++;
			}
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				if (tblRoutedefEoList == null){
					tblRoutedefEoList = new ArrayList<TblRoutedefEo>();
				}
				TblRoutedefEo eo = new TblRoutedefEo();
				Integer rdKey = rs.getInt("rd_Key");
				eo.setRdKey(rdKey);
				Integer rdSiteKey = rs.getInt("rd_SiteKey");
				eo.setRdSiteKey(rdSiteKey);
				String rdCode = rs.getString("rd_Code");
				eo.setRdCode(rdCode);
				String rdName = rs.getString("rd_Name");
				eo.setRdName(rdName);
				Integer rdDefMinPtDur = rs.getInt("rd_DefMinPtDur");
				eo.setRdDefMinPtDur(rdDefMinPtDur);
				Integer rdDefMinPtDurUnit = rs.getInt("rd_DefMinPtDurUnit");
				eo.setRdDefMinPtDurUnit(rdDefMinPtDurUnit);
				Integer rdDefMaxPtDur = rs.getInt("rd_DefMaxPtDur");
				eo.setRdDefMaxPtDur(rdDefMaxPtDur);
				Integer rdDefMaxPtDurUnit = rs.getInt("rd_DefMaxPtDurUnit");
				eo.setRdDefMaxPtDurUnit(rdDefMaxPtDurUnit);
				Integer rdCreateBy = rs.getInt("rd_CreateBy");
				eo.setRdCreateBy(rdCreateBy);
				Date rdCreateDateTime = rs.getDate("rd_CreateDateTime");
				eo.setRdCreateDateTime(rdCreateDateTime);
				Integer rdLastModifyBy = rs.getInt("rd_LastModifyBy");
				eo.setRdLastModifyBy(rdLastModifyBy);
				Date rdLastModifyDateTime = rs.getDate("rd_LastModifyDateTime");
				eo.setRdLastModifyDateTime(rdLastModifyDateTime);
				String rdDeleted = rs.getString("rd_Deleted");
				eo.setRdDeleted(rdDeleted);
				Date rdLastModifyTimeForSync = rs.getTimestamp("rd_LastModifyTimeForSync");
				eo.setRdLastModifyTimeForSync(rdLastModifyTimeForSync);
				tblRoutedefEoList.add(eo);
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
		return tblRoutedefEoList;
	} // end select function
	@Override
	public Integer create(TblRoutedefEo eo) throws Exception{
		PreparedStatement preparedStatement = null;
		Integer noOfAffectedRow = null;
		try{
			int pcount = 1;
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			if(eo.getRdKey() != null){
				preparedStatement.setInt(pcount, eo.getRdKey());
				pcount++;
			}
			if(eo.getRdSiteKey() != null){
				preparedStatement.setInt(pcount, eo.getRdSiteKey());
				pcount++;
			}
			if(eo.getRdCode() != null){
				preparedStatement.setString(pcount, eo.getRdCode());
				pcount++;
			}
			if(eo.getRdName() != null){
				preparedStatement.setString(pcount, eo.getRdName());
				pcount++;
			}
			if(eo.getRdDefMinPtDur() != null){
				preparedStatement.setInt(pcount, eo.getRdDefMinPtDur());
				pcount++;
			}
			if(eo.getRdDefMinPtDurUnit() != null){
				preparedStatement.setInt(pcount, eo.getRdDefMinPtDurUnit());
				pcount++;
			}
			if(eo.getRdDefMaxPtDur() != null){
				preparedStatement.setInt(pcount, eo.getRdDefMaxPtDur());
				pcount++;
			}
			if(eo.getRdDefMaxPtDurUnit() != null){
				preparedStatement.setInt(pcount, eo.getRdDefMaxPtDurUnit());
				pcount++;
			}
			if(eo.getRdCreateBy() != null){
				preparedStatement.setInt(pcount, eo.getRdCreateBy());
				pcount++;
			}
			if(eo.getRdCreateDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getRdCreateDateTime()));
				pcount++;
			}
			if(eo.getRdLastModifyBy() != null){
				preparedStatement.setInt(pcount, eo.getRdLastModifyBy());
				pcount++;
			}
			if(eo.getRdLastModifyDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getRdLastModifyDateTime()));
				pcount++;
			}
			if(eo.getRdDeleted() != null){
				preparedStatement.setString(pcount, eo.getRdDeleted());
				pcount++;
			}
			if(eo.getRdLastModifyTimeForSync() != null){
				preparedStatement.setTimestamp(pcount, miscUtils.convertUtilDate2Timestamp(eo.getRdLastModifyTimeForSync()));
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
	public Integer update(TblRoutedefEo eo) throws Exception{
		PreparedStatement preparedStatement = null;
		Integer noOfAffectedRow = null;
		try{
			int pcount = 1;
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			if(eo.getRdKey() != null){
				preparedStatement.setInt(pcount, eo.getRdKey());
				pcount++;
			}
			if(eo.getRdSiteKey() != null){
				preparedStatement.setInt(pcount, eo.getRdSiteKey());
				pcount++;
			}
			if(eo.getRdCode() != null){
				preparedStatement.setString(pcount, eo.getRdCode());
				pcount++;
			}
			if(eo.getRdName() != null){
				preparedStatement.setString(pcount, eo.getRdName());
				pcount++;
			}
			if(eo.getRdDefMinPtDur() != null){
				preparedStatement.setInt(pcount, eo.getRdDefMinPtDur());
				pcount++;
			}
			if(eo.getRdDefMinPtDurUnit() != null){
				preparedStatement.setInt(pcount, eo.getRdDefMinPtDurUnit());
				pcount++;
			}
			if(eo.getRdDefMaxPtDur() != null){
				preparedStatement.setInt(pcount, eo.getRdDefMaxPtDur());
				pcount++;
			}
			if(eo.getRdDefMaxPtDurUnit() != null){
				preparedStatement.setInt(pcount, eo.getRdDefMaxPtDurUnit());
				pcount++;
			}
			if(eo.getRdCreateBy() != null){
				preparedStatement.setInt(pcount, eo.getRdCreateBy());
				pcount++;
			}
			if(eo.getRdCreateDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getRdCreateDateTime()));
				pcount++;
			}
			if(eo.getRdLastModifyBy() != null){
				preparedStatement.setInt(pcount, eo.getRdLastModifyBy());
				pcount++;
			}
			if(eo.getRdLastModifyDateTime() != null){
				preparedStatement.setDate(pcount, miscUtils.convertUtilDate2SqlDate(eo.getRdLastModifyDateTime()));
				pcount++;
			}
			if(eo.getRdDeleted() != null){
				preparedStatement.setString(pcount, eo.getRdDeleted());
				pcount++;
			}
			if(eo.getRdLastModifyTimeForSync() != null){
				preparedStatement.setTimestamp(pcount, miscUtils.convertUtilDate2Timestamp(eo.getRdLastModifyTimeForSync()));
				pcount++;
			}
			if(eo.getRdKey() != null){
				preparedStatement.setInt(pcount, eo.getRdKey());
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
	public Integer delete(TblRoutedefEo eo) throws Exception{
		PreparedStatement preparedStatement = null;
		Integer noOfAffectedRow = null;
		try{
			int pcount = 1;
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			if(eo.getRdKey() != null){
				preparedStatement.setInt(pcount, eo.getRdKey());
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
