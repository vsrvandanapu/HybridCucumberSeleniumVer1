Feature: Create Lead in Salesforce
Scenario: user creates a new lead
Given registered user logged in to salesforce
When user navigate to the leads creation page
And user fill into below details
|firstName				|Atluri  							|
|lastName					|Rakesh  		          |
|companyName			|computech		 			  |
|email						|rakesh@gmail.com	    |
|leadStatus				|Working - Contacted  |
And user click the save button
Then the lead should be created successfully
