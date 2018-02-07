package ebsl.mfms.report.services;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.daos.TblLocationDao;
import ebsl.mfms.report.models.eos.TblLocationEo;
public class TblLocationMgr extends ServiceBase{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private TblLocationDao dao;
	private String getClassName(){
		return this.getClass().getName();
	}
	public TblLocationMgr() throws Exception{
		try{
			init(null);
		} catch (Exception e){
			logger.error(getClassName() + ".TblLocationMgr() - connectionType=null", e);
			throw e;
		}
	} // end constructor
	public TblLocationMgr(String connectionType) throws Exception{
		try{
			init(connectionType);
		} catch (Exception e){
			logger.error(getClassName() + ".TblLocationMgr() - connectionType=" + connectionType, e);
			throw e;
		}
	} // end constructor
	public void init(String connectionType) throws Exception{
		try{
			dao = new TblLocationDao(connectionType);
		} catch (Exception e){
			logger.error(getClassName() + "init() - connectionType=" + connectionType, e);
			throw e;
		}
	} // end constructor
	public List<TblLocationEo> read(Object so) throws Exception{
		List<TblLocationEo> tblLocationEoList = null;
		try{
			tblLocationEoList = dao.read(so);
		}
		catch (Exception e){
			logger.error(getClassName() + ".read() - so=" + so, e);
			throw e;
		} // end try ... catch
		return tblLocationEoList;
	} // end select function
	public Integer create(TblLocationEo eo) throws Exception{
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
	public Integer update(TblLocationEo eo) throws Exception{
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
	public Integer delete(TblLocationEo eo) throws Exception{
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
