package org.management.lms.dao;

import org.management.lms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer>{
//    public void save(User user);
//    public List<User> findAll();
//    public void delete(int id);
//    public User update(int id);
}
