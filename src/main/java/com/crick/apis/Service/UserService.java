package com.crick.apis.Service;

import com.crick.apis.Entities.FeaturedMatch;
import com.crick.apis.Entities.Users;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    Users signup(Users user);
    public List<FeaturedMatch> Bookmark(FeaturedMatch featuredMatch,String email);
    public List<FeaturedMatch> getAllBookmark(String email);
    public String deleteBookmarkById(FeaturedMatch featuredMatch,String email);
    public String clearBookmark(String email);
}
