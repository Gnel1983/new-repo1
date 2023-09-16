package com.controller;

import com.config.HibernateUtil;
import com.dto.User;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SessionAttributes("userAttribute")
@Controller
@RequestMapping("/login")
public class LoginController {


    @GetMapping
    public String login(@ModelAttribute("user") User user) {

        return "login";
    }

    // the method that I need to get in, when user press submit, to map my object with "userAttribute"
    // but the spring security avoid it while making login
    @PostMapping
    public String doLogin(@ModelAttribute("user") User user, Model model) {
        String username = user.getUsername();
        String password = user.getPassword();

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> usersList = session.createQuery("from  User u where u.username = :userName").setParameter("username", username).getResultList();

        for (User myUser : usersList) {
            if (myUser.getPassword().equals(password)) {
                model.addAttribute("userAttribute", myUser);

            }
        }
        return "redirect:/";
    }
}



