package com.github.verhagen.mrrs.repository.csv;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Test;

import com.github.verhagen.mrrs.repository.RoomRepository;

public class CsvRoomRepositoryTest {

	@Test
	public void importByReader() throws Exception {
		RoomRepository roomRepo = CsvRoomRepository.importBy(createReader());

		assertEquals("A02", roomRepo.getByLocation("A02").getName());
		assertEquals("A02, 6", roomRepo.getByLocation("A02").toString());

		assertEquals("Amsterdam", roomRepo.getByLocation("B22").getName());
		assertEquals("Amsterdam, B22, 10, [ white board ]", roomRepo.getByLocation("B22").toString());

		assertEquals("Berlin", roomRepo.getByLocation("B24").getName());
		assertEquals("Berlin, B24, 16, [ large screen, white board ]", roomRepo.getByLocation("B24").toString());
	}

	@Test
	public void importByReaderFromFile() throws Exception {
		File pathTestResources = new File("src/test/resources");
		File file = new File(pathTestResources, "room.csv");
		RoomRepository roomRepo = CsvRoomRepository.importBy(new FileReader(file));

		assertEquals("London", roomRepo.getByLocation("C20").getName());
		assertEquals("London, C20, 50, [ 2 beamers, stage ]", roomRepo.getByLocation("C20").toString());

		assertEquals("Paris", roomRepo.getByLocation("C40").getName());
		assertEquals("Paris, C40, 800, [ 2 large screens, white board ]", roomRepo.getByLocation("C40").toString());
	}


	private Reader createReader() {
		final StringBuilder bldr = new StringBuilder();
		bldr.append("name; location; capacity; facilities\n");
		bldr.append("; A02; 6;\n");
		bldr.append("Amsterdam; B22; 10; white board\n");
		bldr.append("Berlin; B24; 16; large screen, white board\n");
		return new StringReader(bldr.toString());
	}

}
