package com.example.demo1;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
@Service
public class UserServise {
	
	@Autowired
	UserRepository repository;
	
    @Cacheable(value = "itemCache",key = "#id")
	public User findById(int id) {
		User user = repository.findById(id).get();
		return user;
	}
    @Cacheable(value = "users")
	public List<User> findAll(){
		return repository.findAll();
	}
	@CacheEvict(value = "users", allEntries = true)
	public User createUser(User user) {
	    repository.save(user);
	    return user;
	}
	
	public User findRandom() {
		Random ran = new Random();
	    User user = findById(ran.nextInt(100)+1);
	    if (user!=null) {
	        return user;
	    } else {
	        return new User();
	    }
	}
}
