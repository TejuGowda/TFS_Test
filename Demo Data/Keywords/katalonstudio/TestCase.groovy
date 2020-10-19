package katalonstudio

import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class TestCase {
	def void enterDataForNewTestCase(String testCaseName, String testCaseDescription, String testCaseTag){
		KeywordUtil.logInfo("Start to enter data for new Test Case")
		Windows.setText(findWindowsObject('Object Repository/Katalon/Dialog/New Test Case/txb_Test Case Name'), testCaseName, FailureHandling.STOP_ON_FAILURE)
		Windows.setText(findWindowsObject('Object Repository/Katalon/Dialog/New Test Case/txb_Description'), testCaseDescription, FailureHandling.STOP_ON_FAILURE)
		Windows.setText(findWindowsObject('Object Repository/Katalon/Dialog/New Test Case/txb_Tag'), testCaseTag, FailureHandling.STOP_ON_FAILURE)
		Windows.click(findWindowsObject('Object Repository/Katalon/Dialog/New Test Case/btn_OK'), FailureHandling.STOP_ON_FAILURE)
		KeywordUtil.logInfo("End to enter data for new Test Case")
	}

	/**
	 * Create New Test Case
	 * @param testCaseName name of test case will be created
	 * @param testCaseDescription description for test case
	 * @param testCaseTag tag of test case
	 */
	@Keyword
	def createNewTestCase(String testCaseName, String testCaseDescription, String testCaseTag){
		KeywordUtil.logInfo("Start to create new Test Case")
		Windows.rightClick(findWindowsObject("Object Repository/Katalon/LeftPanel/Context Menu/node_Test Case"), FailureHandling.STOP_ON_FAILURE)
		Windows.sendKeys(findWindowsObject("Object Repository/Katalon/LeftPanel/Context Menu/node_Test Case"), Keys.chord("N"), FailureHandling.STOP_ON_FAILURE)
		Windows.sendKeys(findWindowsObject("Object Repository/Katalon/LeftPanel/Context Menu/node_Test Case"), Keys.chord("T"), FailureHandling.STOP_ON_FAILURE)
		this.enterDataForNewTestCase(testCaseName, testCaseDescription, testCaseTag)
		KeywordUtil.logInfo("End to create new Test Case")
	}

	/**
	 * Get Test Step from File
	 *
	 */
	@Keyword
	def String getTestStepsFromFile(){
		def fileContents
		try{
			def projectFolder = RunConfiguration.getProjectDir()
			fileContents = new File(projectFolder + "\\Test Script Template\\Template.txt").text
		}catch (Exception e){
			KeywordUtil.markFailedAndStop("Cannot read data from file")
		}

		KeywordUtil.markPassed("Completed reading data: ${fileContents}")
		return fileContents.toString()
	}


	/**
	 * Enter Test Script Step
	 * @param location Path of test script
	 * @param data value will be entered into test script
	 *
	 */
	@Keyword
	def String enterTestScriptSteps(String location, String data){
		KeywordUtil.logInfo("Start to enter test step for test case")

		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter out = null;

		try {
			fw = new FileWriter(location, true);
			bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
			out.println(data);
			out.close();
		} catch (IOException e) {
			KeywordUtil.markFailedAndStop("Cannot enter test steps for test script")
		}

		KeywordUtil.logInfo("Start to enter test step for test case")
		KeywordUtil.markPassed("Enter test step for test case successfully")
	}

	/**
	 * Verify Test Case Exist
	 * @param testObjectName test object's name
	 * @param testObjectDescription test object's description
	 */
	@Keyword
	def verifyTestCaseExist(String testCaseName, int timeOut = GlobalVariable.G_TimeOut_Short){
		KeywordUtil.logInfo("Start to verify newly created Object")
		Windows.verifyElementPresent(findWindowsObject("Object Repository/Katalon/LeftPanel/Test Case/obj_Created Test Case", ["testCaseName":testCaseName]), timeOut, FailureHandling.CONTINUE_ON_FAILURE)
		KeywordUtil.logInfo("End to verify newly created Object")
	}
}
