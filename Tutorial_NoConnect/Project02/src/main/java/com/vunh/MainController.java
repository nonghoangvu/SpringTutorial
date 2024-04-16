package com.vunh;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    private HttpServletRequest req;

    @GetMapping("/")
    String index(Model model) {
        model.addAttribute("title", "Login  ");
        return "index";
    }

    @PostMapping("/send")
    String home(Model model) {
        try {
            User u = new User();
            BeanUtils.populate(u, this.req.getParameterMap());
//            req.setAttribute("user", u);
            model.addAttribute("user", u);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return "home";
    }
    @PostMapping("/get-user")
    String getUser(User user, Model model){
        model.addAttribute("user", user);
        return "home";
    }
}
