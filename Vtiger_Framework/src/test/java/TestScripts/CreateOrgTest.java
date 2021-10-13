package TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

public class CreateOrgTest extends BaseClass{

	@Test(retryAnalyzer = com.crm.vtiger.GenericUtils.RetryAnalyser.class)
	public void createOrgTest() {
		System.out.println("org createion failed");
	
		Assert.assertEquals("a", "n");
	}
}
