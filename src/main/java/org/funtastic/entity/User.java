package org.funtastic.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.funtastic.enums.Gender;

@Entity
@Table(name="app_user")
public class User extends AbstractEntity{
	
	@Column(name="first_name",nullable=false)
	@NotNull
	private String firstName;
	
	@Column(name="last_name",nullable=false)
	@NotNull
	private String lastName;
	
	@Column(name="email",nullable=false,unique=true)
	@NotNull
	private String email;
	
	@Column(name="password",nullable=false)
	@NotNull
	private String password;
	
	@Column(name="salt",nullable=false)
	@NotNull
	private String salt;

	@Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender genderType;
	
	@OneToOne
	private Image profiePic;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="user_group",joinColumns={@JoinColumn(name="user_id")},inverseJoinColumns={@JoinColumn(name="group_id")})
	private List<Group> groups;
	
	public User() {
		super();
	}

	public User(String firstName, String lastName, String email, String password, String salt) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.salt = salt;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Image getProfiePic() {
		return profiePic;
	}

	public void setProfiePic(Image profiePic) {
		this.profiePic = profiePic;
	}

	public Gender getGenderType() {
		return genderType;
	}

	public void setGenderType(Gender genderType) {
		this.genderType = genderType;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
				+ ", salt=" + salt + ", getId()=" + getId() + "]";
	}
	
}
