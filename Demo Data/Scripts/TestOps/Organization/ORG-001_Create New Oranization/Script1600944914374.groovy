import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

"DATA Start PREPARATION"
organizationName = CustomKeywords.'utilHelper.StringHelper.genergateUniqueString'("Organization")
"DATA End PREPARATION"

"Step#1: Open TestOps Web page"
CustomKeywords.'testops.TestOpsLogin.openBrowser'()

"Step#2: Login To System"
CustomKeywords.'testops.TestOpsLogin.loginSystem'()

"Step#3: Get all Organization before creating new one"
listOrganizationBf = CustomKeywords.'testops.Organization.getAllOrganization'()

"Step#4: Create New Organization"
CustomKeywords.'testops.Organization.createNewOrganization'("Organization#3")

"Step#5: Verify Organization is created successfully"
CustomKeywords.'testops.Organization.verifyOrganizationCreatedByObject'("Organization#3")

"Step#6: Verify Organization is created successfully"
CustomKeywords.'testops.Organization.verifyOrganizationCreated'("Organization#3")

"Step#7: Get all Organization after creating"
listOrganizationAf = CustomKeywords.'testops.Organization.getAllOrganization'()

"Step#8: Verify the total Organization is increased by one"
WebUiBuiltInKeywords.verifyEqual(listOrganizationBf.size()+ 1, listOrganizationAf.size())
