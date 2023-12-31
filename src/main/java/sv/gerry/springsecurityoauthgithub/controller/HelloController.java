package sv.gerry.springsecurityoauthgithub.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/page1")
    public String page1(Model model){
        //use thymeleaf
        model.addAttribute("message", "Hello world from page 1");
        return "page1";

    }


     @GetMapping("/page2")
    public String page2(Model model, 
    @AuthenticationPrincipal OAuth2User user,
    @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client){
        model.addAttribute("clientName", client.getClientRegistration().getClientName());
        model.addAttribute("userName", user.getAttributes());
        return "page2";

    }
    
    
}
