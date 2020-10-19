package katalonstudio

import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable


public class Project {
	def void enterDataToCreateProject(String projectName, String projectType, String projectLocation, String projectDescription){
		KeywordUtil.logInfo("Start enter data for Project creation")
		Windows.waitForElementPresent(findWindowsObject('Object Repository/Katalon/Dialog/New Project/txb_Project Name'), GlobalVariable.G_TimeOut_Short, FailureHandling.OPTIONAL)
		Windows.setText(findWindowsObject('Object Repository/Katalon/Dialog/New Project/txb_Project Name'), projectName, FailureHandling.STOP_ON_FAILURE)

		if(projectLocation != null && projectLocation.trim() == ""){
			Windows.setText(findWindowsObject("Object Repository/Katalon/Dialog/New Project/txb_Project Location"), projectLocation, FailureHandling.STOP_ON_FAILURE)
		}

		Windows.setText(findWindowsObject("Object Repository/Katalon/Dialog/New Project/txb_Project Description"), projectDescription, FailureHandling.STOP_ON_FAILURE)

		switch(projectType.toLowerCase()){
			case "web":
				Windows.click(findWindowsObject('Object Repository/Katalon/Dialog/New Project/rad_Web Project'), FailureHandling.STOP_ON_FAILURE)
				break

			case "webservice":
				Windows.click(findWindowsObject('Object Repository/Katalon/Dialog/New Project/rad_Web Service Project'), FailureHandling.STOP_ON_FAILURE)
				break

			case "mobile":
				Windows.click(findWindowsObject('Object Repository/Katalon/Dialog/New Project/rad_Mobile Project'), FailureHandling.STOP_ON_FAILURE)
				break

			case "generic":
				Windows.click(findWindowsObject('Object Repository/Katalon/Dialog/New Project/rad_Generic Project'), FailureHandling.STOP_ON_FAILURE)
				break
		}
		KeywordUtil.logInfo("Completed enter data for Project creation")
	}

	/**
	 * Create new Project from Start Page
	 * @param filePath location of Batch file to execute Project
	 * @param projectName name of Project will be created
	 * @param projectType type of Project will be created (Web/Windows/Web Service/Generic)
	 * @param projectLocation place to store Project
	 * @param projectDescription description of Project
	 * @param timeOut minor time for delaying when creating
	 */
	@Keyword
	def createNewProjectByTypeFromStartPage(String projectName, String projectType, String projectLocation, String projectDescription, int timeOut){
		KeywordUtil.logInfo("Start to create New Project")
		Windows.waitForElementPresent(findWindowsObject('Object Repository/Katalon/LeftPanel/Test Explorer/btn_New Project'), timeOut, FailureHandling.OPTIONAL)
		Windows.click(findWindowsObject('Object Repository/Katalon/LeftPanel/Test Explorer/btn_New Project'), FailureHandling.STOP_ON_FAILURE)
		this.enterDataToCreateProject(projectName, projectType, projectLocation, projectDescription)
		Windows.click(findWindowsObject('Object Repository/Katalon/Dialog/New Project/btn_OK'), FailureHandling.STOP_ON_FAILURE)
		Windows.delay(timeOut, FailureHandling.OPTIONAL)
		Windows.waitForElementPresent(findWindowsObject('Object Repository/Katalon/Dialog/TestOps Integration/btn_OK'), timeOut, FailureHandling.STOP_ON_FAILURE)
		Windows.click(findWindowsObject('Object Repository/Katalon/Dialog/TestOps Integration/btn_OK'), FailureHandling.OPTIONAL)
		KeywordUtil.logInfo("End creating New Project")
	}

	/**
	 * Close and Clean Existing Project
	 * @param timeOut minor time for delaying while clean and close Project
	 */
	@Keyword
	def closeAndCleanProject(int timeOut = GlobalVariable.G_TimeOut_Short){
		KeywordUtil.logInfo("Start to close and clean up Project")
		Windows.waitForElementPresent(findWindowsObject('Object Repository/Katalon/Menu/Main Menu/mnu_Project'), timeOut, FailureHandling.OPTIONAL)
		Windows.click(findWindowsObject('Object Repository/Katalon/Menu/Main Menu/mnu_Project'), FailureHandling.OPTIONAL)
		Windows.click(findWindowsObject('Object Repository/Katalon/Menu/Sub Menu_Project/mnu_Close and Clean up'), FailureHandling.OPTIONAL)
		KeywordUtil.logInfo("End close and clean up Project")
	}

