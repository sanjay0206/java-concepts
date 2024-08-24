package com.corejava.collections.Maps.movie;

import java.util.HashMap;
import java.util.Map;

public class MovieRatingsClient {

    public static void main(String[] args) {

        Map<Movie, Double> movieRatings = new HashMap<>();

        // Create some Movie objects
        Movie inception = new Movie("Inception", 2010);
        Movie matrix = new Movie("The Matrix", 1999);
        Movie interstellar = new Movie("Interstellar", 2014);
        Movie darkKnight = new Movie("The Dark Knight", 2008);
        Movie pulpFiction = new Movie("Pulp Fiction", 1994);

        // Add movies and their ratings to the HashMap
        movieRatings.put(inception, 8.8);
        movieRatings.put(matrix, 8.7);
        movieRatings.put(interstellar, 8.6);
        movieRatings.put(darkKnight, 9.0);
        movieRatings.put(pulpFiction, 8.9);

        // Print the movie ratings
        for (Map.Entry<Movie, Double> entry : movieRatings.entrySet()) {
            Movie movie = entry.getKey();
            Double rating = entry.getValue();
            System.out.println("Movie: " + movie + ", Rating: " + rating);
        }

        // Check if a specific movie is in the map
        Movie movieToCheck = new Movie("Inception", 2010);
        if (movieRatings.containsKey(movieToCheck)) {
            System.out.println(movieToCheck + " is rated " + movieRatings.get(movieToCheck));
        } else {
            System.out.println(movieToCheck + " is not in the map."); // Will be printed if equals and hashcode is not overridden
        }
    }

}
/*
Movie: Inception (2010), Rating: 8.8
Movie: Interstellar (2014), Rating: 8.6
Movie: The Matrix (1999), Rating: 8.7
Movie: Pulp Fiction (1994), Rating: 8.9
Movie: The Dark Knight (2008), Rating: 9.0
Inception (2010) is rated 8.8
*/
