package model;

public class Attendee {

	private Attendee left;
	private Attendee rigth;
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String country;
	private String birthday;

	public Attendee(int id, String firstName, String lastName, String email, String gender, String country,
			String birthday) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.birthday = birthday;
	}

	public Attendee getLeft() {
		return left;
	}

	public void setLeft(Attendee left) {
		this.left = left;
	}

	public Attendee getRigth() {
		return rigth;
	}

	public void setRigth(Attendee rigth) {
		this.rigth = rigth;
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

	public String addAttendee(Attendee newAttendee) {
		if (this.id > newAttendee.getId()) {
			if (left != null) {
				return left.addAttendee(newAttendee);
			} else {
				left = newAttendee;
				return "Attendee added successfully";
			}
		} else {
			if (rigth != null) {
				return rigth.addAttendee(newAttendee);
			} else {
				rigth = newAttendee;
				return "Attendee added successfully";
			}
		}
	}

	@Override
	public String toString() {
		return "Attendee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", country=" + country + ", birthday=" + birthday + "]";
	}

	public String searchAttendee(int id) {
		if (this.id > id) {
			if (left == null) {
				return "It was not found";
			} else if (left.getId() == id) {
				return "The Attendee was found \n"+left.toString()+"\n";
			} else {
				return left.searchAttendee(id);
			}
		} else {
			if (rigth == null) {
				return "It was not found";
			} else if (rigth.getId() == id) {
				return "The Attendee was found \n"+rigth.toString()+"\n";
			} else {
				return rigth.searchAttendee(id);
			}
		}
	}

	public Attendee searchObject(int id) {
		if (this.id > id) {
			if (left == null) {
				return null;
			} else if (left.getId() == id) {
				return left;
			} else {
				return left.searchObject(id);
			}
		} else {
			if (rigth == null) {
				return null;
			} else if (rigth.getId() == id) {
				return rigth;
			} else {
				return rigth.searchObject(id);
			}
		}
	}

}
