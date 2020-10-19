package katalonstudio

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Application {
	/**
	 * Start Katalon
	 * @param organizationName organization's Name will be created
	 */
	@Keyword
	def startKatalon(){
		KeywordUtil.logInfo("Begin to start Katalon Tool via Path: ${GlobalVariable.G_KatalonPath}")
		Windows.startApplication(GlobalVariable.G_KatalonPath, FailureHandling.STOP_ON_FAILURE)
		Windows.delay(20)
		KeywordUtil.logInfo("End starting Katalon Tool via Path: ${GlobalVariable.G_KatalonPath}")
	}

	/**
	 * Close all opened Katalon
	 * @param organizationName organization's Name will be created
	 */
	@Keyword
	def closeAllOpenKatalon(){
		try{
			Runtime.getRuntime().exec("taskkill /IM katalon.exe /F")
		}catch(Exception e){
			KeywordUtil.logInfo("Error when closing")
		}

		KeywordUtil.markPassed("Katalon is closed successfully")
	}

	/**
	 * Execute an existing test suite by KRE
	 * @param filePath location of Batch file to execute Project
	 * @param timeOut time to wait for running completed
	 */
	@Keyword
	def executeScriptByKRE(String filePath, int timeOut){
		try{
			def pathCmd = "cmd /c start ${filePath}"
			KeywordUtil.logInfo("Batch File: ${pathCmd}")
			Runtime rn = Runtime.getRuntime()
			Process pr=rn.exec(pathCmd);
		}catch(Exception e){
			KeywordUtil.markFailedAndStop("Could NOT execute Script by KRE")
		}

		KeywordUtil.logInfo("KRE run successfully, waiting for script run completed in ${timeOut} seconds")
		KeywordUtil.markPassed("Executed scripts via KRE successfully")
	}
}
