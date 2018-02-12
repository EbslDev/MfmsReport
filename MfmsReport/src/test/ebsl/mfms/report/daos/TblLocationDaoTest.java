package ebsl.mfms.report.daos;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import ebsl.mfms.report.models.eos.TblLocationEo;
import ebsl.mfms.report.models.sos.TblLocationSo;

public class TblLocationDaoTest {

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

	@Test
	public void testReadObject() {
		try {
			TblLocationDao dao = new TblLocationDao(DaoBase.CONNECTION_TYPE_JDBC);
			
			TblLocationSo so = new TblLocationSo();
			so.setlSiteKey(2);
			List<TblLocationEo> tblLocationEoList = dao.read(so);
			Assert.assertTrue(tblLocationEoList.size() > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testCreateTblLocationEo() {
		TblLocationDao dao;
		try {
			dao = new TblLocationDao(DaoBase.CONNECTION_TYPE_JDBC);
			TblLocationEo eo = new TblLocationEo();
			Integer lKey = 823;
			Integer lSiteKey = 2;
			String lCode = "TEST Code";
			String lName = "TEST Name";
			String lDesc = "Test Desc";
			String lTagId = "Test TagID";
			Integer lParentKey = 742;
			Integer lLevelKey = 4;
			String lChain = "144742823";
			Integer lCreatedBy = 1;
			Date lCreateDateTime = new Date();
			Integer lLastModifyBy = 1;
			Date lLastModifyDateTime = new Date();
			String lDelete = "N";
			Date lLastModifyTimeForSync = new Date();
			eo.setlKey(lKey);
			eo.setlSiteKey(lSiteKey);
			eo.setlCode(lCode);
			eo.setlName(lName);
			eo.setlDesc(lDesc);
			eo.setlTagID(lTagId);
			eo.setlParentKey(lParentKey);
			eo.setlLevelKey(lLevelKey);
			eo.setlChain(lChain);
			eo.setlParentKey(lParentKey);
			eo.setlChain(lChain);
			eo.setlCreateBy(lCreatedBy);
			eo.setlCreateDateTime(lCreateDateTime);
			eo.setlLastModifyBy(lLastModifyBy);
			eo.setlLastModifyDateTime(lLastModifyDateTime);
			eo.setlDeleted(lDelete);
			eo.setlLastModifyTimeForSync(lLastModifyTimeForSync);
			Integer noOfAffectedRow = dao.create(eo);
			Assert.assertTrue(noOfAffectedRow > 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Ignore
	@Test
	public void testUpdateTblLocationEo() {
		TblLocationDao dao;
		try {
			dao = new TblLocationDao(DaoBase.CONNECTION_TYPE_JDBC);
			TblLocationEo eo = new TblLocationEo();
			Integer lKey = 823;
			Integer lSiteKey = 2;
			String lCode = "TEST Code VV";
			String lName = "TEST Name VV";
			String lDesc = "Test Desc";
			String lTagId = "Test TagID";
			Integer lParentKey = 742;
			Integer lLevelKey = 4;
			String lChain = "144742823";
			Integer lCreatedBy = 1;
			Date lCreateDateTime = new Date();
			Integer lLastModifyBy = 1;
			Date lLastModifyDateTime = new Date();
			String lDelete = "N";
			Date lLastModifyTimeForSync = new Date();
			eo.setlKey(lKey);
			eo.setlSiteKey(lSiteKey);
			eo.setlCode(lCode);
			eo.setlName(lName);
			eo.setlDesc(lDesc);
			eo.setlTagID(lTagId);
			eo.setlParentKey(lParentKey);
			eo.setlLevelKey(lLevelKey);
			eo.setlChain(lChain);
			eo.setlParentKey(lParentKey);
			eo.setlChain(lChain);
			eo.setlCreateBy(lCreatedBy);
			eo.setlCreateDateTime(lCreateDateTime);
			eo.setlLastModifyBy(lLastModifyBy);
			eo.setlLastModifyDateTime(lLastModifyDateTime);
			eo.setlDeleted(lDelete);
			eo.setlLastModifyTimeForSync(lLastModifyTimeForSync);
			Integer noOfAffectedRow = dao.update(eo);
			Assert.assertTrue(noOfAffectedRow > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteTblLocationEo() {
		TblLocationDao dao;
		try {
			dao = new TblLocationDao(DaoBase.CONNECTION_TYPE_JDBC);
			TblLocationEo eo = new TblLocationEo();
			Integer lKey = 823;
			Integer lSiteKey = 2;
			String lCode = "TEST Code VV";
			String lName = "TEST Name VV";
			String lDesc = "Test Desc";
			String lTagId = "Test TagID";
			Integer lParentKey = 742;
			Integer lLevelKey = 4;
			String lChain = "144742823";
			Integer lCreatedBy = 1;
			Date lCreateDateTime = new Date();
			Integer lLastModifyBy = 1;
			Date lLastModifyDateTime = new Date();
			String lDelete = "N";
			Date lLastModifyTimeForSync = new Date();
			eo.setlKey(lKey);
			eo.setlSiteKey(lSiteKey);
			eo.setlCode(lCode);
			eo.setlName(lName);
			eo.setlDesc(lDesc);
			eo.setlTagID(lTagId);
			eo.setlParentKey(lParentKey);
			eo.setlLevelKey(lLevelKey);
			eo.setlChain(lChain);
			eo.setlParentKey(lParentKey);
			eo.setlChain(lChain);
			eo.setlCreateBy(lCreatedBy);
			eo.setlCreateDateTime(lCreateDateTime);
			eo.setlLastModifyBy(lLastModifyBy);
			eo.setlLastModifyDateTime(lLastModifyDateTime);
			eo.setlDeleted(lDelete);
			eo.setlLastModifyTimeForSync(lLastModifyTimeForSync);
			Integer noOfAffectedRow = dao.delete(eo);
			Assert.assertTrue(noOfAffectedRow > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
