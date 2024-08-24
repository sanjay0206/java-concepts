package com.corejava.collections.Maps.movie;

public class Movie {
    private String title;
    private int year;

    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return title + " (" + year + ")";
    }

    @Override
    public boolean equals(Object o) {
        // Check if the object is the same instance
        if (this == o) return true;

        // Check if the object is null or not of the same class
        if (o == null || this.getClass() != o.getClass()) return false;

        // Cast the object to Movie
        Movie movie = (Movie) o;

        // Compare the title, year, and director fields for equality
        return this.year == movie.year &&
                this.title.equals(movie.title);
    }

    @Override
    public int hashCode() {
        // Using a prime number (31) to help ensure a good distribution of hash codes
        int hash = 31 * title.hashCode(); // Base hash code for title
        hash = 31 * hash + year;        // Incorporate year + year since it is primitive datatype
        return hash;
    }
}

/*
equals() must define logical equivalence between objects.
hashCode() must produce the same hash code for objects that are considered equal by equals.

default equals() and hashCode():
public boolean equals(Object obj) {
    return (this == obj);
}

public int hashCode() {
    return System.identityHashCode(this);
}

ref: https://medium.com/@ghoshsiddharth25/java-equals-and-hashcode-contract-656d481f86da
*/
