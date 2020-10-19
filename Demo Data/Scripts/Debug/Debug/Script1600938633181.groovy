//FileWriter fw = null;
//BufferedWriter bw = null;
//PrintWriter out = null;
//
//try {
//    fw = new FileWriter("D:\\LocNguyen\\Sample Project\\Project for KRE Execution\\Scripts\\TC Name20201007090527\\Script1602036533379.groovy", true);
//    bw = new BufferedWriter(fw);
//    out = new PrintWriter(bw);
//    out.println("the text h");
//    out.close();
//} catch (IOException e) {
//    //exception handling left as an exercise for the reader
//}

def runningProjectLocation = CustomKeywords.'utilHelper.IOHelper.getProjectFolder'()
projectLocation =  runningProjectLocation.split("KatalonTestOps")[0] + "Sample Project/Project for KRE Execution"

println projectLocation

"Step#8: Verify .script file is created successfully "
 testScriptPath = CustomKeywords.'utilHelper.IOHelper.verifyTestScriptExist'(projectLocation + "/Scripts/" + "TC Name20201007165845")
 
 //testScriptPath = CustomKeywords.'katalonstudio.TestCase.verifyTestScriptExist'(projectLocation + "/Scripts/" + "TC Name20201007165845")
 
 println testScriptPath
 
 CustomKeywords.'katalonstudio.TestCase.enterTestScriptSteps'(testScriptPath, "loc")
