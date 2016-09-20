package com.github.verhagen.mrrs.it.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.github.verhagen.mrrs.domain.Facility;
import com.github.verhagen.mrrs.domain.Room;
import com.github.verhagen.mrrs.repository.RoomRepository;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RoomSteps {
	private RoomRepository roomRepo = new RoomRepository();
	private Room currentRoom;


	@Given("^a room with name '(.*?)', location '(.*?)' and capacity (\\d+)$")
	public void a_room_with_name_location_and_capacity(final String name, final String location, final int capacity) throws Throwable {
		a_room_with_name_location_and_capacity_which_has_facilities(name, location, capacity, null);
	}
	@Given("^a room with name '(.*?)', location '(.*?)' and capacity (\\d+) which has facilities '(.*?)'$")
	public void a_room_with_name_location_and_capacity_which_has_facilities(final String name, final String location,
			final int capacity, final String facilities) throws Throwable {
		
	    roomRepo.add(new Room(name, location, capacity, createFacilities(facilities)));
	}

	@When("^searching for room with location '(.*?)'$")
	public void searching_for_room_with_location(final String location) throws Throwable {
	    currentRoom = roomRepo.getByLocation(location);
	}

	@Then("^the room with name '(.*?)' should be returned$")
	public void the_room_with_name_should_be_returned(final String name) throws Throwable {
	    assertEquals(name, currentRoom.getName());
	}

	@Then("^no facilities$")
	public void no_facilities() throws Throwable {
	    assertTrue(currentRoom.getFacilities().isEmpty());
	}

	@Then("^has facilities '(.*?)'$")
	public void has_facilities(final String facilitiesStr) throws Throwable {
	    Set<Facility> facilities = createFacilities(facilitiesStr);
	    currentRoom.getFacilities().containsAll(facilities);
	}

	// Helper methods

	private Set<Facility> createFacilities(final String facilitiesStr) {
		final String facilitiesCln = StringUtils.trimToNull(facilitiesStr);
		if (facilitiesCln == null) {
			return Collections.emptySet();
		}

		final Set<Facility> facilities = new LinkedHashSet<>();
		for (String name : facilitiesCln.split(",")) {
			facilities.add(new Facility(name));
		}
		return facilities;
	}

}
