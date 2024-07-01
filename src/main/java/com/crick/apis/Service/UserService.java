package com.crick.apis.Service;

import com.crick.apis.Entities.FeaturedMatch;
import com.crick.apis.Entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User signup(User user);
    public List<FeaturedMatch> Bookmark(FeaturedMatch featuredMatch,String email);
    public List<FeaturedMatch> getAllBookmark(String email);
    public String deleteBookmarkById(FeaturedMatch featuredMatch,String email);
    public String clearBookmark(String email);
}
