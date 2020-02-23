package com.example.tareas;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Tarea7ApplicationTests {

	@Test
	void contextLoads() {
		assertEquals("No songs added", LinkedList.listSongs());
		assertEquals("Song does not exist", LinkedList.playNow("First"));
		assertEquals("Added Successfully", LinkedList.addSong("First"));
		assertEquals("Playing: First", LinkedList.playNow("First"));
		assertEquals("No more songs", LinkedList.playNext());
		assertEquals("No more songs", LinkedList.playPrev());
		assertEquals("Added Successfully", LinkedList.addSong("Second"));
		assertEquals("Added Successfully", LinkedList.addSong("Third"));
		assertEquals("Playing: Second", LinkedList.playNow("Second"));
		assertEquals("Playing: Third", LinkedList.playNext());
		assertEquals("Playing: Second", LinkedList.playPrev());
		assertEquals("Playing: First", LinkedList.playPrev());
		assertEquals("First<br>Second<br>Third<br>", LinkedList.listSongs());
	}

}
