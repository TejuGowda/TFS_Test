package testops

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable


public class Organization {
	WebDriver myDriver

	public Organization(){
		myDriver = DriverFactory.getWebDriver()
	}

	/**
	 * Create New Organization
	 * @param organizationName organization's Name will be created
	 */
	@Keyword
	def createNewOrganization(String organizationName =null){
		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Top Navigation Bar/ico_HomeApplication"), FailureHandling.STOP_ON_FAILURE)
		WebUiBuiltInKeywords.waitForElementClickable(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Left Panel/lnk_Create Organization"), GlobalVariable.G_TimeOut, FailureHandling.STOP_ON_FAILURE)
		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Left Panel/lnk_Create Organization"), FailureHandling.STOP_ON_FAILURE)

		if(organizationName!=null){
			WebUiBuiltInKeywords.setText(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Right Panel/Organiation Creation Page/txb_Organization Name"), organizationName, FailureHandling.STOP_ON_FAILURE)
		}
		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Right Panel/Organiation Creation Page/btn_Create"), FailureHandling.STOP_ON_FAILURE)
	}

	/**
	 * Verify Organization Created successfully
	 * @param organizationName organization's Name will be used to verify
	 */
	@Keyword
	def verifyOrganizationCreated(String organizationName){
		boolean isFound = false
		def listOrganization = myDriver.findElements(By.className("nav-item-label"))
		for(WebElement el in listOrganization){
			def currOrganizationName = el.getText()
			KeywordUtil.logInfo("Found Organization:${currOrganizationName}")
			if(el.getText() == organizationName){
				isFound = true
				break
			}
		}

		if(isFound){
			KeywordUtil.markPassed("Found Organization with name:${organizationName}")
		}else{
			KeywordUtil.markFailed("Cannot Find Organization with name:${organizationName}")
		}
	}

	/**
	 * Get Organization's name in the left panel
	 * Return List Organization
	 */
	@Keyword
	def getAllOrganization(){
		def listOrganization = []
		def listOrganizationElements = myDriver.findElements(By.className("nav-item-label"))
		for(WebElement el in listOrganizationElements){
			def strOrganizationName = el.getText()
			KeywordUtil.logInfo("Found Organization:${strOrganizationName}")
			if(strOrganizationName !=null || strOrganizationName!=""){
				listOrganization << strOrganizationName
			}
		}
		KeywordUtil.logInfo("Number of Organization Found:${listOrganization.size()}")
		return listOrganization
	}

	/**
	 * Navigate to Organization's Details page
	 * @param organizationName organization's Name
	 */
	@Keyword
	def navigateToOrganizationPage(String organizationName){
		def objOrganization = ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Left Panel/lnk_Organization Name", ["organizationName":organizationName])
		WebUiBuiltInKeywords.click(objOrganization, FailureHandling.STOP_ON_FAILURE)
	}

	/**
	 * Verify newly Organization is created successfully
	 * @param organizationName organization's Name will be used to verify
	 */
	@Keyword
	def verifyOrganizationCreatedByObject(String organizationName){
		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Top Navigation Bar/ico_HomeApplication"), FailureHandling.STOP_ON_FAILURE)
		def objOrganization = ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Left Panel/lnk_Organization Name", ["organizationName":organizationName])
		WebUiBuiltInKeywords.verifyElementPresent(objOrganization, GlobalVariable.G_TimeOut, FailureHandling.STOP_ON_FAILURE)
	}

	/**
	 * Verify default selected Project of an Organization
	 * @param projectName Project's name
	 */
	@Keyword
	def verifySelectedProject(String projectName){
		def currentProject = WebUiBuiltInKeywords.getText(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Top Navigation Bar/lbl_Selected Project"), FailureHandling.STOP_ON_FAILURE)
		WebUiBuiltInKeywords.verifyEqual(currentProject, projectName, FailureHandling.STOP_ON_FAILURE)
	}

	/**
	 * Verify Welcome message of an Organization
	 * @param organizationName organization's Name
	 */
	@Keyword
	def verifyWelComeOrganization(String organizationName){
		def currentOrganization = WebUiBuiltInKeywords.getText(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Top Navigation Bar/lbl_Welcome Organization"), FailureHandling.STOP_ON_FAILURE)
		WebUiBuiltInKeywords.verifyEqual(currentOrganization, organizationName, FailureHandling.STOP_ON_FAILURE)
	}

	/**
	 * Go to List Projects of an Organization
	 */
	@Keyword
	def listAllProjects(){
		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Right Panel/View Projects/lnk_View All Projects"), FailureHandling.STOP_ON_FAILURE)
	}

	/**
	 * Go to recent Project of an Organization by its name
	 * @param projectName Project's name
	 */
	@Keyword
	def goToRecentProjectDetailsByName(String projectName){
		def lnkRecentProject = ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Center Panel/lnk_Recent Project", ["projectName":projectName])
		WebUiBuiltInKeywords.click(lnkRecentProject, FailureHandling.STOP_ON_FAILURE)
	}

	/**
	 * Get all Projects of an Organization
	 */
	@Keyword
	def getAllProjects(){
		def listProjects = []
		def listProjectsElements = myDriver.findElements(By.className("project-header"))
		KeywordUtil.logInfo("Found total Project Element:${listProjectsElements.size()}")

		for(WebElement el in listProjectsElements){
			def strProjectName = el.getAttribute("innerText")
			KeywordUtil.logInfo("Found Project:${strProjectName}")
			if(strProjectName !=null || strProjectName!=""){
				listProjects << strProjectName
			}
		}
		KeywordUtil.logInfo("Found total Project:${listProjects.size()}")
		return listProjects
	}

	/**
	 * Update Organization with new Name
	 * @param organizationName Organization's name
	 */
	@Keyword
	def updateOrganizationName(String organizationName){
		KeywordUtil.logInfo("Start Update new Name for Organization")

		if(organizationName !=null){
			WebUiBuiltInKeywords.setText(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Center Panel/Organization Setting/txb_Organization Name"), organizationName, FailureHandling.STOP_ON_FAILURE)
		}
		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Center Panel/Organization Setting/btn_Update", ["cardHeader":"Organization profile"]), FailureHandling.STOP_ON_FAILURE)
		KeywordUtil.logInfo("End Update new Name for Organization")
	}

	/**
	 * Navigate to Organization Management page
	 * @param organizationName Organization's name
	 */
	@Keyword
	def navigateToOrganizationManagement(String organizationName){
		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Top Navigation Bar/ico_HomeApplication"), FailureHandling.STOP_ON_FAILURE)
		WebUiBuiltInKeywords.waitForElementClickable(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Left Panel/lnk_Create Organization"), GlobalVariable.G_TimeOut, FailureHandling.STOP_ON_FAILURE)

		def objOrganization = ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Left Panel/lnk_Organization Name", ["organizationName":organizationName])
		WebUiBuiltInKeywords.click(objOrganization, FailureHandling.STOP_ON_FAILURE)

		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Top Navigation Bar/Settings/btn_Setting"), FailureHandling.STOP_ON_FAILURE)
		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Top Navigation Bar/Settings/lnk_Organization Management"), FailureHandling.STOP_ON_FAILURE)
	}

	/**
	 * Delete an existing Organization
	 * @param organizationName Organization's name
	 */
	@Keyword
	def deleteOrganizationName(String organizationName){
		KeywordUtil.logInfo("Start Delete an Organization")
		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Center Panel/Organization Setting/btn_Delete Organization", ["cardHeader":"Danger zone"]), FailureHandling.STOP_ON_FAILURE)
		WebUiBuiltInKeywords.setText(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Center Panel/Organization Setting/Delete Organization/txb_Organization Name"), organizationName, FailureHandling.STOP_ON_FAILURE)
		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Center Panel/Organization Setting/Delete Organization/btn_Delete Confirm"), FailureHandling.STOP_ON_FAILURE)
		KeywordUtil.logInfo("End Delete an Organization")
	}

	/**
	 * Verify newly Organization is NOT present in the list
	 * @param organizationName Organization's name
	 */
	@Keyword
	def verifyOrganizationDeletedByObject(String organizationName){
		def objOrganization = ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Left Panel/lnk_Organization Name", ["organizationName":organizationName])
		WebUiBuiltInKeywords.verifyElementNotPresent(objOrganization, GlobalVariable.G_TimeOut, FailureHandling.STOP_ON_FAILURE)
	}

	/**
	 * Navigate to User Management page by Organization's name
	 * @param organizationName Organization's name
	 */
	@Keyword
	def navigateToUsersManagement(String organizationName){
		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Top Navigation Bar/ico_HomeApplication"), FailureHandling.STOP_ON_FAILURE)
		WebUiBuiltInKeywords.waitForElementClickable(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Left Panel/lnk_Create Organization"), GlobalVariable.G_TimeOut, FailureHandling.STOP_ON_FAILURE)

		def objOrganization = ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Left Panel/lnk_Organization Name", ["organizationName":organizationName])
		WebUiBuiltInKeywords.click(objOrganization, FailureHandling.STOP_ON_FAILURE)

		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Top Navigation Bar/Settings/btn_Setting"), FailureHandling.STOP_ON_FAILURE)
		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Top Navigation Bar/Settings/lnk_Organization Users Manage"), FailureHandling.STOP_ON_FAILURE)
	}

	/**
	 * Invite User to Organization
	 * @param userEmail Email of user will be invited
	 */
	@Keyword
	def inviteUser(String userEmail){
		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Center Panel/Manage Users/btn_Invite User"), FailureHandling.STOP_ON_FAILURE)
		WebUiBuiltInKeywords.setText(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Center Panel/Manage Users/Invite User/txb_Emails"), userEmail, FailureHandling.STOP_ON_FAILURE)
		WebUiBuiltInKeywords.sendKeys(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Center Panel/Manage Users/Invite User/txb_Emails"), Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)
		WebUiBuiltInKeywords.click(ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Center Panel/Manage Users/Invite User/btn_Invite"), FailureHandling.STOP_ON_FAILURE)
	}
}
