"DATA Start PREPARATION"
	organizationName = "Organization#211855"
"DATA End PREPARATION"

"PRECONDITION: Start to prepare new Organization for delete"
	CustomKeywords.'testops.TestOpsLogin.openBrowser'()
	CustomKeywords.'testops.TestOpsLogin.loginSystem'()
	CustomKeywords.'testops.Organization.createNewOrganization'(organizationName)
"PRECONDITION: End to prepare Organization"

"Step#1: Navigate to newly created Organization Management page"
CustomKeywords.'testops.Organization.navigateToOrganizationManagement'(organizationName)

"Step#2: Delete newly created Organization with new Name"
CustomKeywords.'testops.Organization.deleteOrganizationName'(organizationName)

"Step#3: Verify Organization is deleted successfully"
CustomKeywords.'testops.Organization.verifyOrganizationDeletedByObject'(organizationName)


