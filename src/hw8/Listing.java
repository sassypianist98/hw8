package hw8;

import java.util.Collection;
import java.util.Map;

public class Listing implements IListing {

    // instance vars
    String propertyType;
    String roomType;
    double price;
    int accommodates;
    double lat;
    double lon;
    int numReviews;
    Collection<IListing> clique;
    double score;
    double distance;

    
    boolean priceCheck;
    boolean distanceCheck;
    boolean propertyTypeCheck;
    boolean roomTypeCheck;
    boolean reviewsCheck;
    boolean accommodatesCheck;
    
    @Override
    public int compareTo(IListing o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Map<String, Double> userRank() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double computeScore(Map<String, Double> userRank) {
        // TODO Auto-generated method stub
        return 0;
    }

    
    public boolean isPriceCheck () {
        return priceCheck;
    }

    public void setPriceCheck (boolean priceCheck) {
        this.priceCheck = priceCheck;
    }

    public boolean isDistanceCheck () {
        return distanceCheck;
    }

    public void setDistanceCheck (boolean distanceCheck) {
        this.distanceCheck = distanceCheck;
    }

    public boolean isPropertyTypeCheck () {
        return propertyTypeCheck;
    }

    public void setPropertyTypeCheck (boolean propertyTypeCheck) {
        this.propertyTypeCheck = propertyTypeCheck;
    }

    public boolean isRoomTypeCheck () {
        return roomTypeCheck;
    }

    public void setRoomTypeCheck (boolean roomTypeCheck) {
        this.roomTypeCheck = roomTypeCheck;
    }

    public boolean isReviewsCheck () {
        return reviewsCheck;
    }

    public void setReviewsCheck (boolean reviewsCheck) {
        this.reviewsCheck = reviewsCheck;
    }

    public boolean isAccommodatesCheck () {
        return accommodatesCheck;
    }

    public void setAccommodatesCheck (boolean accommodatesCheck) {
        this.accommodatesCheck = accommodatesCheck;
    }


    
    public double getDistance() {
        return this.distance;
    }
    
    public double getScore () {
        return this.score;
    }

    public String getPropertyType () {
        return propertyType;
    }

    public void setPropertyType (String propertyType) {
        this.propertyType = propertyType;
    }

    public String getRoomType () {
        return roomType;
    }

    public void setRoomType (String roomType) {
        this.roomType = roomType;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice (double price) {
        this.price = price;
    }

    public int getAccommodates () {
        return accommodates;
    }

    public void setAccommodates (int accommodates) {
        this.accommodates = accommodates;
    }

    public double getLat () {
        return lat;
    }

    public void setLat (double lat) {
        this.lat = lat;
    }

    public double getLon () {
        return lon;
    }

    public void setLon (double lon) {
        this.lon = lon;
    }

    public int getNumReviews () {
        return numReviews;
    }

    public void setNumReviews (int numReviews) {
        this.numReviews = numReviews;
    }

    public Collection <IListing> getClique () {
        return clique;
    }

    public void setClique (Collection <IListing> clique) {
        this.clique = clique;
    }

    public void setScore (double score) {
        this.score = score;
    }

}
