import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

"Step#1: Open TestOps Web page"
CustomKeywords.'testops.TestOpsLogin.openBrowser'()

"Step#2: Login To System"
CustomKeywords.'testops.TestOpsLogin.loginSystem'()

"Step#3: Go to Organization Details Page"
CustomKeywords.'testops.Organization.navigateToOrganizationPage'("Organization loc.nguyen")

"Step#4: Get All Projects displayed in the page"
listProjects = CustomKeywords.'testops.Organization.getAllProjects'()

"Step#5: Verify total Projects is equal to 2"
WebUiBuiltInKeywords.verifyEqual(listProjects.size(), 2)