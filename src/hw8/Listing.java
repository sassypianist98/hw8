package hw8;

import java.util.Collection;
import java.util.Map;

public class Listing implements IListing {

    // instance vars
    private String propertyType;
    private String roomType;
    private double price;
    private int accommodates;
    private double lat;
    private double lon;
    private int numReviews;
    private Collection<IListing> clique;
    private double score;

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
        double priceScore = userRank.get("price") * checkPrice();
        double distScore = userRank.get("distance") * checkDistance();
        double reviewScore = userRank.get("num reviews") * checkReviews();
        double accScore = userRank.get("accommodates") * checkAccommodates();
        double roomScore = userRank.get("room type") * checkRoomType();
        double propertyScore = userRank.get("price") * checkPropertyType();

        score = priceScore + distScore + reviewScore + accScore + roomScore + propertyScore;

        return score;
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

}