	def void enterDataToOpenProject(String projectLocation, int timeOut = GlobalVariable.G_TimeOut_Short){
		KeywordUtil.logInfo("Start to enter data to open Project")
		Windows.waitForElementPresent(findWindowsObject('Object Repository/Katalon/Dialog/Browse For Folder/txb_Folder Project'), timeOut, FailureHandling.OPTIONAL)
		Windows.setText(findWindowsObject('Object Repository/Katalon/Dialog/Browse For Folder/txb_Folder Project'), projectLocation, FailureHandling.STOP_ON_FAILURE)
		Windows.click(findWindowsObject('Object Repository/Katalon/Dialog/Browse For Folder/btn_OK'), FailureHandling.STOP_ON_FAILURE)
		KeywordUtil.logInfo("End to enter data to open Project")
	}

	/**
	 * Open an existing Project from Start Screen
	 * @param projectLocation location where Project is stored
	 * @param timeOut minor delaying time while opening Project
	 */
	@Keyword
	def openProjectFromStartScreen(String projectLocation, int timeOut = GlobalVariable.G_TimeOut_Short){
		KeywordUtil.logInfo("Start to open an existing Project")
		Windows.click(findWindowsObject('Object Repository/Katalon/LeftPanel/Test Explorer/btn_Open Project'), FailureHandling.STOP_ON_FAILURE)
		this.enterDataToOpenProject(projectLocation, timeOut)
		KeywordUtil.logInfo("End to open an existing Project")
	}

	/**
	 * Open an existing Project from Start Screen
	 * @param projectLocation location where Project is stored
	 * @param timeOut minor delaying time while opening Project
	 */
	@Keyword
	def openProjectFromMenu(String projectLocation, int timeOut = GlobalVariable.G_TimeOut_Short){
		KeywordUtil.logInfo("Start to open an existing Project")
		Windows.click(findWindowsObject('Object Repository/Katalon/Menu/Main Menu/mnu_File'), FailureHandling.STOP_ON_FAILURE)
		Windows.click(findWindowsObject('Object Repository/Katalon/Menu/Sub Menu_Project/mnu_Open Project'), FailureHandling.STOP_ON_FAILURE)
		this.enterDataToOpenProject(projectLocation, timeOut)
		KeywordUtil.logInfo("End to open an existing Project")
	}

	/**
	 * Verify Project Opened successfully
	 * @param projectName name of Project will be used to verify
	 */
	@Keyword
	def verifyProjectOpened(String projectName){
		KeywordUtil.logInfo("Start to verify Project is opened")
		Windows.waitForElementPresent(findWindowsObject('Object Repository/Katalon/Top Menu Bar/lbl_Project Title'), GlobalVariable.G_TimeOut_Short, FailureHandling.OPTIONAL)
		def currentProject = Windows.getText(findWindowsObject('Object Repository/Katalon/Top Menu Bar/lbl_Project Title'), FailureHandling.STOP_ON_FAILURE)
		Windows.verifyMatch(currentProject, ".*${projectName}.*", true, FailureHandling.CONTINUE_ON_FAILURE)
		KeywordUtil.logInfo("End to verify Project is opened")
	}

	/**
	 * Refresh Project
	 * @param timeOut time to wait object present in the window
	 */
	@Keyword
	def refreshProject(int timeOut = GlobalVariable.G_TimeOut_Short){
		KeywordUtil.logInfo("Start to refresh Project")
		Windows.waitForElementPresent(findWindowsObject('Object Repository/Katalon/Menu/Main Menu/mnu_Project'), timeOut, FailureHandling.OPTIONAL)
		Windows.click(findWindowsObject('Object Repository/Katalon/Menu/Main Menu/mnu_Project'), FailureHandling.OPTIONAL)
		Windows.click(findWindowsObject('Object Repository/Katalon/Menu/Sub Menu_Project/mnu_Refresh'), FailureHandling.OPTIONAL)
		KeywordUtil.logInfo("End to refresh Project")
	}
}
