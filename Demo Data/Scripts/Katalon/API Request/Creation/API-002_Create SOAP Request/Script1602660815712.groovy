import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

"DATA Start PREPARATION"
	testObjectName = CustomKeywords.'UtilHelper.generateUniqueString'("SOAP Request")
	testObjectDescription = CustomKeywords.'UtilHelper.generateUniqueString'("SOAP Request Description")
	testObjectURL = "http://webservices.gama-system.com/exchangerates.asmx?WSDL"
	testObjectType = "SOAP"
"DATA End PREPARATION"

"Step#1: Open the Katalon Tool"
CustomKeywords.'katalonstudio.Application.startKatalon'()

"Step#2: Close and clean current opened Project"
CustomKeywords.'katalonstudio.Project.closeAndCleanProject'()

"Step#3: Open an existing Project from Start Page"
CustomKeywords.'katalonstudio.Project.openProjectFromStartScreen'(GlobalVariable.G_Generic_Project_Location)

"Step#4: Make a minor wait before verification"
WebUiBuiltInKeywords.delay(GlobalVariable.G_TimeOut_Short, FailureHandling.OPTIONAL)

"Step#5: Create new SOAP API Request"
CustomKeywords.'katalonstudio.Object.createNewAPIObject'(testObjectName, testObjectType, testObjectURL, testObjectDescription)

"Step#6: Make a minor wait for Window Object created"
Windows.delay(GlobalVariable.G_TimeOut_Short, FailureHandling.OPTIONAL)

"Step#7: Verify SOAP Request is created successfully"
CustomKeywords.'katalonstudio.Object.verifyObjectExist'(testObjectName)

"Step#8: Verify SOAP Request is executed successfully"
CustomKeywords.'katalonstudio.APIRequest.executeOpenedSOAPRequest'(testObjectName, GlobalVariable.G_TimeOut_Short)

@SetUp()
void setup() {
	CustomKeywords.'katalonstudio.Application.closeAllOpenKatalon'()
}

@TearDown()
void teardown(){
	"Make a minor wait before moving to next test cases"
	WebUiBuiltInKeywords.delay(GlobalVariable.G_TimeOut_Short, FailureHandling.OPTIONAL)
}