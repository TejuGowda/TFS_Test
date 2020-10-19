import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable as GlobalVariable

"Step#1: Call KRE to run an existing Project to generate Report"
CustomKeywords.'katalonstudio.Application.executeScriptByKRE'(GlobalVariable.G_BatchExecution, GlobalVariable.G_TimeOut_Long)

"Step#2: Make a minor wait for the execution completed"
Windows.delay(GlobalVariable.G_TimeOut_Long, FailureHandling.OPTIONAL)