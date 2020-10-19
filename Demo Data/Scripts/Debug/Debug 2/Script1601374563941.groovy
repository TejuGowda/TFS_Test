import com.kms.katalon.core.model.FailureHandling
import com.thoughtworks.selenium.webdriven.Windows
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import utilHelper.IOHelper

//def list = []
//def dir = new File("D:\\LocNguyen\\KatalonTestOps\\Demo Data\\Scripts\\Katalon\\Test Case\\TCE-001_Create New Blank Test Case")
//dir.eachFileRecurse (FileType.FILES) { file ->
//  list << file.absolutePath
//}
//
//println list

IOHelper helper = new IOHelper()
listFile = helper.getAllFileInFolder("D:\\LocNguyen\\KatalonTestOps\\Demo Data\\Scripts\\Katalon\\Test Case")
Windows.verifyEqual(listFile.size(), 1, FailureHandling.STOP_ON_FAILURE)
def filePath = listFile[0].toString()
def scriptName = filePath.substring(filePath.lastIndexOf("\\") + 1)
Windows.verifyMatch(scriptName, "Script.*.groovy", true, FailureHandling.CONTINUE_ON_FAILURE)