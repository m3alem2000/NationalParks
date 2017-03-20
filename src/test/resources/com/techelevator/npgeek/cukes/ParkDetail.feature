Feature: ParkDetailPage Test

Scenario Outline: Return Correct ParkDetailPage
	Given I am on the NPGeek home page
	When I click the link with the id of <parkCode>
	Then on the ParkDetail page the year founded should be <yearFounded>
	And the park name should be <parkName>
	And the state should be <state>
	And the miles of trail should be <milesOfTrail>
	And the acreage should be <acreage>
	And the elevation should be <elevation>
	And the climate should be <climate>
	And the number of animals should be <numberOfAnimals>
	And the annual visitors should be <annualVisitors>
	And the number of campsites should be <numberOfCampsites>
	
	Examples:
	  | parkCode | yearFounded | parkName | state | milesOfTrail | acreage | elevation | climate | numberOfAnimals | annualVisitors | numberOfCampsites |
	  | "CVNP"   | "2000" | "Cuyahoga Valley National Park" | "Ohio" | "125.0" | "32832" | "696" | "Woodland" | "390" | "2189849" | "0" |