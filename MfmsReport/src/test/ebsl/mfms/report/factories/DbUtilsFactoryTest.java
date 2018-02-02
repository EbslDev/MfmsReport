package ebsl.mfms.report.factories;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ebsl.mfms.report.utils.DbUtils;
import org.junit.Assert;

public class DbUtilsFactoryTest {

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
	public void testGetInstanceOfMySqlDbUtils() {
		try {
			DbUtilsFactory dbUtilsFactory = DbUtilsFactory.getInstanceOfDbUtilsFactory();
			DbUtils dbUtils = dbUtilsFactory.getInstanceOfMySqlDbUtils();
			Connection connection = dbUtils.getConnection();
			Assert.assertNotNull(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
