package com.algos.algosfun.repository;

import com.algos.algosfun.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
    @Query(name = "SELECT * from roles r WHERE r.name=:name",nativeQuery = true)
    public Role getRoleByName(@Param("name") String name);
}
