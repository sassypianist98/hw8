package hw8;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
    public Collection<IListing> outputListings(Collection<IListing> listings, int topX);

    /**
     * Prints listing information
     * 
     * @param listings
     * @TODO - Sarah E
     */
    public void printListings(Collection<IListing> listings);

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
     * Return the neighbors ids of a specific node
     * 
     * @param id the id of the page
     * @return the array of neighbor(s)
     */
    public int[] getNeighbors(Graph g, int id);

    /**
     * make a complete Graph of n vertices from all listings
     * 
     * @param allListings
     * @return
     */
    public Graph makeGraph(Collection<IListing> allListings);

    /**
     * this method returns a clique of listings where that are <= maxDistance
     * away from the input listings. If this is true, then add an edge between
     * the two listings
     * 
     * @param listing     - root of the clique
     * @param maxDistance
     * @TODO - Sarah S
     */
    public Graph makeClique(IListing root, double maxDistance);
    
    
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
}
