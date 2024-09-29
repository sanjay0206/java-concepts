package com.corejava.java8.streams.movies;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MovieClient {

    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Inception", "Christopher Nolan", LocalDate.of(2010, 7, 16), Arrays.asList("Sci-Fi", "Thriller"), 8.8, true),
                new Movie("The Godfather", "Francis Ford Coppola", LocalDate.of(1972, 3, 24), Arrays.asList("Crime", "Drama"), 9.2, true),
                new Movie("The Dark Knight", "Christopher Nolan", LocalDate.of(2008, 7, 18), Arrays.asList("Action", "Drama"), 9.0, false),
                new Movie("Pulp Fiction", "Quentin Tarantino", LocalDate.of(1994, 10, 14), Arrays.asList("Crime", "Drama"), 8.9, true)
        );
        movies.forEach(System.out::println);
        System.out.println();

        // Filter out movies that have a rating greater than 9?
        List<Movie> filteredMovies = movies.stream().filter(movie -> movie.getRating() > 9).collect(Collectors.toList());
        filteredMovies.forEach(System.out::println);

        // Create a list of movie titles from the list of Movie objects using Streams.
        List<String> movieTitles = movies.stream().map(Movie::getTitle).collect(Collectors.toList());
        System.out.println(movieTitles);

        // How can you sort the movies by their release date?
        List<Movie> sortedMovies = movies.stream().sorted(Comparator.comparing(Movie::getReleaseDate)).collect(Collectors.toList());
        System.out.println(sortedMovies);

        // Calculate the average rating of all movies in the list.
        double avgRating = movies.stream().mapToDouble(Movie::getRating).average().orElse(0.00);
        System.out.println(avgRating);

        // Find the first movie in the list that is not available for streaming?
        System.out.println(movies.stream().filter(Movie::isAvailable).findFirst());

        // Find unique movies genres
        Set<String> genres = movies.stream()
                .flatMap(movie -> movie.getGenres().stream())
                .collect(Collectors.toSet());
        System.out.println(genres);

        // How can you group the movies by their title?
        movies.stream()
                .collect(Collectors.groupingBy(Movie::getTitle))
                .forEach((k, v) -> System.out.println(k + ": " + v));

        // Count the number of movies that were released after 2000?
        long count = movies.stream().filter(movie -> movie.getReleaseDate().getYear() > 2000).count();
        System.out.println(count);
    }
}
