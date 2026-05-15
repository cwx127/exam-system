
package com.example.exam.mapper;

import com.example.exam.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User login(String username, String password);
    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(Integer userId);
    User getUserById(Integer userId);
    void updateUser(User user);
}
