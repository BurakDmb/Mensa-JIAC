
Mensa-JIAC, An Simple Project For Providing JIAC Programming Examples
====================

This is an example project to get started with the JIAC(Java-Based Intelligent Agent Componentware), which is a framework for developing multi-agent systems(MAS) and services.
It was developed in DAI-Labor, Technische Universitat Berlin.(http://www.jiac.de/agent-frameworks/jiac-v/)

In this project, we are simply building a multi agent system to show todays menu for Mensa Skyline, TU Berlin.(One of the student cafeterias in TU Berlin)

We are using JIAC to make one agent to provide web services to other agents while the other one provides the cafeteria information to the others.

With this setup, we will practice the basic Node, Agent, Bean and Action concepts of the JIAC programming.

This project has been created with the help of the JIAC manual.(http://jiac.de/Downloads/jiac/jiac_manual.pdf)

Mensa-JIAC Program Execution Steps:
--------------------------------

1. Install Java, Maven if not already installed.
2. Fork the repo or download and unzip the archive into a directory.
3. Change directory into the Mensa-JIAC folder. Inside the folder, you will see src directory and a pom.xml file.
4. Run this command in terminal to build and execute the program: `mvn clean install && sh target/appassembler/bin/startMensaService`
5. After that, you can access the web server in http://localhost:4567/

Mensa-JIAC Program Screenshot:
--------------------------------
![Program_Screenshot](https://user-images.githubusercontent.com/15220477/57467208-66f29680-7282-11e9-9026-aafbed7884f4.png)

Berlin StudierendenWerk page screenshot(The page where the menu information is being fetched, https://www.stw.berlin/mensen.html):
--------------------------------
![STW_Berlin_Screenshot](https://user-images.githubusercontent.com/15220477/57467229-6fe36800-7282-11e9-97ab-55780591b5eb.png)
