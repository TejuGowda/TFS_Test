"DATA Start PREPARATION"
organizationName = "Organization loc.nguyen"
userEmail = CustomKeywords.'utilHelper.StringHelper.genergateUniqueString'("uniqueemail", "@gmail.com")
tableLabel = "Pending Invitations"
"DATA End PREPARATION"

"Step#1: Open TestOps Web page"
CustomKeywords.'testops.TestOpsLogin.openBrowser'()

"Step#2: Login To System"
CustomKeywords.'testops.TestOpsLogin.loginSystem'()

"Step#3: Navigate to Users Management page"
CustomKeywords.'testops.Organization.navigateToUsersManagement'(organizationName)

"Step#4: Invite User to the Organization"
CustomKeywords.'testops.Organization.inviteUser'(userEmail)

"Step#5: Verify User added to 'Pending Invitation' list"
"Start Verification"
	 "Identify Email Column Index"
	 index = CustomKeywords.'tableHelper.Organization.identifyColumnHeaderByLabel'("Email", tableLabel)
	 "Verify invited Email displayed in the list"
	 CustomKeywords.'tableHelper.Organization.verifyColumnValue'(index, userEmail, tableLabel)
"End Verification"


