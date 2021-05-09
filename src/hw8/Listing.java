package hw8;

import java.util.Collection;
import java.util.Map;

public class Listing implements IListing {

    // instance vars
    String listingName;
    String propertyType;
    String roomType;
    double price;
    int accommodates;
    double lat;
    double lon;
    int numReviews;
    Collection<IListing> clique;
    double score;

    @Override
    public int compareTo(IListing o) {
        return this.getListingName().compareTo(((Listing) o).getListingName());
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
    
    public String retPropertyType() {
        return this.propertyType;
    }
    
    public String retRoomType() {
        return this.roomType;
    }
    
    public double getScore() {
        return this.score;
    }
    
    public String getListingName() {
        return this.listingName;
    }
    
    public void setListing(String name) {
        this.listingName = name;
    }
    
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }
    
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setAccommodates(int num) {
        this.accommodates = num;
    }
    
    public void setLat(double lat) {
        this.lat = lat;
    }
    
    public void setLong(double lon) {
        this.lon = lon;
    }

    public void setNumReviews(int numReviews) {
        this.numReviews = numReviews;
    }
}
