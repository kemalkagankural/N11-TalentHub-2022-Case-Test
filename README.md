# N11 TalentHub 2022 Test Case
:white_check_mark: **N11 TalentHub QA Bootcamp** :white_check_mark:

-  :white_check_mark: 1. Proje - N11 TalentHub Test Case :tada::
  - 1. Step
      - Manuel Test (Excel)<br/>
        Manuel Test Link:https://docs.google.com/spreadsheets/d/1GI0i7GXETw808ePQV3pr6bQTyu7GJUZMQh0JR2i1_go/edit?usp=sharing<br/>
  - 2. Step<br/>
      - Conducting automation of testing the given tests<br/>
      - Preparing Docker Grid<br/>
   &nbsp;
   <br/>
   
# Test Case Description

This repo was created for N11 Web Testing.Within the project, 3 test scenarios were written using Java Selenium and Page Object Model.These scenarios are to print all the stores to the CSV file and go to the page of the second store starting with S from this CSV file and check their comments.Also ın these scenarios are to search a product,add to cart,and go to payment step.Also these scenarios contain the searching filtering.Test scenarios and runners are included under "test/testrunners”.At the same time, Selenium Grid and Docker were used in this project. Selenium Grid is a system that allows testing in different browsers in parallel.

<p align="center" width="100%">
    <img width="100%" alt="Selenium Grid Mimarisi" src="https://miro.medium.com/max/884/1*rpC1U4ZaA4e3m6rL_acpwQ.png"> 
This image  is taken from  the address that "https://medium.com/devopsturkiye/selenium-grid-nedir-d325a19db2bd".  
</p>

Created docker-compose.a selenium grid hub is started with a yaml file and the created tests are run in this environment. The docker-compose file created for this project runs at localhost:4444.

## Requirements Before Installation
- Java
- Maven
- Selenium-java
- Webdrivermanager
- Docker

## Installation Steps

1- The Bash screen opens.
`

2- N11-TalentHub-2022-Case-Test repo is copied to the local device.

`git clone https://github.com/kemalkagankural/N11-TalentHub-2022-Case-Test.git`

3- Then docker compose is executed.

`docker-compose -f docker-compose-v3.yml up `

4- Then the test files are run.

`mvn clean test `

Not: To see what is happening inside the container, head to localhost (password is secret).
