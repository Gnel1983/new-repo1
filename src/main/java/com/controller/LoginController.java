package com.controller;

import com.config.HibernateUtil;
import com.dto.Post;
import com.dto.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@SessionAttributes("userAttribute")
@Controller
@RequestMapping("/login")
public class LoginController {


    @GetMapping
    public String login(@ModelAttribute("user") User user) {

        return "login";
    }

    @PostMapping
    public String doLogin(@ModelAttribute("user") User user, HttpSession session) {
        return null;
    }


}
