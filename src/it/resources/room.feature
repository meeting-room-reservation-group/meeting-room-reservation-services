Feature: Rooms require a location and capacity. Optional they have a name and facilities.


Scenario: Room is found by location and has no facilities
Given a room with name 'Berlin', location '1.12' and capacity 12 
When searching for room with location '1.12'
Then the room with name 'Berlin' should be returned
  And no facilities 

Scenario: Room is found found by location and has one facility
Given a room with name 'Berlin', location '1.12' and capacity 12 which has facilities 'whiteboard'
When searching for room with location '1.12'
Then the room with name 'Berlin' should be returned
  And has facilities 'whiteboard'

Scenario: Room is found found by location and has multiple facility
Given a room with name 'Berlin', location '1.12' and capacity 12 which has facilities 'whiteboard, computer, flip over'
When searching for room with location '1.12'
Then the room with name 'Berlin' should be returned
  And has facilities 'whiteboard, flip over'
