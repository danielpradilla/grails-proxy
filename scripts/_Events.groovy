/*
Want to see some grails magic?
This increases the build number automatically each time you do a build
Thanks to:
http://www.wthr.us/2010/07/08/adding-an-auto-incrementing-build-number-to-a-grails-application/
*/
eventCompileStart = { kind ->
	def buildNumber = metadata.'app.buildNumber'
 
	if (!buildNumber)
		buildNumber = 1
	else
		buildNumber = Integer.valueOf(buildNumber) + 1
 
	metadata.'app.buildNumber' = buildNumber.toString()
 
	metadata.persist()
 
	println "**** Compile Starting on Build #${buildNumber}"
}
