package hw8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Interface for the IListings data structures
 * 
 * @author Tiffany Chen, Sarah Engheta, Sarah Shamsie
 *
 */
public interface IListing extends Comparable<IListing> {

    /**
     * This map stores the percentage breakdown applied to each rank (1-6, where
     * 1 is the highest priority)
     */
    public static final HashMap<Integer, Double> RANK = new HashMap<Integer, Double>() {
        {
            put(1, 0.04);
            put(2, 0.09);
            put(3, 0.14);
            put(4, 0.19);
            put(5, 0.24);
            put(6, 0.3);
        }
    };

    /**
     * Sorts the listings in descending order by final score (a percentage from
     * 0-100)
     * 
     * @return comparator object for the listings
     * 
     * @TODO - Tiffany
     */
    public static Comparator<IListing> byDescendingOrder() {
        return null;
    }

    /**
     * As the user ranks each feature type (1-6), it will be stored in a map
     * associating each feature to a rank
     * 
     * @param user input scores (1-6)
     * @return map of features to ranking of importance
     * 
     * @TODO - Sarah E
     */
    public Map<String, Double> userRank();

    /**
     * This method calculates the "final score" associated with a listing based
     * on the weighted percentage computed from its features, applying weights
     * to each relevant part of the listing
     * 
     * @param map of feature type to user rank (1-6)
     * @return double score
     * 
     * @TODO - Sarah S
     */
    public double computeScore(Map<String, Double> userRank);
    
    /**
     * gets the listing's score
     * @return
     */
    public double getScore();
};
