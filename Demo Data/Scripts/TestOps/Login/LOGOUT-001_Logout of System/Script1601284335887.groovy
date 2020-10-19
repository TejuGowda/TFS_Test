"Open TestOps Web page"
CustomKeywords.'testops.TestOpsLogin.openBrowser'()

"Precondition: One User Log into System"
CustomKeywords.'testops.TestOpsLogin.loginSystem'()

"Make sure User Log into System successfully"
CustomKeywords.'testops.TestOpsLogin.verifyLoginSuccessfully'()

"Log out of System"
CustomKeywords.'testops.TestOpsLogin.logOutSystem'()

"Verify User Log out System successfully"
CustomKeywords.'testops.TestOpsLogin.verifyLogOutSuccessfully'()