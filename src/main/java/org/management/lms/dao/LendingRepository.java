package org.management.lms.dao;

import org.management.lms.model.Lending;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LendingRepository extends JpaRepository<Lending,Integer>{

    public List<Lending> findByUserId(int user_id);
    public Lending findByUserIdAndBookId(int userId,int bookId);
}
