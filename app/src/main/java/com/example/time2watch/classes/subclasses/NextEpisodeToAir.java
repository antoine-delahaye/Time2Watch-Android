package com.example.time2watch.classes.subclasses;

public class NextEpisodeToAir {
    private String air_date;
    private int episode_number;
    private int id;
    private String name;
    private String overview;
    private String production_code;
    private int season_number;
    private Object still_path;
    private double vote_average;
    private int vote_count;

    public NextEpisodeToAir(String air_date, int episode_number, int id, String name, String overview, String production_code, int season_number, Object still_path, double vote_average, int vote_count) {
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

    public int getEpisode_number() {
        return episode_number;
    }

    public void setEpisode_number(int episode_number) {
        this.episode_number = episode_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getSeason_number() {
        return season_number;
    }

    public void setSeason_number(int season_number) {
        this.season_number = season_number;
    }

    public Object getStill_path() {
        return still_path;
    }

    public void setStill_path(Object still_path) {
        this.still_path = still_path;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    @Override
    public String toString() {
        return "NextEpisodeToAir{" +
                "air_date='" + air_date + '\'' +
                ", episode_number=" + episode_number +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                ", production_code='" + production_code + '\'' +
                ", season_number=" + season_number +
                ", still_path=" + still_path +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                '}';
    }
}
