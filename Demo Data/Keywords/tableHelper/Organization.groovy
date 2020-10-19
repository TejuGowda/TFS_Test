package tableHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil


public class Organization {
	/**
	 * Identify index of Column in the table by its header
	 * @param columnHeader column's name
	 * @param label name of table
	 */
	@Keyword
	def int identifyColumnHeaderByLabel(columnHeader, label) {
		int index = -1
		def userInforObj = ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Center Panel/Manage Users/tbl_UserInfo", ["areaName":label])

		try{
			WebElement userInfoTbl = WebUiBuiltInKeywords.findWebElement(userInforObj)
			List<WebElement> listHeader = userInfoTbl.findElements(By.xpath(".//th"))
			for(int i = 0; i<listHeader.size(); i++){
				if(listHeader[i].getText() == columnHeader){
					index = i+1
					break
				}
			}
		}catch(Exception e){
			KeywordUtil.markFailedAndStop("Not Found column ${columnHeader} in the table ${label}")
		}

		if(index > 0){
			KeywordUtil.markPassed("Found column ${columnHeader} in the table ${label}")
			return index
		}else{
			KeywordUtil.markFailedAndStop("Not Found column ${columnHeader} in the table ${label}")
			return -1
		}
	}

	/**
	 * Verify value existed in a column of table
	 * @param columnIndex index of column will be used to verify
	 * @param label name of table
	 */
	@Keyword
	def verifyColumnValue(columnIndex, value, label){
		boolean isFound = false
		def userInforObj = ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Center Panel/Manage Users/tbl_UserInfo", ["areaName":label])

		try{
			WebElement userInfoTbl = WebUiBuiltInKeywords.findWebElement(userInforObj)
			List<WebElement> listColumnData = userInfoTbl.findElements(By.xpath(".//td[${columnIndex}]"))

			for(WebElement el in listColumnData){
				def currentValue = el.getText().trim()
				KeywordUtil.logInfo("Current value is ${currentValue}")
				if(currentValue == value.toLowerCase()){
					isFound = true
					KeywordUtil.logInfo("Found ${value} at column ${columnIndex}")
					break
				}
			}
		}catch(Exception e){
			KeywordUtil.markFailedAndStop("Not Found ${value} at column ${columnIndex}")
		}

		if(isFound){
			KeywordUtil.markPassed("Found ${value} at column ${columnIndex}")
		}else{
			KeywordUtil.markFailed("Not Found ${value} at column ${columnIndex}")
		}
	}
}
