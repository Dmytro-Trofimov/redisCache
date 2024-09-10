package com.example.demo1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserServise servise;
	
	@GetMapping("/findById/{id}")
	public User findById(@PathVariable int id) {
		return servise.findById(id);
	}

	@GetMapping("/findAll")
	public List<User> findAll() {
		return servise.findAll();
	}
	
	@GetMapping("/findRandom")
	public User findRandom() {
		return servise.findRandom();
	}
	
	@PostMapping("/create")
	public User create(@RequestBody User user) {
		return servise.createUser(user);
	}
}