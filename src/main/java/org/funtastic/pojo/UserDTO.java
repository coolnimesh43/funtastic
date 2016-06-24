package org.funtastic.pojo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.funtastic.entity.Group;
import org.funtastic.entity.Image;
import org.funtastic.enums.Gender;

public class UserDTO implements Serializable {
	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	private String email;

	@NotNull
	private String password;

	@NotNull
	private String rePassword;

	private Gender genderType;
	private Image profiePic;
	private List<Group> groups;

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

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public Gender getGenderType() {
		return genderType;
	}

	public void setGenderType(Gender genderType) {
		this.genderType = genderType;
	}

	public Image getProfiePic() {
		return profiePic;
	}

	public void setProfiePic(Image profiePic) {
		this.profiePic = profiePic;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", rePassword=" + rePassword + "]";
	}

}
