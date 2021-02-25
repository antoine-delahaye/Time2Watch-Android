package com.example.time2watch.classes.subclasses;

public class LastEpisodeToAir {
    private String air_date;
    private String episode_number;
    private String id;
    private String name;
    private String overview;
    private String production_code;
    private String season_number;
    private String still_path;
    private String vote_average;
    private String vote_count;

    public LastEpisodeToAir(String air_date, String episode_number, String id, String name, String overview, String production_code, String season_number, String still_path, String vote_average, String vote_count) {
        this.air_date = air_date;
        this.episode_number = episode_number;
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.production_code = production_code;
        this.season_number = season_number;
        this.still_path = still_path;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public String getEpisode_number() {
        return episode_number;
    }

    public void setEpisode_number(String episode_number) {
        this.episode_number = episode_number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getProduction_code() {
        return production_code;
    }

    public void setProduction_code(String production_code) {
        this.production_code = production_code;
    }

    public String getSeason_number() {
        return season_number;
    }

    public void setSeason_number(String season_number) {
        this.season_number = season_number;
    }

    public String getStill_path() {
        return still_path;
    }

    public void setStill_path(String still_path) {
        this.still_path = still_path;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    @Override
    public String toString() {
        return "LastEpisodeToAir{" +
                "air_date='" + air_date + '\'' +
                ", episode_number='" + episode_number + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                ", production_code='" + production_code + '\'' +
                ", season_number='" + season_number + '\'' +
                ", still_path='" + still_path + '\'' +
                ", vote_average='" + vote_average + '\'' +
                ", vote_count='" + vote_count + '\'' +
                '}';
    }
}
