package hw8;

import java.util.Collection;

public interface IEngine {
    
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
     * Checks a listing against user preferences
     * 
     * @param 
     */
    
}
