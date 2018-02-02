package ebsl.mfms.report.daos;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ebsl.mfms.report.models.eos.TblLocationEo;
import ebsl.mfms.report.models.sos.TblLocationSo;
import org.junit.Assert;

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

	@Test
	public void testCreateTblLocationEo() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateTblLocationEo() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteTblLocationEo() {
		fail("Not yet implemented");
	}

}
