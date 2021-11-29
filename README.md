# Hackathon2021_AgentTracker

## Get Started
This is the Github Repo for the Agent Tracker project in Compass Hackathon 2021.
To execute the code:
1. clone and unzip the repo
2. in shell, run: `mvn spring-boot:run`
3. In a web browser, test the APIs: `http://localhost:8080/checkAgentByEmail?email=testEmail` and `http://localhost:8080/checkFeature?feature=testFeature`

Demo:

<img src="https://user-images.githubusercontent.com/79475998/142057438-dfe947a8-b858-461f-8443-6bf7fe892218.png" alt="drawing" width="400"/>

## Helper Functions
1. The above API is just a demo function to return the dummy data.
2. To retrieve the real data, the functions to call the real APIs are stored under: `src/main/java/com/example/demo/helpers/DataRetriver.java`  
3. The test has also been created to demo the usage of the functions: `src/test/java/com/example/demo/MainTest.java`
4. To access optimizely APIs, A valid optimizely token has already been included, but it is recommended to generate your own. 