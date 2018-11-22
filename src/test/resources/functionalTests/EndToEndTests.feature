Feature: Automated End to End Tests 
	Description: The purpose of this test feature is to test End 2 End functionalities
	
Background: 
	Given user is on the login page 
	When he enters username and password 
	Then Dashboard page displays 
	
#Scenario Outline: User checks the occuppancy value of the building 
#	When user select "<buildingname>" from Properties list 
#	Then The occupancy value for selected building shows "<occupancyvalue>" 
#	Examples: 
#		|buildingname|occupancyvalue|
#		|The Olsen Hotel|100%|
		
Scenario: user uploads document file 
	Given user navigates to Document Library 
	When user click on Add New Document button 
	Then Add New Document Page opens 
	When user click on Browse button 
	Then upload file window opens 
	When user provide the file path to upload and hit Enter key 
	Then provided file name displayed next to Browse button 

@Hello
Scenario Outline: Document search
	Given user navigates to Document Library 
	When user enter "<Property Name>" in property name Search column
	Then resultatant property record display in the table
Examples:
	|Property Name|
	|Olsen Hotel|