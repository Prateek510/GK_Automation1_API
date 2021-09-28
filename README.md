# GK_Automation1_API
Tools-> Selenium, Maven with given, when and then format.
The tests are firstly run on the Postman tool and then have been automated using Intellij. I could not automate it on Postman because I worked on the client Laptop and the postman tool which is installed on my system is company specific.
The framework used is testNG framework. The testNG file is being configured in the POM.xml file in order to run it with the command mvn clean install.
Get operations have been performed on the openweather api using different query parameters.
For parameterization, the Dataprovider class of testNG is being used which returns the two dimensional array and can be called with the given name.
Negative scenarios are created wherein I am providing the invalid city namd or id.
The relevant json response file is being uploaded in the repository.
Proper assertions are being used for validating the expected data in the Json response file.
