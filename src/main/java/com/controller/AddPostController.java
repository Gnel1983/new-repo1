package com.controller;

import com.config.HibernateUtil;
import com.dto.Post;
import com.dto.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddPostController {


    HibernateUtil hibernateUtil;

    public AddPostController(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    @GetMapping("/add")
    private ModelAndView getAddPost(@ModelAttribute("post") Post post) {
        return new ModelAndView("addPost");

    }


    @PostMapping("/add")
    private String doAddPost(@ModelAttribute("post") Post post) {
        String title = post.getTitle();
        String imgUrl = post.getImgUrl();
        String description = post.getDescription();
        Post myPost = new Post();
        myPost.setTitle(title);
        myPost.setImgUrl(imgUrl);
        myPost.setDescription(description);
        SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
        Transaction transaction;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.persist(myPost);
        transaction.commit();
        session.close();

        return "redirect:/welcome";

    }
}
