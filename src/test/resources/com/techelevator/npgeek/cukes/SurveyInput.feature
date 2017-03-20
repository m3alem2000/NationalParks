Feature: SurveyInput Test

Scenario: SurveyInput Submit Returns SurveyResultsPage
Given I am on the survey input page
And the park I select is Grand Teton National Park
And the state I select is Alabama
And I input the email address hiker@yahoo.com
And the activity level I select is Active
When I submit my survey
Then I will end up on the survey results page

Scenario Outline: SurveyResultsPage Returns Correctly
	Given I am on the survey input page
	And the park I select is <parkName>
	And the state I select is <state>
	And I input the email address <emailAddress>
	And the activity level I select is <activityLevel>
	When I submit my survey
	Then I will end up on the survey results page
	
	Examples:
	  | parkName | state | emailAddress | activityLevel |
	  | Grand Teton National Park | Alabama | hiker@yahoo.com | Active |
	  | Yosemite National Park | Washington | bigdog@redshift.net | Sedentary |
	  | Yellowstone National Park | Ohio | bigdog@redshift.net | Sedentary |