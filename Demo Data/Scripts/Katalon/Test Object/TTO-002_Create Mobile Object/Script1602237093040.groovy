import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

"DATA Start PREPARATION"
	testObjectName = CustomKeywords.'UtilHelper.generateUniqueString'("Mobile Object Name")
	testObjectDescription = CustomKeywords.'UtilHelper.generateUniqueString'("Mobile Object Description")
"DATA End PREPARATION"

"Step#1: Open the Katalon Tool"
CustomKeywords.'katalonstudio.Application.startKatalon'()

"Step#2: Close and clean current opened Project"
CustomKeywords.'katalonstudio.Project.closeAndCleanProject'()

"Step#3: Open an existing Project from Start Page"
CustomKeywords.'katalonstudio.Project.openProjectFromStartScreen'(GlobalVariable.G_Generic_Project_Location)

"Step#4: Make a minor wait before verification"
WebUiBuiltInKeywords.delay(GlobalVariable.G_TimeOut_Short, FailureHandling.OPTIONAL)

"Step#5: Create new blank Mobile Test Object"
CustomKeywords.'katalonstudio.Object.createNewMobileObject'(testObjectName, testObjectDescription)

"Step#6: Make a minor wait for Mobile Object created"
Windows.delay(GlobalVariable.G_TimeOut_Short, FailureHandling.OPTIONAL)

"Step#7: Verify Mobile Object is created successfully"
CustomKeywords.'katalonstudio.Object.verifyObjectExist'(testObjectName)

@SetUp()
void setup(){
	if(GlobalVariable.G_IsCloseKatalon){
		CustomKeywords.'katalonstudio.Application.closeAllOpenKatalon'()
	}else{
		CustomKeywords.'katalonstudio.Project.closeAndCleanProject'()
	}	
}

@TearDown()
void teardown(){
	"Make a minor wait before moving to next test cases"
	WebUiBuiltInKeywords.delay(GlobalVariable.G_TimeOut_Short, FailureHandling.OPTIONAL)
}