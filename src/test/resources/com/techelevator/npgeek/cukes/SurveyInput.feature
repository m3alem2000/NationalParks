Feature: SurveyInput Test

Scenario Outline: SurveyResultPage Returns Correctly
	Given I am on the survey input page
	And the park I select is <parkName>
	And the state I select is <state>
	And I input the email address <emailAddress>
	And the activity level I select is <activityLevel>
	When I submit my survey
	Then I will end up on the survey results page
	
	Examples:
	  | parkName                    | state     | emailAddress      | activityLevel |
	  | "Grand Teton National Park" | "Alabama" | "hiker@yahoo.com" | "active"      |