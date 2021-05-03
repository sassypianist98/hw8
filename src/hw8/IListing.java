package hw8;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public interface IListing extends Comparable<IListing> {
    /**
     * Distances between zip codes and epicenter
     */
    public static final Map<Integer, Double> DISTANCES = null;
    
    /**
     * Maps rank to percentage
     */
    public static final HashMap<Integer, Double> RANK = new HashMap<Integer, Double>() {{
        put(1, 0.04);
        put(2, 0.09);
        put(3, 0.14);
        put(4, 0.19);
        put(5, 0.24);
        put(6, 0.3);
    }};

    /**
     * Sorts the listings in descending order by percentage
     * 
     * @return comparator Object
     */
    public static Comparator<IListing> byDescendingOrder() {
        return null;
    }

    /**
     * Takes user params and returns k closest listings that align
     * with the users preferences
     * 
     * @param k, lowerBoundPrice, upperBoundPrice, distance, numReviews
     * @return closest examples to query
     */
    public Collection<IListing> kNearestNeighbors(int k, double lowerBoundPrice, double
            upperBoundPrice, double distance, int numReviews);
    
    /**
     * Maps importance of user prefernce to rank
     * 
     * @param scores
     * @return map of user params to ranking of importance
     */
    public Map<String, Double> userRank(int[] scores);
    
    /**
     * Applies weights to each relevant parts of the listing
     * 
     * @param map
     * @return double score
     */
    public double computeScore(Map<String, Double> userRank);
}
