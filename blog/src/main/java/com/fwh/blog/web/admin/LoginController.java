package com.fwh.blog.web.admin;

import com.fwh.blog.pojo.User;
import com.fwh.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);
        // 如果user不为空则放到session里
        if (user != null) {
            // 不让密码穿进去
            user.setPassword(null);
            session.setAttribute("user", user);
            // 返回index界面
            return "admin/index";
        } else {
            // 提示账号密码错误
            attributes.addFlashAttribute("message", "用户名或密码有误,请重新输入!");
            // 账号密码错误重定向登录界面
            return "redirect:/admin";
        }
    }

    // 注销用户
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 把session清空
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
