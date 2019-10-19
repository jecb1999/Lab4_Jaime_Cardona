package model;

public class Participant {

	private Participant next;
	private Participant prev;
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String country;
	private String birthday;

	public Participant(int id, String firstName, String lastName, String email, String gender, String country,
			String birthday) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.birthday = birthday;
	}

	public Participant getNext() {
		return next;
	}

	public void setNext(Participant next) {
		this.next = next;
	}

	public Participant getPrev() {
		return prev;
	}

	public void setPrev(Participant prev) {
		this.prev = prev;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", country=" + country + ", birthday=" + birthday + "]";
	}

	public String searchParticipant(int searchId) {
		if(this.id == searchId) {
			return "The participant was found "+toString();
		}else if(this.next == null) {
			return "The participant not found";
		}
		else {
			return this.next.searchParticipant(searchId);
		}
	}

	public String addParticipant(Participant newParticipant) {
		if(this.next == null) {
			setNext(newParticipant);
			newParticipant.setPrev(this);
			return "Participant added successfully";
		}else {
			return this.next.addParticipant(newParticipant);
		}
	}
	
}
