import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

KeywordUtil.logInfo("This is manual test case")

@SetUp()
void setup() {
	CustomKeywords.'katalonstudio.Application.closeAllOpenKatalon'()
}

@TearDown()
void teardown(){
	"Make a minor wait before moving to next test cases"
	WebUiBuiltInKeywords.delay(GlobalVariable.G_TimeOut_Short, FailureHandling.OPTIONAL)
}