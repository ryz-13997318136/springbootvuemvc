package com.ryz.cn.springbootvuemvc.repository;

import com.ryz.cn.springbootvuemvc.pojo.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
@Table(name="user")
public interface UserRepository extends CrudRepository<User,Long>{

    public User findUserById(String id);


    @Override
    List<User> findAll();

    User findByName(String name);

    int deleteById(String id);

    @Query("select u.name from User u where u.id= ?1")
    String findName(String id);
}