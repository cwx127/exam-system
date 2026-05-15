
package com.example.exam.controller;

import com.example.exam.entity.User;
import com.example.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        User loginUser = userService.login(user.getUsername(), user.getPassword());
        if (loginUser != null) {
            result.put("success", true);
            result.put("message", "登录成功");
            result.put("user", loginUser);
        } else {
            result.put("success", false);
            result.put("message", "用户名或密码错误");
        }
        return result;
    }

    @GetMapping("/list")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public Map<String, Object> addUser(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        try {
            userService.addUser(user);
            result.put("success", true);
            result.put("message", "添加用户成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "添加用户失败：" + e.getMessage());
        }
        return result;
    }

    @DeleteMapping("/delete/{userId}")
    public Map<String, Object> deleteUser(@PathVariable Integer userId) {
        Map<String, Object> result = new HashMap<>();
        try {
            userService.deleteUser(userId);
            result.put("success", true);
            result.put("message", "删除用户成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "删除用户失败：" + e.getMessage());
        }
        return result;
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/update")
    public Map<String, Object> updateUser(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        try {
            userService.updateUser(user);
            result.put("success", true);
            result.put("message", "更新用户成功");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "更新用户失败：" + e.getMessage());
        }
        return result;
    }
}
