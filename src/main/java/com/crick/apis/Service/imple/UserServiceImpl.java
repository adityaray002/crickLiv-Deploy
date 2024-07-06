
package com.crick.apis.Service.imple;

import com.crick.apis.Entities.FeaturedMatch;

import com.crick.apis.Entities.Users;
import com.crick.apis.Repositories.UserRepo;
import com.crick.apis.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String signup(Users users) {
        if(userRepo.findByEmail(users.getEmail()).isPresent()){
            return "user already exist";

        }
        users.setPassword(passwordEncoder.encode(users.getPassword()));
         userRepo.save(users);
         return "Registered successfully";
    }

    @Override
    public List<FeaturedMatch> Bookmark(FeaturedMatch featuredMatch, String email) {
        Users users = userRepo.findByEmail(email).orElse(null);
        if (users != null) {
            List<FeaturedMatch> allBookmarks = users.getBookmark();
            if (allBookmarks == null) {
                allBookmarks = new ArrayList<>();
            }
            featuredMatch.setBookmarked(true);
            allBookmarks.add(featuredMatch);
            users.setBookmark(allBookmarks);
            userRepo.save(users);
            return allBookmarks;
        }
        return new ArrayList<>();
    }


    public List<Users> getUser() {
        return userRepo.findAll();
    }

    @Override
    public List<FeaturedMatch> getAllBookmark(String email) {
        Optional<Users> userOpt = userRepo.findByEmail(email);
        if (userOpt.isPresent()) {
            return userOpt.get().getBookmark();
        }
        return new ArrayList<>();
    }

//    @Override
//    public String deleteBookmarkById(FeaturedMatch featuredMatch,String email) {
//        User user = userRepo.findByEmail(email).orElse(null);
//        if(user!=null){
//           List<FeaturedMatch>  bookmarkedList = getAllBookmark(email);
//           for(FeaturedMatch i:bookmarkedList){
//               if(i.equals(featuredMatch)){
//                   bookmarkedList.remove(i);
//                   user.setBookmark(bookmarkedList);
//                   userRepo.save(user);
//                   break;
//               }
//           }
//
//        }
//        return "success";
//    }

    @Override
    public String deleteBookmarkById(FeaturedMatch featuredMatch, String email) {
        Users users = userRepo.findByEmail(email).orElse(null);
        if (users != null) {
            List<FeaturedMatch> bookmarkedList = users.getBookmark();
            Iterator<FeaturedMatch> iterator = bookmarkedList.iterator();
            while (iterator.hasNext()) {
                FeaturedMatch match = iterator.next();
                if (match.equals(featuredMatch)) {
                    featuredMatch.setBookmarked(false);
                    iterator.remove();
                    users.setBookmark(bookmarkedList);
                    userRepo.save(users);
                    return "success";
                }
            }
        }
        return "failure";
    }

    @Override
    public String clearBookmark(String email) {
        Users users = userRepo.findByEmail(email).orElse(null);
        if(users!=null){
            List<FeaturedMatch> list = users.getBookmark();
            list.clear();
            users.setBookmark(list);

            userRepo.save(users);
            return "Success";
        }
        return "failure";
    }
}
