package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class user implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String username;
	private String password;
	private String email;
	private Integer tel;
	private Integer cin;
	private Date dateNaissance;
	private String sex;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
	        name = "users_roles",
	        joinColumns = @JoinColumn(name = "userId"),
	        inverseJoinColumns = @JoinColumn(name = "role_id")
	        )
	private Set<Role> roles = new HashSet<>();
	
	//Constructor :
	public user(Integer userId, String username, String password, String email, Integer tel, Integer cin,
			Date dateNaissance, String sex, Set<Role> roles) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.tel = tel;
		this.cin = cin;
		this.dateNaissance = dateNaissance;
		this.sex = sex;
		this.roles = roles;
	}

	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean isAccountNonExpired() {
	return false;
	}
	
	public boolean isAccountNonLocked() {
	return false;
	}
	
	public boolean isCredentialsNonExpired() {
	return false;
	}
	
	public boolean isEnabled() {
	return false;
	}
	
	//Getters and setters:

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	public Integer getCin() {
		return cin;
	}

	public void setCin(Integer cin) {
		this.cin = cin;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
	
}
