
package com.example.exam.service;

import com.example.exam.entity.User;
import java.util.List;

public interface UserService {
    User login(String username, String password);
    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(Integer userId);
    User getUserById(Integer userId);
    void updateUser(User user);
}
