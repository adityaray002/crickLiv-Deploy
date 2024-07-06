package com.crick.apis.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Objects;

@Entity
public class FeaturedMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long featuredMatchId;

    private String Date;
    private String seriesName;
    private String matchTime;
    private String matchVenue;
    private String Team1;
    private String imageUrl1;
    private String imageUrl2;

    public Boolean getBookmarked() {
        return isBookmarked;
    }

    public void setBookmarked(Boolean bookmarked) {
        isBookmarked = bookmarked;
    }

    private String Team2;
    private Boolean isBookmarked=false;

    public String getImageUrl2() {
        return imageUrl2;
    }

    public void setImageUrl2(String imageUrl2) {
        this.imageUrl2 = imageUrl2;
    }

    public String getImageUrl1() {
        return imageUrl1;
    }

    public void setImageUrl1(String imageUrl1) {
        this.imageUrl1 = imageUrl1;
    }

    public String getImageUrl() {
        return imageUrl1;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl1 = imageUrl;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }




    public Long getFeaturedMatchId() {
        return featuredMatchId;
    }

    public void setFeaturedMatchId(Long featuredMatchId) {
        this.featuredMatchId = featuredMatchId;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public String getMatchVenue() {
        return matchVenue;
    }

    public void setMatchVenue(String matchVenue) {
        this.matchVenue = matchVenue;
    }

    public String getTeam1() {
        return Team1;
    }

    public void setTeam1(String team1) {
        Team1 = team1;
    }

    public String getTeam2() {
        return Team2;
    }

    public void setTeam2(String team2) {
        Team2 = team2;
    }


    public FeaturedMatch(Long featuredMatchId, String matchTime, String matchVenue, String team1, String team2, String Date,String seriesName,String imageUrl1,String imageUrl2,Boolean isBookmarked) {
        this.featuredMatchId = featuredMatchId;
        this.matchTime = matchTime;
        this.matchVenue = matchVenue;
        Team1 = team1;
        Team2 = team2;
        this.Date=Date;
        this.seriesName = seriesName;
        this.imageUrl1=imageUrl1;
        this.imageUrl2 = imageUrl2;
        this.isBookmarked=isBookmarked;
    }

    public FeaturedMatch() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeaturedMatch that = (FeaturedMatch) o;
        return Objects.equals(featuredMatchId, that.featuredMatchId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(featuredMatchId);
    }
}
