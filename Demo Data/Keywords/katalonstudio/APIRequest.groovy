package katalonstudio

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

public class APIRequest {
	/**
	 * Verify Request Request information after creating
	 * @param requestType Request's Type
	 * @param requestURL Request's Url
	 * @param requestAutorization Request's Authorization
	 */
	@Keyword
	def verifyRESTRequest(String requestName, String requestType, String requestURL, String requestAuthorization){
		KeywordUtil.logInfo("Start to verify Request")

		def currRequestType = Windows.getText(findWindowsObject("Object Repository/Katalon/CenterPanel/Request Information/txb_Request Type", ['requestName':requestName]), FailureHandling.STOP_ON_FAILURE)
		Windows.verifyEqual(currRequestType, requestType, FailureHandling.CONTINUE_ON_FAILURE)

		def currRequestURL = Windows.getText(findWindowsObject("Object Repository/Katalon/CenterPanel/Request Information/txb_Request URL", , ['requestName':requestName]), FailureHandling.STOP_ON_FAILURE)
		Windows.verifyEqual(currRequestURL, requestURL, FailureHandling.CONTINUE_ON_FAILURE)

		def currRequestAuthorization = Windows.getText(findWindowsObject("Object Repository/Katalon/CenterPanel/Request Information/txb_Authorization"), FailureHandling.STOP_ON_FAILURE)
		Windows.verifyEqual(currRequestAuthorization, requestAuthorization, FailureHandling.CONTINUE_ON_FAILURE)

		KeywordUtil.logInfo("End to verify Request")
	}

	@Keyword
	def executeOpenedSOAPRequest(String requestName, int timeOut){
		KeywordUtil.logInfo("Start to execute SOAP Request")

		Windows.click(findWindowsObject("Object Repository/Katalon/CenterPanel/SOAP Request/btn_Load Service Function"), FailureHandling.STOP_ON_FAILURE)
		Windows.delay(timeOut, FailureHandling.OPTIONAL)
		Windows.click(findWindowsObject("Object Repository/Katalon/CenterPanel/SOAP Request/btn_Load New Content"), FailureHandling.STOP_ON_FAILURE)
		Windows.delay(timeOut, FailureHandling.OPTIONAL)
		Windows.click(findWindowsObject("Object Repository/Katalon/CenterPanel/SOAP Request/btn_OK"), FailureHandling.STOP_ON_FAILURE)

		KeywordUtil.logInfo("Start to send SOAP Request")
		Windows.click(findWindowsObject("Object Repository/Katalon/CenterPanel/SOAP Request/btn_Run Request", ["requestName":requestName]), FailureHandling.STOP_ON_FAILURE)
		Windows.click(findWindowsObject("Object Repository/Katalon/CenterPanel/SOAP Request/btn_OK"), FailureHandling.STOP_ON_FAILURE)
		Windows.waitForElementNotPresent(findWindowsObject("Object Repository/Katalon/CenterPanel/SOAP Request/lbl_Sending Request"), timeOut*4, FailureHandling.OPTIONAL)
		KeywordUtil.logInfo("Sending SOAP Request is completed")

		Windows.verifyElementPresent(findWindowsObject("Object Repository/Katalon/CenterPanel/SOAP Request/lbl_Status 200"), timeOut, FailureHandling.CONTINUE_ON_FAILURE)
		KeywordUtil.logInfo("End to execute SOAP Request")
	}
}
