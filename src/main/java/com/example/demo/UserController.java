package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final HttpSession httpSession;

    @PostMapping("/user")
    public String signup(UserInfo userInfo) { // 회원 추가
        userService.save(userInfo);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        UserInfo userInfo = userService.getUser();
        model.addAttribute("userInfo", userInfo);
        return "login";
    }

    // 추가
    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

    @GetMapping("/autologin")
    public String autologinAfterLogin(@RequestParam String autologin,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
        if(autologin.equals("on")) {
            TokenBasedRememberMeServices tokenBasedRememberMeServices = new TokenBasedRememberMeServices("TEST", userService);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            tokenBasedRememberMeServices.onLoginSuccess(request, response, authentication);
        } else if (autologin.equals("off")) {
            String cookieName = "remember-me";
            Cookie cookie = new Cookie(cookieName, null);
            cookie.setMaxAge(0);
            cookie.setPath(StringUtils.hasLength(request.getContextPath()) ? request.getContextPath() : "/");
            response.addCookie(cookie);
        }

        return "redirect:/";
    }
}
