"DATA Start PREPARATION"
	organizationName = CustomKeywords.'utilHelper.StringHelper.genergateUniqueString'("Organization")
	organizationNameUpdate = "Update ${organizationName}"
"DATA End PREPARATION"


"PRECONDITION: Start to prepare new Organization for update name"
	CustomKeywords.'testops.TestOpsLogin.openBrowser'()
	CustomKeywords.'testops.TestOpsLogin.loginSystem'()
	CustomKeywords.'testops.Organization.createNewOrganization'(organizationName)
"PRECONDITION: End to prepare Organization"

"Step#1: Navigate to newly created Organization Management page"
CustomKeywords.'testops.Organization.navigateToOrganizationManagement'(organizationName)

"Step#2: Update newly created Organization with new Name"
CustomKeywords.'testops.Organization.updateOrganizationName'(organizationNameUpdate)

"Step#3: Verify Organization is updated successfully with new name"
CustomKeywords.'testops.Organization.verifyOrganizationCreatedByObject'(organizationNameUpdate)


