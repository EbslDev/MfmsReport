package ebsl.mfms.report.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ebsl.mfms.report.models.vos.ExportPatrolRoutineVo;

public class PatrolExcelMgr extends ServiceBase{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private String getClassName(){
		return this.getClass().getName();
	}
	public void generateExcel(List<ExportPatrolRoutineVo> exportPatrolRoutineVo ) throws Exception {
		try{
			
		} catch (Exception e){
			logger.error(getClassName() + ".generateExcel() - exportPatrolRoutineVo=" + exportPatrolRoutineVo, e);
			throw e;
		}
	}
}
