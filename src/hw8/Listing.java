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

}
