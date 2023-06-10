package com.app.stadium;

public class Crickter14May {
	private String name;
	private int age;
	private String email_id;
	private String phone;
	private int rating;

	@Override
	public String toString() {
		return "Crickter14May [name=" + name + ", age=" + age + ", email_id=" + email_id + ", Phone=" + phone
				+ ", rating=" + rating + "]";
	}

	public Crickter14May(String name, int age, String email_id, String phone, int rating) {
		super();
		this.name = name;
		this.age = age;
		this.email_id = email_id;
		phone = phone;
		this.rating = rating;
	}

	public boolean equals(Object o) {
		if(o instanceof Crickter14May) {
			return this.phone==((Crickter14May)o).getPhone();
		}
		return false;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}
	
	public Crickter14May(String name) {
		this.name = name;
	}
	
}
