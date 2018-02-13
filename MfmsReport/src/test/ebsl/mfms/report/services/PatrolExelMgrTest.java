package ebsl.mfms.report.services;

import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import ebsl.mfms.report.daos.DaoBase;
import ebsl.mfms.report.models.sos.ExportPatrolRoutineSo;
import ebsl.mfms.report.models.vos.ExportPatrolRoutineVo;


public class PatrolExelMgrTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Ignore
	@Test
	public void testGenerateExcelAndSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testGenerateExcel() {
		try {
			TblPatrolresultMgr mgr = new TblPatrolresultMgr(DaoBase.CONNECTION_TYPE_JDBC);
			
			ExportPatrolRoutineSo so = new ExportPatrolRoutineSo();
			so.setSiteKey(2);
			List<ExportPatrolRoutineVo> exportPatrolRoutineVoList = mgr.readByExportPatrolRoutineSo(so);
			PatrolExcelMgr pMgr = new PatrolExcelMgr();
			List<ByteArrayOutputStream> byteArrayOutputStreamList = new ArrayList<ByteArrayOutputStream>();
			pMgr.generateExcels(exportPatrolRoutineVoList, null);

//			pMgr.compressByteArrayOutputStreamListAndSave(compressFileDtoList);
			
			Assert.assertTrue(exportPatrolRoutineVoList.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

}
