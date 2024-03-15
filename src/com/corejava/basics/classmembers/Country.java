package com.corejava.basics.classmembers;
 class Country {
    // Non-static variables
    private String countryName; // Each object of the class will have its own copy
    private String countryCode; // Each object of the class will have its own copy
    private String continentName; // Each object of the class will have its own copy

    // Static variable
    public static int countryCounter; // Shared among all objects of the class

    // Constructor to initialize non-static variables
    public Country(String name, String code, String continent) {
        this.countryName = name;
        this.countryCode = code;
        this.continentName = continent;
        countryCounter++; // Incrementing the countryCounter every time a new Country object is created
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }
    public String getContinentName() {
        return continentName;
    }

    public static void main(String[] args) {
        // Creating some Country objects
        Country usa = new Country("United States", "US", "North America");
        Country uk = new Country("United Kingdom", "UK", "Europe");
        Country china = new Country("China", "CN", "Asia");

        // Displaying information about the countries
        System.out.println("Country Information:");
        System.out.println("USA: " + usa.getCountryName() + " (" + usa.getCountryCode() + ") - " + usa.getContinentName());
        System.out.println("UK: " + uk.getCountryName() + " (" + uk.getCountryCode() + ") - " + uk.getContinentName());
        System.out.println("China: " + china.getCountryName() + " (" + china.getCountryCode() + ") - " + china.getContinentName());

        // Displaying the total number of countries created
        System.out.println("Total countries created: " + Country.countryCounter);
    }
}

/* O/P;
Country Information:
USA: United States (US) - North America
UK: United Kingdom (UK) - Europe
China: China (CN) - Asia
Total countries created: 3
 */