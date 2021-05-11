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

    public static final double LAT = 37.80880860279576;
    public static final double LON = -122.40981027333432;

    /**
     * This map stores the percentage breakdown applied to each rank (1-6, where
     * 1 is the highest priority)
     */
    public static final HashMap<Integer, Double> RANK = new HashMap<>() {
        {
            put(6, 0.04);
            put(5, 0.09);
            put(4, 0.14);
            put(3, 0.19);
            put(2, 0.24);
            put(1, 0.3);
        }
    };

    /**
     * Sorts the listings in descending order by final score (a percentage from
     * 0-100)
     * 
     * @return comparator object for the listings
     */
    public static Comparator<IListing> byDescendingOrder() {
        // comparator terms by weight (descending)
        Comparator<IListing> comp = new Comparator<IListing>() {
            @Override
            public int compare(IListing listing1, IListing listing2) {
                double score1 = ((Listing) listing1).getScore();
                double score2 = ((Listing) listing2).getScore();

                if (((Double) score1).compareTo(score2) == 0) { // lexicographic
                                                                // if same score
                    return ((Listing) listing1).getListingName()
                            .compareTo(((Listing) listing2).getListingName());
                }

                return ((Double) score2).compareTo(score1);
            }
        };

        return comp;
    }

    /**
     * Sorts the listings in the clique by descending distance from root
     * 
     * @return comparator object for the listings
     */
    public static Comparator<IListing> byRadiusDistance() {
        // comparator terms by weight (descending)
        Comparator<IListing> comp = new Comparator<IListing>() {
            @Override
            public int compare(IListing listing1, IListing listing2) {
                double rad1 = ((Listing) listing1).getRadiusDist();
                double rad2 = ((Listing) listing2).getRadiusDist();

                if (((Double) rad1).compareTo(rad2) == 0) { // lexicographic
                                                            // if same score
                    return ((Listing) listing1).getListingName()
                            .compareTo(((Listing) listing2).getListingName());
                }

                return ((Double) rad2).compareTo(rad1);
            }
        };

        return comp;
    }

    /**
     * checks whether listing's price falls in the range of user preference if
     * it does fall in the range, set priceCheck of listing = 1 otherwise, set
     * priceCheck of listing = 0
     * 
     * @param listing
     * @param upperBound
     * @param lowerBound
     */
    public void checkPrice(IListing listing, double upperBound, double lowerBound);

    /**
     * checks whether listing's distance from epicenter falls in range of user
     * preference if yes, set distanceCheck of listing =1 if no, set
     * distanceCheck of listing =0
     * 
     * @param listing
     * @param maxDistance
     */
    public void checkDistance(IListing listing, double maxDistance);

    /**
     * checks whether listing's numOfReviews falls in range of user preference
     * if yes, set reviewsCheck = 1 if no, set reviewsCheck = 0
     * 
     * @param listing
     * @param numReviewsMin
     */
    public void checkReviews(IListing listing, int numReviewsMin);

    /**
     * checks whether listing's property type is aligned with user preference if
     * yes, set propertyTypeCheck =1 if no, set propertyTypeCheck =0
     * 
     * @param listing
     * @param propertyType
     */
    public void checkPropertyType(IListing listing, String propertyType);

    /**
     * checks whether listing's room type is aligned with user preference if
     * yes, set roomTypeCheck =1 if no, set roomTypeCheck =0
     * 
     * @param listing
     * @param roomType
     */
    public void checkRoomType(IListing listing, String roomType);

    /**
     * checks whether listing's accommodates num is aligned with user preference
     * if yes, set accommodatesCheck =1 if no, set accommodatesCheck =0
     * 
     * @param listing
     * @param accommodates
     */
    public void checkAccommodates(IListing listing, int accommodates);

    /**
     * generic compareTo method for objects
     */
    public int compareTo(IListing o);

    /**
     * This method calculates the "final score" associated with a listing based
     * on the weighted percentage computed from its features, applying weights
     * to each relevant part of the listing
     * 
     * @param userRank
     * @return
     */
    public double computeScore(Map<String, Integer> userRank);
    
    /**
     * returns the price check value
     */
    public int getPriceCheckValue();
    
    /**
     * returns the distance check value
     */
    public int getDistanceCheckValue();
    
    /**
     * returns the review check value
     */
    public int getReviewCheckValue();
    
    /**
     * returns valid property type value
     */
    public int getPropertyCheckValue();
    
    /**
     * returns valid room type value
     */
    public int getRoomTypeCheckValue();
    
    /**
     * returns the accommodates check value
     */
    public int getAccommodatesCheckValue();

};
