package ebsl.mfms.report.services;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.daos.TblPatrolresultreadingrecordDao;
import ebsl.mfms.report.models.eos.TblPatrolresultreadingrecordEo;
public class TblPatrolresultreadingrecordMgr extends ServiceBase{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private TblPatrolresultreadingrecordDao dao;
	private String getClassName(){
		return this.getClass().getName();
	}
	public TblPatrolresultreadingrecordMgr() throws Exception{
		try{
			init(null);
		} catch (Exception e){
			logger.error(getClassName() + ".TblPatrolresultreadingrecordMgr() - connectionType=", e);
			throw e;
		}
	} // end constructor
	public TblPatrolresultreadingrecordMgr(String connectionType) throws Exception{
		try{
			init(connectionType);
		} catch (Exception e){
			logger.error(getClassName() + ".TblPatrolresultreadingrecordMgr() - connectionType=" + connectionType, e);
			throw e;
		}
	} // end constructor
	public void init(String connectionType) throws Exception{
		try{
			dao = new TblPatrolresultreadingrecordDao(connectionType);
		} catch (Exception e){
			logger.error(getClassName() + "init() - connectionType=" + connectionType, e);
			throw e;
		}
	} // end constructor
	public List<TblPatrolresultreadingrecordEo> read(Object so) throws Exception{
		List<TblPatrolresultreadingrecordEo> tblPatrolresultreadingrecordEoList = null;
		try{
			tblPatrolresultreadingrecordEoList = dao.read(so);
		}
		catch (Exception e){
			logger.error(getClassName() + ".read() - so=" + so, e);
			throw e;
		} // end try ... catch
		return tblPatrolresultreadingrecordEoList;
	} // end select function
	public Integer create(TblPatrolresultreadingrecordEo eo) throws Exception{
		Integer noOfAffectedRow = null;
		try{
			noOfAffectedRow = dao.create(eo);
		}
		catch (Exception e){
			logger.error(getClassName() + ".create() - eo=" + eo, e);
			throw e;
		} // end try ... catch
		return noOfAffectedRow;
	} // end create function
	public Integer update(TblPatrolresultreadingrecordEo eo) throws Exception{
		Integer noOfAffectedRow = null;
		try{
			noOfAffectedRow = dao.update(eo);
		}
		catch (Exception e){
			logger.error(getClassName() + ".update() - eo=" + eo, e);
			throw e;
		} // end try ... catch
		return noOfAffectedRow;
	} // end create function
	public Integer delete(TblPatrolresultreadingrecordEo eo) throws Exception{
		Integer noOfAffectedRow = null;
		try{
			noOfAffectedRow = dao.delete(eo);
		}
		catch (Exception e){
			logger.error(getClassName() + ".delete() - eo=" + eo, e);
			throw e;
		} // end try ... catch
		return noOfAffectedRow;
	} // end create function
} //end class
