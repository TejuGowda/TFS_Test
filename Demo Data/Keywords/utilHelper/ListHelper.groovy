package utilHelper

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil

public class ListHelper {
	/**
	 * Verify an item with type String exist in a list or not
	 * @param listItem collection of items will be verified
	 * @param itemName name of item will be verified (exist in the list or not)
	 *
	 */
	@Keyword
	def boolean isStringItemExist(listItem, itemName){
		for(String item in listItem){
			if(item == itemName){
				KeywordUtil.markPassed("Found item with name ${itemName} in the List")
				return true
				break
			}else{
				KeywordUtil.markFailed("Cound NOT item with name ${itemName} in the List")
				return false
			}
		}
	}
}
