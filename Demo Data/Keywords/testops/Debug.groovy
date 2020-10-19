package testops

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

public class Debug {
	/**
	 * Navigate to Organization's Details page
	 */
	@Keyword
	def navigateToOrganizationPage(String organizationName){
		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Top Navigation Bar/ico_HomeApplication"), FailureHandling.STOP_ON_FAILURE)
		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Left Panel/lnk_Organization Name", ["organizationName":organizationName]), FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def isOnOrgPage(String organizationName){
		//WebUiBuiltInKeywords.veri
		WebUiBuiltInKeywords.verifyEqual(false, true, FailureHandling.STOP_ON_FAILURE)
	}
}
