package com.example.codefellowship.Controllers;

import com.example.codefellowship.Models.ApplicationUser;
import com.example.codefellowship.Models.Post;
import com.example.codefellowship.Repos.ApplicationUserRepository;
import com.example.codefellowship.Repos.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller

public class Home {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PostRepository postRepository;

//    @GetMapping("/")
//    public String homePage(@AuthenticationPrincipal ApplicationUser user, Model model) {
//        if (user != null) {
//            ApplicationUser findUser = applicationUserRepository.findByUsername(user.getUsername());
//            model.addAttribute("user", findUser.getUsername());
//        }
//        return "home";
//    }

    @GetMapping("/")
    public String homePage(@AuthenticationPrincipal ApplicationUser user, Model model) {
        List<Post> postList = (List<Post>) postRepository.findAll();

        if (user != null) {
            ApplicationUser findUser = applicationUserRepository.findByUsername(user.getUsername());
            model.addAttribute("user", findUser.getUsername());
            List<Post> FollowingPost = new ArrayList();
            for (Post post : postList) {
                if (!findUser.getFollowing().contains(post.getApplicationUser()) && post.getApplicationUser() != findUser)  FollowingPost.add(post);
            }
            model.addAttribute("postList", FollowingPost);
        } else {
            model.addAttribute("postList", postList);
        }
        return "home";
    }



    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal ApplicationUser user, Model model) {
        if (user != null) {
            Optional<ApplicationUser> currentUser = Optional.ofNullable(applicationUserRepository.findByUsername(user.getUsername()));
            model.addAttribute("userId", currentUser.get().getId());
            model.addAttribute("username", currentUser.get().getUsername());
            model.addAttribute("firstName", currentUser.get().getFirstName());
            model.addAttribute("lastName", currentUser.get().getLastName());
            model.addAttribute("dateOfBirth", currentUser.get().getDateOfBirth());
            model.addAttribute("bio", currentUser.get().getBio());

            List<Post> postList = postRepository.findAllByUser(currentUser);
            model.addAttribute("postList", postList);
        }
        return "profile";
    }
    @PostMapping("/follow")
    public RedirectView printHi0(@RequestParam Integer id, @AuthenticationPrincipal ApplicationUser user, Model model) {
        ApplicationUser currentUser = applicationUserRepository.findByUsername(user.getUsername());
        ApplicationUser newFollowing = applicationUserRepository.findById(id).get();
        currentUser.setFollowing(newFollowing);
        applicationUserRepository.save(currentUser);
        return new RedirectView("/");
    }

}
