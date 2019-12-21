## **SMS SERVICE README** ##

### What has been done? ###
* Created a skeleton web server for registration of a user(UK mobile number can receive a text after registration)
* Created a simple REST service that sends text when a client calls '/registeruser' endpoint(a real world example is any registration service online)
* Created tests for '/registeruser' endpoint


### HOW TO RUN SERVICE LOCALLY ###

### Prerequisites: ###
* Please make sure Maven is installed locally by running this in command line: $ mvn -v
* Set up a Twilio trial account and populate TextMessageConstants.java file with Account Sid, Auth Token and Sender number(service won't work without this! Also please don't make your token public. If you ever do  :) you can create a secondary token in Twilio and then promote it to primary. This way your Twilio account isn't compromised)

### To Run: ###
* Run tests and server in root directory, run this in command line:
    $ mvn clean package jetty:run
This will basically create a target folder and downloads a bunch of dependencies and a war file. Read the pom.xml to learn about what's going on.

Examples of HTTP Calls (Try this using a Postman client)
http://localhost:8080/register/?username=bob&tel=07654321234
-This call sends a text message using the twilio wrapper

### ARCHITECTURE ###
* Based on 'maven-archetype-webapp' maven archetype
* src/main/java : backend code
* src/main/webapp: front end
* src/main/test: test for backend

_____________

### What needs to be done next ###
Deploy service to Azure web app

### APIs ###
GET Request: Registering a new user
http://localhost:8080/registeruser?username=namegoeshere&tel=11digitukmobilenogoeshere

GET Request: Ping service
http://localhost:8080/test

GET Request: Get status of service
http://localhost:8080/status


