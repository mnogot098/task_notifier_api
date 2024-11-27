package com.notifier.app.api;

import com.notifier.app.config.UserAuthProvider;
import com.notifier.app.dtos.CredentialsDto;
import com.notifier.app.dtos.SignUpDto;
import com.notifier.app.dtos.UserDto;
import com.notifier.app.services.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/")
public class AuthApiController {

    @Autowired
    UserService userService;
    @Autowired
    UserAuthProvider userAuthProvider;
    @RequestMapping("login")
    public ResponseEntity<Map<String, Object>>  login(@RequestBody CredentialsDto credentialsDto) {
        UserDto user = userService.login(credentialsDto);
        user.setToken(userAuthProvider.createToken(user));
        Map<String, Object> response = new HashMap<>();
        response.put("message", "User logged in successfully!");
        response.put("user", user);
        return ResponseEntity.ok(response);
    }

    @RequestMapping("register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody SignUpDto signupDto) {
        System.out.println("Request:" + signupDto);

        // Register the user
        UserDto user = userService.register(signupDto);

        // Create a map to hold the message and user data
        Map<String, Object> response = new HashMap<>();
        response.put("message", "User registered successfully!");
        response.put("user", user);

        return ResponseEntity.ok(response);
    }

}
