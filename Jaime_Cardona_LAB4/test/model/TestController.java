package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestController {

	private Controller controller;

	private void setUpEscenario1() {
		controller = new Controller();
		controller.addAttendee(1, "Jaime", "Cardona", "j@hotmail.com", "Masculino", "Colombia", "21/07/1999");
		controller.addAttendee(2, "Armando", "Paredes", "armando@hotmail.com", "Masculino", "Argentina", "14/10/1979");
		controller.addAttendee(0, "Maria", "Hurtado", "mh@hotmail.com", "Femenino", "Brazil", "16/10/1999");
	}
	
	private void setUpEscenario2() {
		controller = new Controller();
	}

	@Test
	void testAddAttendee() {
		setUpEscenario1();
		assertTrue(controller.getRoot().getId() == 1);
		assertTrue(controller.getRoot().getRigth().getId() == 2);
		assertTrue(controller.getRoot().getLeft().getId() == 0);
	}
	@Test
	void testSearchAttendee() {
		setUpEscenario1();
		assertTrue(controller.searchAttendee(1).equals("The Attendee was found \n"+controller.getRoot().toString()+"\n"));
		assertTrue(controller.searchAttendee(4).equals("It was not found"));
		setUpEscenario2();
		assertTrue(controller.searchAttendee(56).equals("Empty tree"));
	}
	@Test
	void testPrintTreeSameCountry() {
		setUpEscenario1();
		assertTrue(controller.printAttendee(controller.getRoot(), 0, "Colombia").equals(controller.getRoot().toString() + " (" + 0 + ") - "));
		setUpEscenario2();
		assertTrue(controller.printAttendee(controller.getRoot(), 0, "Alemania").equals(""));
	}
	
}
