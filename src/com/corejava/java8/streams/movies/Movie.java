package com.corejava.java8.streams.movies;

import java.time.LocalDate;
import java.util.List;

public class Movie {
    private String title;
    private String director;
    private LocalDate releaseDate;
    private List<String> genres;
    private double rating; // Scale of 1 to 10
    private boolean isAvailable; // Availability for streaming

    // Constructors
    public Movie(String title, String director, LocalDate releaseDate, List<String> genres, double rating, boolean isAvailable) {
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        this.genres = genres;
        this.rating = rating;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", releaseDate=" + releaseDate +
                ", genres=" + genres +
                ", rating=" + rating +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
