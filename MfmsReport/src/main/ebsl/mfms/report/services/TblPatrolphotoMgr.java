package ebsl.mfms.report.services;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.daos.TblPatrolphotoDao;
import ebsl.mfms.report.models.eos.TblPatrolphotoEo;
public class TblPatrolphotoMgr extends ServiceBase{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private TblPatrolphotoDao dao;
	private String getClassName(){
		return this.getClass().getName();
	}
	public TblPatrolphotoMgr() throws Exception{
		try{
			init(null);
		} catch (Exception e){
			logger.error(getClassName() + ".TblPatrolphotoMgr() - connectionType=", e);
			throw e;
		}
	} // end constructor
	public TblPatrolphotoMgr(String connectionType) throws Exception{
		try{
			init(connectionType);
		} catch (Exception e){
			logger.error(getClassName() + ".TblPatrolphotoMgr() - connectionType=" + connectionType, e);
			throw e;
		}
	} // end constructor
	public void init(String connectionType) throws Exception{
		try{
			dao = new TblPatrolphotoDao(connectionType);
		} catch (Exception e){
			logger.error(getClassName() + "init() - connectionType=" + connectionType, e);
			throw e;
		}
	} // end constructor
	public List<TblPatrolphotoEo> read(Object so) throws Exception{
		List<TblPatrolphotoEo> tblPatrolphotoEoList = null;
		try{
			tblPatrolphotoEoList = dao.read(so);
		}
		catch (Exception e){
			logger.error(getClassName() + ".read() - so=" + so, e);
			throw e;
		} // end try ... catch
		return tblPatrolphotoEoList;
	} // end select function
	public Integer create(TblPatrolphotoEo eo) throws Exception{
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
	public Integer update(TblPatrolphotoEo eo) throws Exception{
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
	public Integer delete(TblPatrolphotoEo eo) throws Exception{
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
