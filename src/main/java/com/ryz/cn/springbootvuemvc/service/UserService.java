package com.ryz.cn.springbootvuemvc.service;
import com.ryz.cn.springbootvuemvc.pojo.User;
import com.ryz.cn.springbootvuemvc.repository.UserRepository;
import org.hibernate.annotations.common.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    @Transactional(rollbackFor = Exception.class)
    public void save(User user){
        if("".equals(user.getId())){
            user.setId(String.valueOf(System.currentTimeMillis()));
        }
        userRepository.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public void init(){
        userRepository.save(new User("20","ryz201",20));
        userRepository.save(new User("21","ryz211",20));
        userRepository.save(new User("22","ryz221",20));
        userRepository.save(new User("22","ryz222",20));
        userRepository.save(new User("23","ryz231",20));
    }

    public User findUserById(String id){
        return userRepository.findUserById(id);
    }
    //@Cacheable(value="user", keyGenerator = "keyGenerator")
    @Cacheable(value="user", key = "#id")
    public User findById(String id){
        return userRepository.findUserById(id);
    }
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value="user",key = "#id" )
    public int deleteById(String id){
        return userRepository.deleteById(id);
    }

    public String findName(String id){
        return userRepository.findName(id);
    }
}