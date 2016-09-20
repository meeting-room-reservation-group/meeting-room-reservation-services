package com.github.verhagen.mrrs.repository.csv;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.github.verhagen.mrrs.domain.Facility;
import com.github.verhagen.mrrs.domain.Room;

/**
 * Implementation based on <a href="http://csveed.org/">CSVeed</a>. 
 */
public class CsvRoom {
	private String name;
	private String location;
	private int capacity;
	private String facilities;


	public Room createRoom() {
		Set<Facility> facilitiesColl = Collections.emptySet();
		final String facilitiesCln = StringUtils.trimToNull(getFacilities());
		if (facilitiesCln != null) {
			facilitiesColl = new LinkedHashSet<>();
			final String[] facilityArray = facilitiesCln.split(",");
			for (String facilityStr : facilityArray) {
				facilitiesColl.add(new Facility(facilityStr));
			}
		}

		return new Room(getName(), getLocation(), getCapacity(), facilitiesColl);
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getFacilities() {
		return facilities;
	}
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

}
