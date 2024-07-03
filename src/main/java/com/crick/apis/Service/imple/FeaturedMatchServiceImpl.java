//package com.crick.apis.Service.imple;
//
//import com.crick.apis.Entities.FeaturedMatch;
//import com.crick.apis.Service.FeaturedMatchService;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class FeaturedMatchServiceImpl implements FeaturedMatchService {
//
//    @Override
//    public List<FeaturedMatch> getAllFeaturedMatch() {
//        List<FeaturedMatch> matches = new ArrayList<>();
//         try {
//            String url = "https://www.hindustantimes.com/cricket/schedule";
//             Document document = Jsoup.connect(url).get();
//             Elements featuredMatch = document.select("a.cricketCard");
//             ArrayList<String> imgSrcList = new ArrayList<>();
//             for(Element featuredMatchLiv : featuredMatch){
//                 String date = featuredMatchLiv.select("div.dateNtime").select("div.dateTimeSec").select("h3").text();
//                 String time = featuredMatchLiv.select("div.dateNtime").select("div.dateTimeSec").select("span").text();
//                 String seriesName = featuredMatchLiv.select("div.predic-head").select("div.seriesName").text();
//                 String venue = featuredMatchLiv.select("div.predic-head").select("span.stadiumName").text();
//                 String team1 = featuredMatchLiv.select("div.cricket-score").select("div.team").select("div.team-score").select("strong.teamNameSmall").text();
//                 String team2 = featuredMatchLiv.select("div.cricket-score").select("div.team").select("div.team-score").select("strong.teamNameSmall").text();
////                 String imageurl1 =featuredMatchLiv.select("div.cricket-score").select("div.team").select("div.team-img img").attr("title");
//                String imageurl2 =featuredMatchLiv.select("div.cricket-score").select("div.team").select("div.team-img img").attr("src");
////                 Elements doc = document.select("div.cricket-score");
////                 for (Element imgElement : doc.select("div.team.team-img img")) {
////                     imgSrcList.add(imgElement.attr("src"));
////                 }
//                 FeaturedMatch featuredMatch1 = new FeaturedMatch();
//                featuredMatch1.setDate(date);
//                 featuredMatch1.setMatchTime(time);
//                 featuredMatch1.setMatchVenue(venue);
//                 featuredMatch1.setTeam1(team1);
//                 featuredMatch1.setTeam2(team2);
//                 featuredMatch1.setSeriesName(seriesName);
//                 featuredMatch1.setImageUrl1("imageurl1");
//                 featuredMatch1.setImageUrl2(imageurl2);
//                 featuredMatch1.setImageurls(imgSrcList);
//                 matches.add(featuredMatch1);
//             }
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//         return matches;
//    }
//}

package com.crick.apis.Service.imple;

import com.crick.apis.Entities.FeaturedMatch;
import com.crick.apis.Entities.Users;
import com.crick.apis.Service.FeaturedMatchService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeaturedMatchServiceImpl implements FeaturedMatchService {



    @Override
    public List<FeaturedMatch> getAllFeaturedMatch() {
        List<FeaturedMatch> matches = new ArrayList<>();
        try {
            String url = "https://www.hindustantimes.com/cricket/schedule";
            Document document = Jsoup.connect(url).get();
            Elements featuredMatch = document.select("a.cricketCard");

            for (Element featuredMatchLiv : featuredMatch) {
                String date = featuredMatchLiv.select("div.dateNtime div.dateTimeSec h3").text();
                String time = featuredMatchLiv.select("div.dateNtime div.dateTimeSec span").text();
                String seriesName = featuredMatchLiv.select("div.predic-head div.seriesName").text();
                String venue = featuredMatchLiv.select("div.predic-head span.stadiumName").text();

                // Extracting team names and images
                Elements teams = featuredMatchLiv.select("div.cricket-score div.team");

                if (teams.size() >= 2) {
                    Element team1Element = teams.get(0);
                    Element team2Element = teams.get(1);

                    String team1Name = team1Element.select("div.team-score strong.teamNameSmall").text();
                    String team2Name = team2Element.select("div.team-score strong.teamNameSmall").text();

                    String imageUrl1 = team1Element.select("div.team-img img").attr("src");
                    String imageUrl2 = team2Element.select("div.team-img img").attr("src");

                    // Create and populate the FeaturedMatch object
                    FeaturedMatch featuredMatch1 = new FeaturedMatch();
                    featuredMatch1.setDate(date);
                    featuredMatch1.setMatchTime(time);
                    featuredMatch1.setMatchVenue(venue);
                    featuredMatch1.setTeam1(team1Name);
                    featuredMatch1.setTeam2(team2Name);
                    featuredMatch1.setSeriesName(seriesName);
                    featuredMatch1.setImageUrl1(imageUrl1);
                    featuredMatch1.setImageUrl2(imageUrl2);

                    matches.add(featuredMatch1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matches;
    }




}

