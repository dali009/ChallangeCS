package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.user;
import lombok.Data;





@RestController
public class UserRestService {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/user",method = RequestMethod.GET)
	@GetMapping
	public List<user> getUser(){
		return userRepository.findAll();
		}
	
	@RequestMapping(value="/user/{id}",method = RequestMethod.GET)
    public user getUser(@PathVariable Integer id) {
		return userRepository.findById(id).get();
	}
	
	@PostMapping("/user")
	public user AddUser(@RequestBody user c){
    	return userRepository.save(c);
	}
	
	@RequestMapping(value="/user/{iduser}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUser(@PathVariable Integer iduser) {
			userRepository.deleteById(iduser);
	}
	
	
	@RequestMapping(value="/user/{iduser}",method = RequestMethod.PUT)
	public user EditUser(@PathVariable Integer iduser, @RequestBody user user){
		return userRepository.save(user);
    }
	
	@Data
	class UserForm{
		private String username;
		private String password;
		private String confirmedPassword;
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
		public String getConfirmedPassword() {
			return confirmedPassword;
		}
		public void setConfirmedPassword(String confirmedPassword) {
			this.confirmedPassword = confirmedPassword;
		}
}
}
