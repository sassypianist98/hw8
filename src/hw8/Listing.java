package hw8;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Listing implements IListing {

    // instance vars
    private int id;
    private String propertyType;
    private String roomType;
    private String listingName;
    private double price;
    private int accommodates;
    private double lat;
    private double lon;
    private int numReviews;
    private Collection<IListing> clique;
    private double score;
    private double distance;
    private int priceCheck;
    private int distanceCheck;
    private int propertyTypeCheck;
    private int roomTypeCheck;
    private int reviewsCheck;
    private int accommodatesCheck;
<<<<<<< HEAD
    
    private int radiusDist;
=======
>>>>>>> branch 'main' of https://github.com/sassypianist98/hw8.git

    @Override
    public int compareTo(IListing o) {
        return this.getListingName().compareTo(((Listing) o).getListingName());
    }



    @Override
<<<<<<< HEAD
    public void checkPrice(IListing listing, double upperBound, double lowerBound) {
        if ((((Listing) listing).getPrice() > lowerBound)
                && (((Listing) listing).getPrice() < upperBound)) {
            priceCheck = 1;
=======
    public Map<String, Integer> userRank() {
        Map<String, Integer> rankingMap = new HashMap<String, Integer>();
        Scanner s = new Scanner(System.in);
        rankingMap.put("Price", null);
        rankingMap.put("Accommodates", null);
        rankingMap.put("Property Type", null);
        rankingMap.put("Room Type", null);
        rankingMap.put("Number of Reviews", null);

        for (Map.Entry<String, Integer> entry : rankingMap.entrySet()) {
            System.out.println("Enter ranking (1-6) for: " + entry.getKey());

            int rank = s.nextInt();
            rankingMap.put(entry.getKey(), rank);
>>>>>>> branch 'main' of https://github.com/sassypianist98/hw8.git
        }
<<<<<<< HEAD
        priceCheck = 0;
=======

        return rankingMap;
>>>>>>> branch 'main' of https://github.com/sassypianist98/hw8.git
    }

    @Override
<<<<<<< HEAD
    public void checkDistance(IListing listing, double maxDistance) {
        if (((Listing) listing).getDistance() <= maxDistance) {
            distanceCheck = 1;
        } else {
            distanceCheck = 0;
        }
    }

    @Override
    public void checkReviews(IListing listing, int numReviewsMin) {
        if (((Listing) listing).getNumReviews() >= numReviewsMin) {
            reviewsCheck = 1;
        } else {
            reviewsCheck = 0;
        }
    }

    @Override
    public void checkPropertyType(IListing listing, String propertyType) {
        if (((Listing) listing).getPropertyType().equals(propertyType)) {
            propertyTypeCheck = 1;
        } else {
            propertyTypeCheck = 0;
        }
    }

    @Override
    public void checkRoomType(IListing listing, String roomType) {
        if (((Listing) listing).getRoomType().equals(roomType)) {
            roomTypeCheck = 1;
        } else {
            roomTypeCheck = 0;
        }
    }

    @Override
    public void checkAccommodates(IListing listing, int accommodates) {
        if (((Listing) listing).getAccommodates() >= accommodates) {
            accommodatesCheck = 1;
        } else {
            accommodatesCheck = 0;
        }
    }

    @Override
    public double computeScore(Map<String, Integer> userRank) {
=======
    public void checkPrice(IListing listing, int upperBound, int lowerBound) {
        if ((((Listing) listing).getPrice() > lowerBound)
                && (((Listing) listing).getPrice() < upperBound)) {
            priceCheck = 1;
        }
        priceCheck = 0;
    }

    @Override
    public void checkDistance(IListing listing, int maxDistance) {
        if (((Listing) listing).getDistance() <= maxDistance) {
            distanceCheck = 1;
        } else {
            distanceCheck = 0;
        }
    }

    @Override
    public void checkReviews(IListing listing, int numReviewsMin) {
        if (((Listing) listing).getNumReviews() >= numReviewsMin) {
            reviewsCheck = 1;
        } else {
            reviewsCheck = 0;
        }
    }

    @Override
    public void checkPropertyType(IListing listing, String propertyType) {
        if (((Listing) listing).getPropertyType().equals(propertyType)) {
            propertyTypeCheck = 1;
        } else {
            propertyTypeCheck = 0;
        }
    }

    @Override
    public void checkRoomType(IListing listing, String roomType) {
        if (((Listing) listing).getRoomType().equals(roomType)) {
            roomTypeCheck = 1;
        } else {
            roomTypeCheck = 0;
        }
    }

    @Override
    public void checkAccommodates(IListing listing, int accommodates) {
        if (((Listing) listing).getAccommodates() >= accommodates) {
            accommodatesCheck = 1;
        } else {
            accommodatesCheck = 0;
        }
    }

    @Override
    public double computeScore(Map<String, Double> userRank) {
>>>>>>> branch 'main' of https://github.com/sassypianist98/hw8.git
        double priceScore = userRank.get("Price") * priceCheck;
        double distScore = userRank.get("Distance") * distanceCheck;
        double reviewScore = userRank.get("Number of Reviews") * reviewsCheck;
        double accScore = userRank.get("Accommodates") * accommodatesCheck;
        double roomScore = userRank.get("Room Type") * roomTypeCheck;
        double propertyScore = userRank.get("Property Type") * propertyTypeCheck;

        score = priceScore + distScore + reviewScore + accScore + roomScore + propertyScore;

        return score;
    }
    
    
    @ Override
    public String toString () {
        String listing = String.format("%-20d %-20s %-20f %-20s %-20s %-20d %-20d %f", this.id, this.listingName, 
                this.price, this.propertyType, this.roomType, this.accommodates, this.numReviews, this.score);
        return listing;
    }
    

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAccommodates() {
        return accommodates;
    }

    public void setAccommodates(int accommodates) {
        this.accommodates = accommodates;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getNumReviews() {
        return numReviews;
    }

    public void setNumReviews(int numReviews) {
        this.numReviews = numReviews;
    }

    public Collection<IListing> getClique() {
        return clique;
    }

    public void setClique(Collection<IListing> clique) {
        this.clique = clique;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getDistance() {
        return this.distance;
    }
<<<<<<< HEAD
    
    public void setDistance(double distance) {
        this.distance = distance;
    }
=======
>>>>>>> branch 'main' of https://github.com/sassypianist98/hw8.git

    public String getListingName() {
        return listingName;
    }

    public void setListingName(String listingName) {
        this.listingName = listingName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
