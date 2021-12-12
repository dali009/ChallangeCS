package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class Role {
	 @Id
     @Column(name = "role_id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
		private String nom;
		private String prenom;
		@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "roles")
		@JsonIgnore
	    private Set<user> users=new HashSet<>();
	    
	    //Constructor :
	    public Role(Integer id, String name) {
			super();
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
		}

	
		public Role(Integer id, String name, Set<user> users) {
			super();
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.users = users;
		}

		public Role() {
			super();
			// TODO Auto-generated constructor stub
		}

		
		//Getters and setters :
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public Set<user> getUsers() {
			return users;
		}

		public void setUsers(Set<user> users) {
			this.users = users;
		}
		
}
