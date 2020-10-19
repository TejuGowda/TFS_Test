import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

"DATA Start PREPARATION"
	projectLocation = "D:\\LocNguyen\\Sample Project\\Project for KRE Execution"
	projectName = projectLocation.substring(projectLocation.lastIndexOf("\\") + 1)
"DATA End PREPARATION"

"Step#1: Open the Katalon Tool"
//CustomKeywords.'katalonstudio.Application.startKatalon'()

"Step#2: Close and clean current opened Project"
CustomKeywords.'katalonstudio.Project.closeAndCleanProject'()

"Step#3: Open an existing Project from Start Page"
CustomKeywords.'katalonstudio.Project.openProjectFromMenu'(GlobalVariable.G_Sample_Project_Location)

"Step#4: Make a minor wait before verification"
WebUiBuiltInKeywords.delay(GlobalVariable.G_TimeOut_Short, FailureHandling.OPTIONAL)

"Step#5: Verify Project is opened successfully"
CustomKeywords.'katalonstudio.Project.verifyProjectOpened'(projectName)

@SetUp()
void setup() {
	if(GlobalVariable.G_IsCloseKatalon){
		"Close all opened Katalon"
		CustomKeywords.'katalonstudio.Application.closeAllOpenKatalon'()
		"Make a minor wait before moving to next test cases"
		WebUiBuiltInKeywords.delay(GlobalVariable.G_TestCase_Switch_Time, FailureHandling.OPTIONAL)
		"Step#1: Open the Katalon Tool"
		CustomKeywords.'katalonstudio.Application.startKatalon'()
	}
}

@TearDown()
void teardown(){
	"Make a minor wait before moving to next test cases"
	WebUiBuiltInKeywords.delay(GlobalVariable.G_TestCase_Switch_Time, FailureHandling.OPTIONAL)
}