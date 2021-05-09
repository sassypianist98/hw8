package hw8;

import java.util.Collection;

/**
 * Interface for the IEngine data structure
 * 
 * @author Tiffany Chen, Sarah Engheta, Sarah Shamsie
 *
 */
public interface IEngine {

    /**
     * max number of listings displayed (e.g. show top ten listings)
     */
    public static final int MAX_NUM_DISPLAY = 10;

    /**
     * Reads in data from file
     * 
     * @param fileName
     * @return listings
     * @TODO - Tiffany
     */
    public Collection<IListing> getListings(String fileName);

    /**
     * this method creates a list of listings that meet the score threshold
     * 
     * @param listings
     * @param score
     * @return
     * 
     * @TODO - Sarah E
     */
    public Collection<IListing> outputListings(Collection<IListing> listings, double minScore);

    /**
     * Prints listing information
     * 
     * @param listings
     * @TODO - Sarah E
     */
    public void printListings(Collection<IListing> listings);

    /**
     * checks whether listing's price falls in the range of user preference if
     * it does fall in the range, set priceCheck of listing = 1 otherwise, set
     * priceCheck of listing = 0
     * 
     * @param listing, upperbound of price preference, lowerbound of price
     *                 preference
     * 
     * @TODO - Sarah E
     */
    public int checkPrice(IListing listing, int upperBound, int lowerBound);

    /**
     * checks whether listing's distance from epicenter falls in range of user
     * preference if yes, set distanceCheck of listing =1 if no, set
     * distanceCheck of listing =0
     * 
     * @param listing, distance max
     * @TODO - Sarah E
     */
    public int checkDistance(IListing listing, int maxDistance);

    /**
     * checks whether listing's numOfReviews falls in range of user preference
     * if yes, set reviewsCheck = 1 if no, set reviewsCheck = 0
     * 
     * @param listing, numReviews minimum
     * @TODO - Sarah E
     */
    public int checkReviews(IListing listing, int numReviewsMin);

    /**
     * checks whether listing's property type is aligned with user preference if
     * yes, set propertyTypeCheck =1 if no, set propertyTypeCheck =0
     * 
     * @param listing, property type
     * @TODO - Sarah E
     */
    public int checkPropertyType(IListing listing, String propertyType);

    /**
     * checks whether listing's room type is aligned with user preference if
     * yes, set roomTypeCheck =1 if no, set roomTypeCheck =0
     * 
     * @param listing, roomType
     * @TODO - Sarah E
     */
    public int checkRoomType(IListing listing, String roomType);

    /**
     * checks whether listing's accommodates num is aligned with user preference
     * if yes, set accommodatesCheck =1 if no, set accommodatesCheck =0
     * 
     * @param listing, accommodates num
     * @TODO - Sarah E
     */
    public int checkAccommodates(IListing listing, int accommodates);

    /*
     * outputs list of property types
     * 
     * @param listings
     * 
     * @ TODO - Tiffany
     */
    public Collection<String> getPropertyType(Collection<IListing> listings);

    /*
     * outputs list of room types
     * 
     * @param listings
     * 
     * @TODO - Tiffany
     */
    public Collection<String> getRoomType(Collection<IListing> listings);

    /**
     * this method computes the distance between two IListing objects based on
     * lat and lon
     * 
     * @param latOrigin
     * @param lonOrigin
     * @param latDestination
     * @param lonDestination
     * @return
     * @TODOD - Sarah S
     */
    public double computeDistance(IListing l1, IListing l2);

    /**
     * this method returns a clique of listings where that are <= maxDistance
     * away from the input listings. If this is true, then add an edge between
     * the two listings
     * 
     * @param listing     - root of the clique
     * @param maxDistance
     * @TODO - Sarah S
     */
    public Graph makeClique(Collection<IListing> allListings, IListing listing,
            double maxDistance);

}
