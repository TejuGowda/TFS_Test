import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

"DATA Start PREPARATION"
	testCaseName = CustomKeywords.'UtilHelper.generateUniqueString'("TC Name")
	testCaseDescription = CustomKeywords.'UtilHelper.generateUniqueString'("TC Description")
	testCaseTag = CustomKeywords.'UtilHelper.generateUniqueString'("TC Tag")
	def runningProjectLocation = CustomKeywords.'utilHelper.IOHelper.getProjectFolder'()
	projectLocation =  runningProjectLocation.split("KatalonTestOps")[0] + "Sample Project/Project for KRE Execution"
	projectName = projectLocation.substring(projectLocation.lastIndexOf("/") + 1)
	def testStep = CustomKeywords.'katalonstudio.TestCase.getTestStepsFromFile'()
"DATA End PREPARATION"

"Step#1: Open the Katalon Tool"
CustomKeywords.'katalonstudio.Application.startKatalon'()

"Step#2: Close and clean current opened Project"
CustomKeywords.'katalonstudio.Project.closeAndCleanProject'()

"Step#3: Open an existing Project from Start Page"
CustomKeywords.'katalonstudio.Project.openProjectFromStartScreen'(GlobalVariable.G_Sample_Project_Location)

"Step#4: Make a minor wait before verification"
WebUiBuiltInKeywords.delay(GlobalVariable.G_TimeOut_Short, FailureHandling.OPTIONAL)

"Step#5: Verify Project is opened successfully"
//CustomKeywords.'katalonstudio.Project.verifyProjectOpened'(projectName)

"Step#6: Create new blank Test Case"
CustomKeywords.'katalonstudio.TestCase.createNewTestCase'(testCaseName, testCaseDescription, testCaseTag)

"Step#7: Make a minor wait for test case created"
Windows.delay(GlobalVariable.G_TimeOut_Short, FailureHandling.OPTIONAL)

"Step#8: Verify .script file is created successfully "
def testScriptPath = CustomKeywords.'utilHelper.IOHelper.verifyTestScriptExist'(projectLocation + "/Scripts/" + testCaseName)

"Step#9: Enter test step into test case"
CustomKeywords.'katalonstudio.TestCase.enterTestScriptSteps'(testScriptPath, testStep)

"Step#10: Refresh Project"
CustomKeywords.'katalonstudio.Project.refreshProject'()

"Step#11: Verify script displayed in correct folder after refreshing Project"
CustomKeywords.'utilHelper.IOHelper.verifyTestScriptExist'(projectLocation + "/Scripts/" + testCaseName)

"Step#12: Verify test case dispayed in the Katalon Tool"
CustomKeywords.'katalonstudio.TestCase.verifyTestCaseExist'(testCaseName)

@SetUp()
void setup() {
	CustomKeywords.'katalonstudio.Application.closeAllOpenKatalon'()
}

@TearDown()
void teardown(){
	"Make a minor wait before moving to next test cases"
	WebUiBuiltInKeywords.delay(GlobalVariable.G_TestCase_Switch_Time, FailureHandling.OPTIONAL)
}