package com.crick.apis.Controller;

import com.crick.apis.Entities.FeaturedMatch;
import com.crick.apis.Entities.User;
import com.crick.apis.Service.imple.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/match")
public class UserController {

    @Autowired
    UserServiceImpl userService;



    @GetMapping("/loggedin-user")
   public String getLoggedInUser(Principal principal){
       return principal.getName();
   }

   @PostMapping("/bookmark")
   public List<FeaturedMatch> Bookmark(@RequestBody FeaturedMatch featuredMatch,Principal principal){
        String email = getLoggedInUser(principal);
        return userService.Bookmark(featuredMatch,email);
   }

    @GetMapping("/get-bookmark")
    public List<FeaturedMatch> getBookmarks(Principal principal) {
        String email = getLoggedInUser(principal);
        return userService.getAllBookmark(email);
    }

    @PostMapping("/deleteBookmarkById")
    public String deleteBookmarkById(@RequestBody FeaturedMatch featuredMatch, Principal principal) {
        String email = getLoggedInUser(principal);
        return userService.deleteBookmarkById(featuredMatch,email);
    }

    @PostMapping("/clear-bookmarks")
    public String clearBookmark(Principal principal) {
        String email = getLoggedInUser(principal);
        return userService.clearBookmark(email);
    }



}
