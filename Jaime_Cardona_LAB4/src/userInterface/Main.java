package userInterface;

import java.util.*;

import model.*;
import userInterface.Main;

public class Main {
	private static Controller controller;

	public Main() {
		controller = new Controller();
		boolean ok = false;
		while (ok == false) {
			try {
				menu();
				ok = true;
			} catch (InputMismatchException e) {
				System.out.println("Make sure you are entering the data correctly");
			}
		}
	}

	private void menu() {
		int option;
		do {
			Scanner scn = new Scanner(System.in);
			System.out.println("Menu\n");
			System.out.println("1. Enter the information of a txt file\n");
			System.out.println("2. Search Participant\n");
			System.out.println("3. Search Attendee\n");
			System.out.println("4. Prit same Country Participants\n");
			System.out.println("5. Exit");
			option = scn.nextInt();
			if (option == 1) {
				System.out.println("Enter the path of the txt you want to enter");
				scn.nextLine();
				String path = scn.nextLine();
				System.out.println(controller.readText(path));
			}
			if (option == 2) {
				System.out.println("Enter the id of the participant");
				int id = scn.nextInt();
				System.out.println(controller.searchParticipant(id));
			}
			if (option == 3) {
				System.out.println("Enter the id of the attendee");
				int id = scn.nextInt();
				System.out.println(controller.searchAttendee(id));
			}
			if (option == 4) {
				System.out.println("Enter the country");
				scn.nextLine();
				String country = scn.nextLine();
				System.out.println("Participants: \n");
				System.out.println(controller.printParticipant(controller.getParticipant1(), country));
				System.out.println("Attendees: \n");
				System.out.println(controller.printAttendee(controller.getRoot(), 0, country));

				if (option == 5) {
					System.exit(0);
				}
			}

		} while (option <= 5);

	}

	public static void main(String[] args) {
		Main main = new Main();

	}
}
