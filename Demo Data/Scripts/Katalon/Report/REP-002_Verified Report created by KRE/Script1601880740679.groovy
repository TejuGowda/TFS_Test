import internal.GlobalVariable

"Get report folder"
reportFolder = CustomKeywords.'utilHelper.IOHelper.getKreReportExecuted'().toString()
"Get name of report has been created"
reportFileName = reportFolder.substring(reportFolder.lastIndexOf("\\") + 1)

"Step#1: Verify HTML report is created under Report folder"
CustomKeywords.'utilHelper.IOHelper.verifyFilesExist'(reportFolder + "\\" + reportFileName + ".html")
"Step#2: Verify PDF report is created under Report folder"
CustomKeywords.'utilHelper.IOHelper.verifyFilesExist'(reportFolder + "\\" + reportFileName + ".pdf")
"Step#3: Verify CSV report is created under Report folder"
CustomKeywords.'utilHelper.IOHelper.verifyFilesExist'(reportFolder + "\\" + reportFileName + ".csv")