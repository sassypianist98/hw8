package hw8;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Runner class for the project
 * 
 * @author Tiffany Chen, Sarah Engheta, Sarah Shamsie
 *
 */
public class SearchEngineRunner {
    private Engine e;
    private ArrayList<IListing> listings;
    private Scanner s;

    /**
     * constructor for the class
     */
    SearchEngineRunner() {
        e = new Engine();
        listings = e.getListings("listings.csv");
        s = new Scanner(System.in);
    }

    /**
     * main runner method this can branch into the two other methods - filter
     * based on preference or find clique within distance
     */
    void mainRunner() {
        suggestionRunner();

        System.out.println();
        System.out.println("Do you want to see nearby listings? Y/N");
        String response = s.next();
        if (response.equals("Y")) {
            radiusRunner();
        } else {
            System.out.println();
            System.out.println("Thank you for searching");
            System.exit(0);
        }

    }

    /**
     * Runs the radius method to find clique within nearby distance
     */
    public void radiusRunner() {
        // make graph of all listings
        System.out.println("In this simulation, we will ask you to input the ID of the listing that"
                + " you would like to use to find nearby listings.");

        // get a list of the top 100 listings from suggestionRunner() below
        ArrayList<IListing> top100 = (ArrayList<IListing>) e.outputListings(listings, 100);
        Graph g = e.makeGraph(top100);

        // prompt the user for their preferred id
        System.out.println();
        System.out.println("Enter the ID of the listing you wish to search around: ");
        int listingID = s.nextInt();

        // prompt the user for their preferred max radial distance
        System.out.println();
        System.out.println("Please enter the maximum radius you'd like (miles): ");
        double maxDistance = s.nextDouble();

        // create a graph of the radial distance listings
        ArrayList<IListing> radiusList = e.makeSubgraph(top100, listingID, maxDistance, g);

        // print output to console
        System.out.println();
        System.out.println("Radial group of " + radiusList.size() + " nearby listings");
        String header = String.format("%10s | %80s | %10s | %20s | %20s | %20s | %20s | %10s", "ID",
                "Name", "Price", "Property Type", "Room Type", "Accommodates", "Number of Reviews",
                "Distance");
        System.out.println(header);
        String underscore = String.format("%10s   %80s   %10s   %20s   %20s   %20s   %20s   %10s",
                "--", "----", "-----", "-------------", "---------", "------------",
                "-----------------", "--------");
        System.out.println(underscore);

        for (IListing i : radiusList) {
            Listing curr = (Listing) i;
            System.out.println(
                    String.format("%10d | %80s | %10.2f | %20s | %20s | %20d | %20d | %10.2f",
                            curr.getId(), curr.getListingName(), curr.getPrice(),
                            curr.getPropertyType(), curr.getRoomType(), curr.getAccommodates(),
                            curr.getNumReviews(), curr.getRadiusDist()));
        }
    }

    /**
     * Runs the suggestion method to filter and score listings based on user
     * input preferences
     */
    public void suggestionRunner() {

        // prompt user for preferences
        System.out.println("Welcome to the San Francisco Airbnb search engine!");
        System.out.println(
                "In this simulation, we will ask you to rank and provide your preferences on 6 features.");
        System.out.println("Would you like to proceed? (Y/N)");
        String answer = s.nextLine();
        if (answer.equals("N")) {
            System.out.println("System exiting.");
            System.exit(0);
        }

        // get property preference
        System.out.println();
        System.out.println("Choose a property type from the following:");
        System.out.println();
        TreeSet<String> propertyTypes = (TreeSet<String>) e.getPropertyType(listings);
        for (String property : propertyTypes) {
            System.out.println(property);
        }
        String userPropertyType = s.nextLine();
        while (!propertyTypes.contains(userPropertyType)) {
            userPropertyType = s.nextLine();
        }

        // get room preference
        System.out.println();
        System.out.println("Choose a room type from the following:");
        System.out.println();
        TreeSet<String> roomTypes = (TreeSet<String>) e.getRoomType(listings);
        for (String room : roomTypes) {
            System.out.println(room);
        }
        String userRoomType = s.nextLine();
        while (!roomTypes.contains(userRoomType)) {
            userRoomType = s.nextLine();
        }

        // get num accommodates
        System.out.println();
        System.out.println("How many people will be staying in the accommodation?");
        System.out.println("The max possible # of people is : " + e.getMaxAccommodates());
        int accommodates = s.nextInt();
        while (accommodates < 1 || accommodates > e.getMaxAccommodates()) {
            accommodates = s.nextInt();
        }

        // get price
        System.out.println();
        System.out.println("Min price per night:");
        double minPrice = s.nextDouble();
        while (minPrice < 0 || minPrice > e.getMaxPrice()) {
            minPrice = s.nextDouble();
        }

        System.out.println();
        System.out.println("Max price per night:");
        double maxPrice = s.nextDouble();
        while (maxPrice <= minPrice || maxPrice > e.getMaxPrice()) {
            maxPrice = s.nextDouble();
        }

        // get numReviews
        System.out.println();
        System.out.println("Minimum number of listing reviews:");
        int minReviews = s.nextInt();
        while (minReviews < 0 || minReviews > e.getMaxNumReviews()) {
            minReviews = s.nextInt();
        }

        // get max distance
        System.out.println();
        System.out.println("Max distance from Fisherman's Wharf (miles):");
        double maxDist = s.nextDouble();
        while (maxDist <= 0) {
            maxDist = s.nextDouble();
        }

        // ask for number to display
        System.out.println();
        System.out.println("How many listings would you like to consider?");
        int topX = s.nextInt();

        // rank preferences from 1-6
        System.out.println();
        System.out.println("Now we will ask you to rank your preferences by feature.");
        Map<String, Integer> userRank = e.userRank(s);

        // check each listing against the preferences and compute the score
        for (IListing listing : listings) {

            listing.checkAccommodates(listing, accommodates);
            listing.checkDistance(listing, maxDist);
            listing.checkPrice(listing, maxPrice, minPrice);
            listing.checkPropertyType(listing, userPropertyType);
            listing.checkReviews(listing, minReviews);
            listing.checkRoomType(listing, userRoomType);

            ((Listing) listing).computeScore(userRank);

        }

        // create the limited list of listings
        ArrayList<IListing> userList = (ArrayList<IListing>) e.outputListings(listings, topX);

        // print to console
        System.out.println();
        System.out.println("Your top " + topX + " matches are:");
        String header = String.format("%10s | %80s | %10s | %20s | %20s | %20s | %20s | %10s", "ID",
                "Name", "Price", "Property Type", "Room Type", "Accommodates", "Number of Reviews",
                "Score");
        System.out.println(header);
        String underscore = String.format("%10s   %80s   %10s   %20s   %20s   %20s   %20s   %10s",
                "--", "----", "-----", "-------------", "---------", "------------",
                "-----------------", "-----");
        System.out.println(underscore);

        e.printListings(userList);

    }

    public static void main(String[] args) {
        SearchEngineRunner ser = new SearchEngineRunner();
        ser.mainRunner();
    }

}