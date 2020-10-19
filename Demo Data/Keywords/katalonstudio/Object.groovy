package katalonstudio

import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Object {
	/**
	 * Create New Web Object
	 * @param testObjectName test object's name
	 * @param testObjectDescription test object's description
	 */
	@Keyword
	def createNewTestObject(String testObjectName, String testObjectDescription){
		KeywordUtil.logInfo("Start to create new Web Object")

		Windows.rightClick(findWindowsObject("Object Repository/Katalon/LeftPanel/Context Menu/ctx_Menu Item_Object Repository"), FailureHandling.STOP_ON_FAILURE)
		Windows.sendKeys(findWindowsObject("Object Repository/Katalon/LeftPanel/Context Menu/ctx_Menu Item_Object Repository"), Keys.chord("N"), FailureHandling.STOP_ON_FAILURE)
		Windows.sendKeys(findWindowsObject("Object Repository/Katalon/LeftPanel/Context Menu/ctx_Menu Item_Object Repository"), Keys.chord("T"), FailureHandling.STOP_ON_FAILURE)

		Windows.setText(findWindowsObject("Object Repository/Katalon/LeftPanel/Test Object/Web Object/txb_Object Name"), testObjectName, FailureHandling.STOP_ON_FAILURE)
		Windows.setText(findWindowsObject("Object Repository/Katalon/LeftPanel/Test Object/Web Object/txb_Description"), testObjectDescription, FailureHandling.STOP_ON_FAILURE)
		Windows.click(findWindowsObject("Object Repository/Katalon/LeftPanel/Test Object/Web Object/btn_OK"), FailureHandling.STOP_ON_FAILURE)

		KeywordUtil.logInfo("End to create new Web Object")
	}

	/**
	 * Verify Object Exist
	 * @param testObjectName test object's name
	 * @param testObjectDescription test object's description
	 */
	@Keyword
	def verifyObjectExist(String testObjectName, int timeOut = GlobalVariable.G_TimeOut_Short){
		KeywordUtil.logInfo("Start to verify newly created Object")
		Windows.verifyElementPresent(findWindowsObject("Object Repository/Katalon/LeftPanel/Test Object/obj_Created Object", ["objectName":testObjectName]), timeOut, FailureHandling.CONTINUE_ON_FAILURE)
		KeywordUtil.logInfo("End to verify newly created Object")
	}

	/**
	 * Create New Web Object
	 * @param testObjectName test object's name
	 * @param testObjectDescription test object's description
	 */
	@Keyword
	def createNewMobileObject(String testObjectName, String testObjectDescription){
		KeywordUtil.logInfo("Start to create new Mobile Object")

		Windows.rightClick(findWindowsObject("Object Repository/Katalon/LeftPanel/Context Menu/ctx_Menu Item_Object Repository"), FailureHandling.STOP_ON_FAILURE)
		Windows.sendKeys(findWindowsObject("Object Repository/Katalon/LeftPanel/Context Menu/ctx_Menu Item_Object Repository"), Keys.chord("N"), FailureHandling.STOP_ON_FAILURE)
		Windows.sendKeys(findWindowsObject("Object Repository/Katalon/LeftPanel/Context Menu/ctx_Menu Item_Object Repository"), Keys.chord("M"), FailureHandling.STOP_ON_FAILURE)

		Windows.setText(findWindowsObject("Object Repository/Katalon/LeftPanel/Test Object/Web Object/txb_Object Name"), testObjectName, FailureHandling.STOP_ON_FAILURE)
		Windows.setText(findWindowsObject("Object Repository/Katalon/LeftPanel/Test Object/Web Object/txb_Description"), testObjectDescription, FailureHandling.STOP_ON_FAILURE)
		Windows.click(findWindowsObject("Object Repository/Katalon/LeftPanel/Test Object/Web Object/btn_OK"), FailureHandling.STOP_ON_FAILURE)

		KeywordUtil.logInfo("End to create new Mobile Object")
	}

	/**
	 * Create New Window Object
	 * @param testObjectName test object's name
	 * @param testObjectDescription test object's description
	 */
	@Keyword
	def createNewWindowObject(String testObjectName, String testObjectDescription){
		KeywordUtil.logInfo("Start to create new Window Object")

		Windows.rightClick(findWindowsObject("Object Repository/Katalon/LeftPanel/Context Menu/ctx_Menu Item_Object Repository"), FailureHandling.STOP_ON_FAILURE)
		Windows.sendKeys(findWindowsObject("Object Repository/Katalon/LeftPanel/Context Menu/ctx_Menu Item_Object Repository"), Keys.chord("N"), FailureHandling.STOP_ON_FAILURE)
		Windows.sendKeys(findWindowsObject("Object Repository/Katalon/LeftPanel/Context Menu/ctx_Menu Item_Object Repository"), Keys.chord("W"), FailureHandling.STOP_ON_FAILURE)
		Windows.sendKeys(findWindowsObject("Object Repository/Katalon/LeftPanel/Context Menu/ctx_Menu Item_Object Repository"), Keys.chord("W"), FailureHandling.STOP_ON_FAILURE)
		Windows.sendKeys(findWindowsObject("Object Repository/Katalon/LeftPanel/Context Menu/ctx_Menu Item_Object Repository"), Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

		Windows.setText(findWindowsObject("Object Repository/Katalon/LeftPanel/Test Object/Web Object/txb_Object Name"), testObjectName, FailureHandling.STOP_ON_FAILURE)
		Windows.setText(findWindowsObject("Object Repository/Katalon/LeftPanel/Test Object/Web Object/txb_Description"), testObjectDescription, FailureHandling.STOP_ON_FAILURE)
		Windows.click(findWindowsObject("Object Repository/Katalon/LeftPanel/Test Object/Web Object/btn_OK"), FailureHandling.STOP_ON_FAILURE)

		KeywordUtil.logInfo("End to create new Window Object")
	}

	/**
	 * Create New API Object
	 * @param requestName test object's name
	 * @param requestType test object's type
	 * @param requestURL test object's URL
	 * @param requestDescription test object's Description
	 */
	@Keyword
	def createNewAPIObject(String requestName, String requestType, String requestURL, String requestDescription){
		KeywordUtil.logInfo("Start to create new API Object")

		Windows.rightClick(findWindowsObject("Object Repository/Katalon/LeftPanel/Context Menu/ctx_Menu Item_Object Repository"), FailureHandling.STOP_ON_FAILURE)
		Windows.sendKeys(findWindowsObject("Object Repository/Katalon/LeftPanel/Context Menu/ctx_Menu Item_Object Repository"), Keys.chord("N"), FailureHandling.STOP_ON_FAILURE)
		Windows.sendKeys(findWindowsObject("Object Repository/Katalon/LeftPanel/Context Menu/ctx_Menu Item_Object Repository"), Keys.chord("W"), FailureHandling.STOP_ON_FAILURE)
		Windows.sendKeys(findWindowsObject("Object Repository/Katalon/LeftPanel/Context Menu/ctx_Menu Item_Object Repository"), Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

		Windows.setText(findWindowsObject("Object Repository/Katalon/LeftPanel/Test Object/API Object/txb_Request Name"), requestName, FailureHandling.STOP_ON_FAILURE)
		Windows.setText(findWindowsObject("Object Repository/Katalon/LeftPanel/Test Object/API Object/txb_Request URL"), requestURL, FailureHandling.STOP_ON_FAILURE)
		Windows.setText(findWindowsObject("Object Repository/Katalon/LeftPanel/Test Object/API Object/txb_Request Description"), requestDescription, FailureHandling.STOP_ON_FAILURE)

		switch(requestType.toLowerCase()){
			case "restful":
				break

			case "soap":
				Windows.sendKeys(findWindowsObject("Object Repository/Katalon/LeftPanel/Test Object/API Object/cbb_RequestType"), Keys.chord(Keys.ARROW_UP), FailureHandling.STOP_ON_FAILURE)
				break
		}

		Windows.click(findWindowsObject("Object Repository/Katalon/LeftPanel/Test Object/API Object/btn_OK"), FailureHandling.STOP_ON_FAILURE)
		KeywordUtil.logInfo("End to create new API Object")
	}
}
