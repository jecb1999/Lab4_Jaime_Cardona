package model;

import java.io.*;

public class Controller {

	private Participant participant1;
	private Attendee rootAttendee;

	public Controller() {
		readText(".//Panamericanos.csv");
	}

	public Attendee getRoot() {
		return rootAttendee;
	}

	public Participant getParticipant1() {
		return participant1;
	}

	public String searchParticipant(int id) {
		long i = System.nanoTime();
		if (participant1 == null) {
			return "Not found, empty list";
		} else {
			String a = participant1.searchParticipant(id);
			long f = System.nanoTime();
			Long t = f-i;
			return a+"\ntiempo\n"+t;
		}
	}

	public String addParticipant(int id, String firstName, String lastName, String email, String gender, String country,
			String birthday) {
		Participant newParticipant = new Participant(id, firstName, lastName, email, gender, country, birthday);
		if (participant1 == null) {
			participant1 = newParticipant;
			return "Participant added successfully";
		} else {
			return participant1.addParticipant(newParticipant);
		}
	}

	public String addAttendee(int id, String firstName, String lastName, String email, String gender, String country,
			String birthday) {
		Attendee newAttendee = new Attendee(id, firstName, lastName, email, gender, country, birthday);
		if (rootAttendee == null) {
			rootAttendee = newAttendee;
			return "Attendee added successfully";
		} else {
			return rootAttendee.addAttendee(newAttendee);
		}
	}

	public String readText(String path) {
		String text = "";
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String listAP[] = new String[7];
			String bfRead;
			int counter = 0;
			while ((bfRead = br.readLine()) != null) {
				counter++;
				listAP = bfRead.split(",");
				int id = Integer.parseInt(listAP[0]);
				String firstName = listAP[1];
				String lastName = listAP[2];
				String email = listAP[3];
				String gender = listAP[4];
				String country = listAP[5];
				String birthday = listAP[6];
				if (counter % 2 != 0) {
					addParticipant(id, firstName, lastName, email, gender, country, birthday);
				} else {
					addAttendee(id, firstName, lastName, email, gender, country, birthday);
				}
			}
			text = "File added successfully";
			br.close();
		} catch (Exception e) {
			System.out.println("ERROR");
		}
		return text;
	}


	public String searchAttendee(int id) {
		long i = System.nanoTime();
		if (rootAttendee == null) {
			return "Empty tree";
		} else if (rootAttendee.getId() == id) {
			String r = rootAttendee.toString();
			long f2 = System.nanoTime();
			Long t = f2-i;
			return "The Attendee was found \n"+r+"\ntiempo\n"+t;
		} else {
			String a = rootAttendee.searchAttendee(id);
			long f = System.nanoTime();
			Long t = f-i;
			return a+"\ntiempo\n"+t;
		}
	}


	public String printAttendee(Attendee a, int nivel, String country) {
		if (a != null) {
			if (a.getCountry().equals(country)) {
				return a.toString() + " (" + nivel + ") - " + printAttendee(a.getLeft(), nivel + 1, country)
						+ printAttendee(a.getRigth(), nivel + 1, country);
			} else {
				return printAttendee(a.getLeft(), nivel + 1, country)
						+ printAttendee(a.getRigth(), nivel + 1, country);
			}
		} else {
			return "";
		}
	}

	public String printParticipant(Participant p, String country) {
		if (p != null) {
			if (p == participant1 && p.getCountry().equals(country)) {
				return p.toString() + "-->" + printParticipant(p.getNext(), country);
			} else if (p.getNext() == null && p.getCountry().equals(country)) {
				return "<--" + p.toString();
			} else {
				if (p.getCountry().equals(country)) {
					return "<--" + p.toString() + "-->" + printParticipant(p.getNext(), country);
				} else {
					return printParticipant(p.getNext(), country);
				}
			}
		} else {
			return "";
		}

	}

}
