package com.ibrahim.OpenID2Sample.oauth2;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OAuth2Controller {
    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        String picture = principal.getAttribute("picture");
        String email = principal.getAttribute("email");
        Map result = new HashMap<String,String>();
        result.put("name", principal.getAttribute("name"));
        result.put("image",picture);
        result.put("email",email);

        return result;
    }
}
