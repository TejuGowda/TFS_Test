import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

"DATA Start PREPARATION"
	projectName = CustomKeywords.'UtilHelper.generateUniqueString'("ProjectName")
	projectType = "Web"
	projectLocation = null
	projectDescription = CustomKeywords.'UtilHelper.generateUniqueString'("Description")
"DATA End PREPARATION"

"Step#1: Open the Katalon Tool"
CustomKeywords.'katalonstudio.Application.startKatalon'()

"Step#2: Close and clean current opened Project"
CustomKeywords.'katalonstudio.Project.closeAndCleanProject'()

"Step#3: Create new Web Project from Start Page"
CustomKeywords.'katalonstudio.Project.createNewProjectByTypeFromStartPage'(projectName, projectType, projectLocation, projectDescription, GlobalVariable.G_TimeOut_Short)

"Step#4: Verify newly Web Project is created successfully"
CustomKeywords.'katalonstudio.Project.verifyProjectOpened'(projectName)

@SetUp()
void setup(){
	CustomKeywords.'katalonstudio.Application.closeAllOpenKatalon'()
}

@TearDown()
void teardown(){
	"Make a minor wait before moving to next test cases"
	WebUiBuiltInKeywords.delay(GlobalVariable.G_TestCase_Switch_Time, FailureHandling.OPTIONAL)
}