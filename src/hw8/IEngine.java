package hw8;

import java.util.Collection;
import java.util.Map;

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
     */
    public Collection<IListing> getListings(String fileName);
    
    
    /**
     * Prints listing information
     * 
     * @param listings
     */
    public void printListings(Collection<IListing> listings);
    


    /**
     * checks whether listing's price falls in the range of user preference
     *if it does fall in the range, set priceCheck of listing = 1 
     *otherwise, set priceCheck of listing = 0
     * 
     * @param listing, upperbound of price preference, lowerbound of price preference
     */
    public void checkPrice(IListing listing, int upperBound, int lowerBound);
    
    
    /**
     * checks whether listing's distance from epicenter falls in range of user preference
     * if yes, set distanceCheck of listing =1
     * if no, set distanceCheck of listing =0
     * 
     * @param listing, distance max
     */
    public void checkDistance (IListing listing, int maxDistance);


    /**
     * checks whether listing's numOfReviews falls in range of user preference
     * if yes, set reviewsCheck = 1
     * if no, set reviewsCheck = 0
     * 
     * @param listing, numReviews minimum
     */
    public void checkReviews (IListing listing, int numReviewsMin);

    
    /**
     * checks whether listing's property type is aligned with user preference
     * if yes, set propertyTypeCheck =1
     * if no, set propertyTypeCheck =0
     * 
     * @param listing, property type
     */
    public void checkPropertyType(IListing listing, String propertyType);
    
    
    /**
     * checks whether listing's room type is aligned with user preference
     * if yes, set roomTypeCheck =1
     * if no, set roomTypeCheck =0
     * 
     * @param listing, roomType
     */
    public void checkRoomType (IListing listing, String roomType);
    

    /**
     * checks whether listing's accommodates num is aligned with user preference
     * if yes, set accommodatesCheck =1
     * if no, set accommodatesCheck =0
     * 
     * @param listing, accommodates num
     */
    public void checkAccommodates(IListing listing, int accommodates);
    

    /*
     * outputs list of property types
     * 
     * @param listings
     */
    public Collection<String> getPropertyType(Collection<IListing> listings);
    
    
    /*
     * outputs list of room types
     * 
     * @param listings
     */
    public Collection<String> getRoomType (Collection<IListing> listings);
    

}
