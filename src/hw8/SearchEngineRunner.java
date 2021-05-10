package hw8;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;



public class SearchEngineRunner {
    private Engine e;
    private List<IListing> listings;
    private Scanner s;

    /*
     * Constructor
     */
    
    SearchEngineRunner(){
        e = new Engine();
        listings = (ArrayList<IListing>) e.getListings("listings.csv");
        s = new Scanner(System.in);
    }

    
    /*
     * 
     */
    public void mainRunner() {
        suggestionRunner();
        System.out.println("Do you want to see nearby listings? Y/N");
        String answer = s.next();
        if(answer.equals("Y")) {
            radiusRunner();
        }
        
        else {
            System.out.println("Thank you for searching");
            System.exit(0);
        }



    }

    /*
     * Runs the radius method
     */

    public void radiusRunner() {
        Graph g = e.makeGraph(listings);
        System.out.println("Enter the ID of the listing you wish to search around: ");
        int listingID = s.nextInt();
        
        System.out.println("Please enter the maximum radius in miles: ");
        
        double maxDistance = s.nextDouble();
        e.makeClique(listings.get(listingID), maxDistance);
    }


    /*
     * Runs the suggestion method
     */

    public void suggestionRunner() {

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
        double maxDist = s.nextDouble();
        while (maxDist <= 0) {
            maxDist = s.nextDouble();
        }

        // ask for number to display
        System.out.println("How many listings would you like to consider?");
        int topX = s.nextInt();

        // rank preferences from 1-6
        Map<String, Integer> userRank = e.userRank();


        //check each listing

        for(IListing listing : listings) {

            listing.checkAccommodates(listing, accommodates);
            listing.checkDistance(listing, maxDist);
            listing.checkPrice(listing, maxPrice, minPrice);
            listing.checkPropertyType(listing, userPropertyType);
            listing.checkReviews(listing, minReviews);
            listing.checkRoomType(listing, userRoomType);

            listing.computeScore(userRank);

        }
        ArrayList<IListing> userList = (ArrayList <IListing>) e.outputListings(listings, topX);
        e.printListings(userList);

    }

}