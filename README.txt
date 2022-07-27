Assignment:
{ 
WebAPI Developer 
A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
 
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
 
Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.
•         Solve using Spring Boot
•         Create a RESTful endpoint
•         Make up a data set to best demonstrate your solution
•         Check solution into GitHub
}

A Java Spring Boot MVC Project was created on Eclipse IDE.

  1. It's a Plain Java 11 application -- structure & file names are all self-explanatory
  
  2. Dataset - a plain input.txt in the root of application - please use this comma delimited format:
07-20-2022, John, 120.00 
07-20-2022, Tom, 40.00  
05-21-2022, Tom, 66.00
06-21-2022, John, 166.00
07-21-2022, John, 50.00
07-31-2022, John, 150.00
07-11-2022, John, 555.00
  
  3. pushed to github 
     gitHub: https://github.com/zhu7charlie/WebAPI (https://github.com/zhu7charlie/WebAPI.git)

  4. can clone/pull to your local and run it on IDE
     (1). download this project to your PC.
     (2). import it to your Java IDE
     (3). on IDE, Run as Java application - thus the built-in Tomcat server is up running.
     (4). open a web browser -> http://localhost:8080/index.html
          three links show up, click them
    		Hello World -> just show a test message
			Get all Purchases -> shows json objects of Purchases Records
			Reward Points of Purchases -> show Reward Points
			
outputs on HTML page:
{
Purchase Points Summary:

Customer Tom
Month-Year: 6_2022 --- 0
Month-Year: 4_2022 --- 16
Total: --- 16

Customer John
Month-Year: 6_2022 --- 960
Month-Year: 5_2022 --- 182
Total: --- 1142
}


NOTE: 
1. jUnit & Cucumber ComponentTest were NOT implemented
2. code may not that clean and optimized as time constraints
3. any question, please contact me

Thanks,
Changhai Zhu