package hw8;

import java.util.Collection;
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
    public Map<String, Integer> userRank();

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
     * getters and setters
     * 
     * 
     */
    public double getScore ();

    public String getPropertyType ();

    public String getRoomType ();
    
    public double getPrice ();

    public int getAccommodates ();

    public double getLat ();

    public double getLon ();
    
    public double getDistance();

    public int getNumReviews ();
    
    
    
    public Collection <IListing> getClique ();

    public void setClique (Collection <IListing> clique);

    public void setScore (double score);
    

   
    public boolean isPriceCheck ();

    public void setPriceCheck (boolean priceCheck);

    public boolean isDistanceCheck ();

    public void setDistanceCheck (boolean distanceCheck);

    public boolean isPropertyTypeCheck ();

    public void setPropertyTypeCheck (boolean propertyTypeCheck);

    public boolean isRoomTypeCheck ();

    public void setRoomTypeCheck (boolean roomTypeCheck);
    
    public boolean isReviewsCheck ();
    
    public void setReviewsCheck (boolean reviewsCheck);

    public boolean isAccommodatesCheck ();

    public void setAccommodatesCheck (boolean accommodatesCheck);

    
};
