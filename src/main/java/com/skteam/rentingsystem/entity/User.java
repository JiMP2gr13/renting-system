package com.skteam.rentingsystem.entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "login")
	private String login;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@ManyToMany
	@JoinTable(name = "rent-item", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
	private List<Item> rentedItems;

	@OneToMany(mappedBy = "owner")
	private List<Item> ownedItems;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<Comment> comments;

	public User() {
	}

	public void addOwnedItem(Item item) {
		if (ownedItems == null) {
			ownedItems = new ArrayList<>();
		}
		ownedItems.add(item);
	}

	public void addComment(Comment comment) {
		if (comments == null) {
			comments = new ArrayList<>();
		}
		comments.add(comment);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public List<Item> getRentedItems() {
		return rentedItems;
	}

	public void setRentedItems(List<Item> rentedItems) {
		this.rentedItems = rentedItems;
	}

	public List<Item> getOwnedItems() {
		return ownedItems;
	}

	public void setOwnedItems(List<Item> ownedItems) {
		this.ownedItems = ownedItems;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + login + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
				+ ", email='" + email + '\'' + '}';
	}
}
