package utilHelper

import java.text.DateFormat
import java.text.SimpleDateFormat

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil

public class StringHelper {

	/**
	 * Generate an unique string with provided formats
	 * @param prefix start value of String
	 * @param subfix ending value of String
	 * @param format format of String
	 */
	@Keyword
	def genergateUniqueString(String prefix = "", String subfix = "", String format = "yyyyMMddHHmmss"){
		try{
			KeywordUtil.logInfo("Start to generate Unique String start with ${prefix} and apply format ${format}")
			DateFormat dateFormat = new SimpleDateFormat(format)
			Date date = new Date()
			def uniqueString = prefix + dateFormat.format(date) + subfix
			KeywordUtil.logInfo("End to generate unique String: ${uniqueString} is created successfully")
			KeywordUtil.markPassed("${uniqueString} is created successfully")
			return uniqueString
		}catch(Exception e){
			KeywordUtil.markFailed("Cound NOT generate Unique string")
		}
	}
}
