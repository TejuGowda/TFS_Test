package testops

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import internal.GlobalVariable

public class TestOpsLogin {
	/**
	 * Open Browser
	 */
	@Keyword
	def openBrowser(String isOpen = "Open"){
		KeywordUtil.logInfo("Start Open Browser")
		"Open URL to lauch the Web Application"
		if(isOpen!="NotOpen"){
			WebUiBuiltInKeywords.openBrowser(GlobalVariable.G_URL, FailureHandling.STOP_ON_FAILURE)
			WebUiBuiltInKeywords.maximizeWindow(FailureHandling.OPTIONAL)
		}
	}

	/**
	 * Login System
	 */

	@Keyword
	def loginSystem(String userName = GlobalVariable.G_UserName, String passWord = GlobalVariable.G_Password, String isClick = "Yes") {
		KeywordUtil.logInfo("Start Login")
		if(userName!=null){
			"Input Username if it is specified"
			WebUiBuiltInKeywords.setText(ObjectRepository.findTestObject("TestOps/Login/txb_UserName"), userName, FailureHandling.STOP_ON_FAILURE)
		}

		if(passWord!=null){
			"Input Password if it is specified"
			WebUiBuiltInKeywords.setText(ObjectRepository.findTestObject("TestOps/Login/txb_Password"), passWord, FailureHandling.STOP_ON_FAILURE)
		}

		if(isClick!=null){
			"Click on 'Login' button"
			WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("TestOps/Login/btn_SignIn"), FailureHandling.STOP_ON_FAILURE)
		}
	}

	/**
	 * Verify user login to system successfully
	 */
	@Keyword
	def verifyLoginSuccessfully(){
		KeywordUtil.logInfo("Start Verification")
		WebUiBuiltInKeywords.verifyElementPresent(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Center Panel/lbl_Welcome Organization"), GlobalVariable.G_TimeOut, FailureHandling.STOP_ON_FAILURE)
		KeywordUtil.logInfo("End Verification")
	}

	/**
	 * Log out of System
	 */
	@Keyword
	def logOutSystem(){
		KeywordUtil.logInfo("Start Logging Out")
		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Login/btn_MyProfile"), FailureHandling.STOP_ON_FAILURE)
		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Login/btn_SignOut"), FailureHandling.STOP_ON_FAILURE)
		KeywordUtil.logInfo("End Logging Out")
	}

	/**
	 * Verify Log out of System successfully
	 */
	@Keyword
	def verifyLogOutSuccessfully(){
		KeywordUtil.logInfo("Start Verification for Logging Out")
		WebUiBuiltInKeywords.verifyElementNotPresent(ObjectRepository.findTestObject("Object Repository/TestOps/Login/btn_MyProfile"), GlobalVariable.G_TimeOut, FailureHandling.STOP_ON_FAILURE)
		KeywordUtil.logInfo("End Verification for Logging Out")
	}
}
