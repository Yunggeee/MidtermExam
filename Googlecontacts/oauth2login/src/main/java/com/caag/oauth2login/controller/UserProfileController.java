package com.caag.oauth2login.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserProfileController {

    @GetMapping("/profile")
    public Map<String, Object> getUserProfile(@AuthenticationPrincipal OAuth2User principal) {
        Map<String, Object> userProfile = new HashMap<>();
        
        if (principal != null) {
            userProfile.put("name", principal.getAttribute("name"));
            userProfile.put("email", principal.getAttribute("email"));
            userProfile.put("picture", principal.getAttribute("picture"));
        } else {
            userProfile.put("name", "Contact User");
            userProfile.put("email", "user@example.com");
            userProfile.put("picture", null);
        }
        
        return userProfile;
    }
}