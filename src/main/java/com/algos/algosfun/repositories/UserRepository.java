package com.algos.algosfun.repositories;

import com.algos.algosfun.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    @Query(name = "SELECT * FROM users u WHERE u.username=:username",nativeQuery = true)
    public User getUserByUsername(@Param("username") String username);

    @Query(name = "SELECT * FROM users u WHERE u.email=:email",nativeQuery = true)
    public User getUserByEmail(@Param("email") String email);
}
