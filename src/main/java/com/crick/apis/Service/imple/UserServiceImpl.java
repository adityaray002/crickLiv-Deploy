
package com.crick.apis.Service.imple;

import com.crick.apis.Entities.FeaturedMatch;
import com.crick.apis.Entities.User;
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
    public User signup(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public List<FeaturedMatch> Bookmark(FeaturedMatch featuredMatch, String email) {
        User user = userRepo.findByEmail(email).orElse(null);
        if (user != null) {
            List<FeaturedMatch> allBookmarks = user.getBookmark();
            if (allBookmarks == null) {
                allBookmarks = new ArrayList<>();
            }
            allBookmarks.add(featuredMatch);
            user.setBookmark(allBookmarks);
            userRepo.save(user);
            return allBookmarks;
        }
        return new ArrayList<>();
    }


    public List<User> getUser() {
        return userRepo.findAll();
    }

    @Override
    public List<FeaturedMatch> getAllBookmark(String email) {
        Optional<User> userOpt = userRepo.findByEmail(email);
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
        User user = userRepo.findByEmail(email).orElse(null);
        if (user != null) {
            List<FeaturedMatch> bookmarkedList = user.getBookmark();
            Iterator<FeaturedMatch> iterator = bookmarkedList.iterator();
            while (iterator.hasNext()) {
                FeaturedMatch match = iterator.next();
                if (match.equals(featuredMatch)) {
                    iterator.remove();
                    user.setBookmark(bookmarkedList);
                    userRepo.save(user);
                    return "success";
                }
            }
        }
        return "failure";
    }

    @Override
    public String clearBookmark(String email) {
        User user = userRepo.findByEmail(email).orElse(null);
        if(user!=null){
            List<FeaturedMatch> list = user.getBookmark();
            list.clear();
            user.setBookmark(list);

            userRepo.save(user);
            return "Success";
        }
        return "failure";
    }
}
