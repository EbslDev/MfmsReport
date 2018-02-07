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
	public void generateExcel(List<ExportPatrolRoutineVo> exportPatrolRoutineVoList) throws Exception {
		try{
			for (int i =0; i < exportPatrolRoutineVoList.size(); i++) {
				ExportPatrolRoutineVo vo = exportPatrolRoutineVoList.get(i);
			}
		} catch (Exception e){
			logger.error(getClassName() + ".generateExcel() - exportPatrolRoutineVoList=" + exportPatrolRoutineVoList, e);
			throw e;
		}
	}
}
