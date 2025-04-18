package ma.emsi.p2.controllers;

  // Must be subpackage of main class

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")  // Handles root URL
    public String showHomePage() {
        System.out.println("HomeController: Attempting to render home.html");
        return "home";  // Matches src/main/resources/templates/home.html
    }
}