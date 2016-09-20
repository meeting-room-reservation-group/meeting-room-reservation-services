Feature: Rooms require a location and capacity. Optional they have a name and facilities.


Scenario: Room is found by location and has no facilities
Given a room with name 'Berlin', location '1.12' and capacity 12 
When searching for room with location '1.12'
Then the room with name 'Berlin' should be returned
  And no facilities 

Scenario Outline: Room is found found by location and has one facility
#Given a room with name '<name>', location '1.12' and capacity 10 which has facilities 'whiteboard'
#And a room with name '<name>', location '1.14' and capacity 12 which has facilities 'whiteboard, computer'
Given a room with name '<name>', location '<location>' and capacity <capacity> which has facilities '<facilities>'
When searching for room with location '<location>'
Then the room with name '<name>' should be returned
  #And should have capacity <capacity>
  And has facilities 'whiteboard, flip over'
Examples:
	| location | name   | capacity | facilities           |
	| 1.12     | Berlin | 12       | whiteboard           |
	| 1.14     | London | 10       | whiteboard, computer |


Scenario: Room is found found by location and has multiple facility
Given a room with name 'Berlin', location '1.12' and capacity 12 which has facilities 'whiteboard, computer, flip over'
When searching for room with location '1.12'
Then the room with name 'Berlin' should be returned
  And has facilities 'whiteboard, flip over'

