package utilHelper

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.io.FileType

public class IOHelper {
	/**
	 * Get execution report folder of a test suite
	 * 
	 */
	@Keyword
	def getExecutionReportFolder(){
		try{
			def reportFolder = RunConfiguration.getReportFolder()
			KeywordUtil.logInfo("Report folder is: ${reportFolder}")
			KeywordUtil.markPassed("Get report folder successfully: ${reportFolder}")
			return reportFolder
		}catch(Exception e){
			KeywordUtil.markFailedAndStop("Cannot get report folder")
		}
	}

	/**
	 * Get Project folder
	 *
	 */
	@Keyword
	def getProjectFolder(){
		try{
			def projectFolder = RunConfiguration.getProjectDir()
			KeywordUtil.logInfo("Project folder is: ${projectFolder}")
			KeywordUtil.markPassed("Get Project folder successfully: ${projectFolder}")
			return projectFolder
		}catch(Exception e){
			KeywordUtil.markFailedAndStop("Cannot get Project folder")
		}
	}

	/**
	 * Create directory
	 * @param path Folder to create new directory
	 * @param directoryName Name of directory will be created
	 *
	 */
	@Keyword
	def createDirectory(String path = null, String directoryName){
		if(path == null || path ==""){
			path = RunConfiguration.getReportFolder()
		}
		def newDirectoryFolder = path + "\\\\${directoryName}"
		Runtime.getRuntime().exec("cmd /c mkdir ${newDirectoryFolder}")
	}

	/**
	 * Verify report's file created in Report folder
	 * @param filePath location of Report files
	 *
	 */
	@Keyword
	def verifyFilesExist(String filePath){
		def isFound = false
		KeywordUtil.logInfo("Start to verify file exist or not")
		try{
			File file = new File(filePath)
			isFound = file.exists()
		}catch(Exception e){
			KeywordUtil.markFailedAndStop("Cannot find File via path ${filePath}")
		}
		WebUiBuiltInKeywords.verifyEqual(isFound, true, FailureHandling.CONTINUE_ON_FAILURE)
		KeywordUtil.logInfo("End to verify file exist or not, a file found via ${filePath}")
	}

	/**
	 * Create new text file with provided data
	 * @param data the content of file will be created
	 *
	 */
	@Keyword
	def String createFileWithData(String data){
		def projectFolder = RunConfiguration.getProjectDir()
		BufferedWriter writer = null
		File reportFile

		try {
			reportFile = new File(projectFolder + "\\KreReport.txt")
			writer = new BufferedWriter(new FileWriter(reportFile))
			writer.write(data)
		} catch (Exception e) {
			KeywordUtil.markFailedAndStop("Cannot create report file")
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
				KeywordUtil.markFailedAndStop("Cannot create report file")
			}
		}

		KeywordUtil.markPassed("Created File successfully")
		return reportFile.getAbsolutePath()
	}

	/**
	 * Get the location of report run by KRE
	 *
	 */
	@Keyword
	def String getKreReportExecuted(){
		def fileContents
		try{
			def projectFolder = RunConfiguration.getProjectDir()
			fileContents = new File(projectFolder + "\\KreReport.txt").text
		}catch (Exception e){
			KeywordUtil.markFailedAndStop("Cannot read data from file")
		}

		KeywordUtil.markPassed("Completed reading data: ${fileContents}")
		return fileContents.toString()
	}

	def public getAllFileInFolder(String location){
		KeywordUtil.logInfo("Start to get all files in folder ${location}")
		def listFile = []
		try{
			def dirFiles = new File(location)
			dirFiles.eachFileRecurse (FileType.FILES) { file ->
				listFile << file.absolutePath
			}
		}catch(Exception e){
			listFile = []
		}
		KeywordUtil.logInfo("End to get all files in folder ${location}")
		return listFile
	}

	@Keyword
	def verifyTestScriptExist(String location){
		def listFile = this.getAllFileInFolder(location)
		Windows.verifyEqual(listFile.size(), 1, FailureHandling.STOP_ON_FAILURE)
		def filePath = listFile[0].toString()
		def scriptName = filePath.substring(filePath.lastIndexOf("\\") + 1)
		Windows.verifyMatch(scriptName, "Script.*.groovy", true, FailureHandling.STOP_ON_FAILURE)
		KeywordUtil.logInfo("File return: ${listFile[0].toString()}")
		return listFile[0].toString()
	}
}
