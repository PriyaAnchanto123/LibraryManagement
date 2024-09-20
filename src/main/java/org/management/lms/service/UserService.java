package org.management.lms.service;

import org.management.lms.dao.UserRepository;
import org.management.lms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class UserService {

	  UserRepository userRepo;

	    @Autowired
	    public UserService(UserRepository userDAO) {
	        this.userRepo = userDAO;
	    }
	   
	    public void save(User user) {
	         userRepo.save(user);
	    }

	    public List<User> findAll() {
	        return userRepo.findAll();
	    }

	    public void delete(int id) {
	    userRepo.deleteById( id);
	    }

		public void update(int id,User Updateduser){
			User existingUser=userRepo.findById(id).orElseThrow(RuntimeException::new);
			existingUser.setFirstName(Updateduser.getFirstName());
			existingUser.setLastName(Updateduser.getLastName());
			existingUser.setEmail(Updateduser.getEmail());
			existingUser.setContact(Updateduser.getContact());
			userRepo.save(existingUser);

		}
//	    public User update(int id) {
//	        return userRepo.updateBy(id);
//	    }

}
