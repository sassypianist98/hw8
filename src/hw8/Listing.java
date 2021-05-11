package hw8;

import java.util.Collection;
import java.util.Map;

/**
 * Listing class implementation
 * 
 * @author Tiffany Chen, Sarah Engheta, Sarah Shamsie
 *
 */
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
    private double radiusDist;

    /**
     * empty constructor for the class
     */
    public Listing() {

    };

    /**
     * compute the feature check values based on user input
     */
    @Override
    public int compareTo(IListing o) {
        return this.getListingName().compareTo(((Listing) o).getListingName());
    }

    @Override
    public void checkPrice(IListing listing, double upperBound, double lowerBound) {
        if ((((Listing) listing).getPrice() > lowerBound)
                && (((Listing) listing).getPrice() < upperBound)) {
            priceCheck = 1;

        } else {
            priceCheck = 0;
        }

    }

    @Override
    public int getPriceCheckValue() {
        return priceCheck;
    }

    @Override
    public void checkDistance(IListing listing, double maxDistance) {
        if (((Listing) listing).getDistance() <= maxDistance) {
            distanceCheck = 1;
        } else {
            distanceCheck = 0;
        }
    }

    @Override
    public int getDistanceCheckValue() {
        return distanceCheck;
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
    public int getReviewCheckValue() {
        return reviewsCheck;
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
    public int getPropertyCheckValue() {
        return propertyTypeCheck;
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
    public int getRoomTypeCheckValue() {
        return roomTypeCheck;
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
    public int getAccommodatesCheckValue() {
        return accommodatesCheck;
    }

    /**
     * compute the score of the listing based on user input
     */
    @Override
    public double computeScore(Map<String, Integer> userRank) {
        double priceScore = RANK.get(userRank.get("Price")) * priceCheck;
        double distScore = RANK.get(userRank.get("Distance")) * distanceCheck;
        double reviewScore = RANK.get(userRank.get("Number of Reviews")) * reviewsCheck;
        double accScore = RANK.get(userRank.get("Accommodates")) * accommodatesCheck;
        double roomScore = RANK.get(userRank.get("Room Type")) * roomTypeCheck;
        double propertyScore = RANK.get(userRank.get("Property Type")) * propertyTypeCheck;

        score = (priceScore + distScore + reviewScore + accScore + roomScore + propertyScore);

        return score;
    }

    /**
     * create a toString output format for each Listing
     */
    @Override
    public String toString() {
        String listing = String.format("%10d | %80s | %10.2f | %20s | %20s | %20d | %20d | %10.2f",
                this.id, this.listingName, this.price, this.propertyType, this.roomType,
                this.accommodates, this.numReviews, this.score);
        return listing;
    }

    /**
     * getters and setters
     */
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

    public void setDistance(double distance) {
        this.distance = distance;
    }

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

    public double getRadiusDist() {
        return radiusDist;
    }

    public void setRadiusDist(double radiusDist) {
        this.radiusDist = radiusDist;
    }

}
