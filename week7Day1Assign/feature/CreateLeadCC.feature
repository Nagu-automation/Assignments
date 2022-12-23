Feature: Creating and modifying the leads in leaftap application

Scenario Outline: Creating a lead through positive flow
Given Click on 'Leads' tab
And Click on 'Create Lead' tab
And Enter 'companyName' as <cName>
And Enter 'firstName' as <fName>
And Enter 'lastName' as <lName>
When Click on create lead button
Then Verify lead is created

Examples:
|cName|fName|lName|
|'CTS'|'Philip'|'Victor'|
|'TCS'|'Raghav'|'Chandran'|

Scenario Outline: Editing a Lead
Given Click on 'Leads' tab
When Click on 'Find Leads' tab
Then Verify Find by section is displayed
When Click on phone tab
And Enter first two digits of phone number as <areaCode>
And Click on Find Leads button
Then Verify Lead List is displayed
When Click on first instance of the list
Then Verify 'View Lead' page is displayed
When Click on 'Edit' tab
Then Verify 'Edit Lead' page is displayed
When Updating the fields company name as <cName> first Name as <fName> last name as <lName> and click on update button
Then Verify the changes are updated

Examples:
|areaCode|cName|fName|lName|
|'91'|'CGI'|'Rahul'|'Ravi'|
|'1'|'Deloitte'|'Adam'|'Samy'|

Scenario Outline: Duplicating the Lead
Given Click on 'Leads' tab
When Click on 'Find Leads' tab
Then Verify Find by section is displayed
When Enter the company name as <cName>
And Click on Find Leads button
Then Verify Lead List is displayed
When Click on first instance of the list
Then Verify 'View Lead' page is displayed
When Click on 'Duplicate Lead' tab
And Click on create lead button
Then Verify Duplicate lead is created

Examples:
|cName|
|'CTS'|
|'TCS'|
 
Scenario Outline: Duplicating the Lead
Given Click on 'Leads' tab
When Click on 'Find Leads' tab
Then Verify Find by section is displayed
When Enter the first name as <fName>
And Click on Find Leads button
Then Verify Lead List is displayed
When Click on first instance of the list
Then Verify 'View Lead' page is displayed
When Click on 'Delete' tab
And Click on 'Find Leads' tab
And Enter the lead id
And Click on Find Leads button
Then Verify the lead is deleted

Examples:
|fName|
|'Philip'|