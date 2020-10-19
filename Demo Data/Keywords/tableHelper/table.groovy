package tableHelper

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

public class table {
	def static int identifyColumnHeaderByLabel(columnHeader, label) {
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

	def static int identifyRowIndexByValue(columnIndex, value, label){
		def userInforObj = ObjectRepository.findTestObject("Object Repository/TestOps/Organization/Center Panel/Manage Users/tbl_UserInfo", ["areaName":label])
		try{
			WebElement userInfoTbl = WebUiBuiltInKeywords.findWebElement(userInforObj)
			List<WebElement> listColumnData = userInfoTbl.findElements(By.xpath(".//td[${columnIndex}]"))

			for(int i=0; i<listColumnData.size(); i++ ){
				def currentValue = listColumnData[i].getText().trim()
				KeywordUtil.logInfo("Current value is ${currentValue}")
				if(currentValue == value.toLowerCase()){
					KeywordUtil.markPassed("Not Found ${value} at column ${columnIndex}")
					return i
				}
			}
		}catch(Exception e){
			KeywordUtil.markFailedAndStop("Not Found ${value} at column ${columnIndex}")
			return -1
		}
	}
}
