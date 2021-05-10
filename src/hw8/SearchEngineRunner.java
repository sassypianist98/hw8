package hw8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class SearchEngineRunner {
    
    public void runner() {
        // get listings
        Engine e = new Engine();
        List<IListing> listings = (ArrayList<IListing>) e.getListings("listings.csv");
        
        // prompt user for preferences
        System.out.println("Welcome to the San Francisco Airbnb search engine!");
        System.out.println("Please enter your preferences:");
        
        // get property preference
        Scanner s = new Scanner(System.in);
        System.out.println("Choose a property type from the following:");
        TreeSet<String> propertyTypes = (TreeSet<String>) e.getPropertyType(listings);
        for (String property : propertyTypes) {
            System.out.println(property);
        }
        String userPropertyType = s.next();
        while (!propertyTypes.contains(userPropertyType)) {
            userPropertyType = s.next();
        }
        
        // get room preference
        System.out.println("Choose a room type from the following:");
        TreeSet<String> roomTypes = (TreeSet<String>) e.getRoomType(listings);
        for (String room : roomTypes) {
            System.out.println(room);
        }
        String userRoomType = s.next();
        while (!roomTypes.contains(userRoomType)) {
            userRoomType = s.next();
        }
        
        // get num accommodates
        System.out.println("How many people will be staying in the accommodation?");
        System.out.println("The max possible # of people is : " + e.getMaxAccommodates());
        int accommodates = s.nextInt();
        while (accommodates < 1 || accommodates > e.getMaxAccommodates()) {
            accommodates = s.nextInt();
        }
        
        // get price
        System.out.println("Min price per night:");
        double minPrice = s.nextDouble();
        while (minPrice < 0 || minPrice > e.getMaxPrice()) {
            minPrice = s.nextDouble();
        }
        System.out.println("Max price per night:");
        double maxPrice = s.nextDouble();
        while (maxPrice <= minPrice || maxPrice > e.getMaxPrice()) {
            maxPrice = s.nextDouble();
        }
        
        // get numReviews
        System.out.println("Minimum number of listing reviews:");
        int minReviews = s.nextInt();
        while (minReviews < 0 || minReviews > e.getMaxNumReviews()) {
            minReviews = s.nextInt();
        }
        
        // get max distance 
        System.out.println("Max distance from Fisherman's Wharf:");
        double distance = s.nextDouble();
        while (distance <= 0) {
            distance = s.nextDouble();
        }
        
        // rank preferences from 1-6
        
        
    }
    
}
