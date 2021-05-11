package hw8;

import java.util.ArrayList;
import java.util.Collection;
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
     */
    public ArrayList<IListing> getListings(String fileName);

    /**
     * this method creates a list of listings that meet the score threshold
     * 
     * @param listings
     * @param score
     * @return
     * 
     */
    public Collection<IListing> outputListings(ArrayList<IListing> listings, int topX);

    /**
     * Prints listing information
     * 
     * @param listings
     */
    public void printListings(ArrayList<IListing> listings);

    /**
     * outputs list of property types
     * 
     * @param listings
     * @return
     */
    public Collection<String> getPropertyType(ArrayList<IListing> listings);

    /**
     * outputs list of room types
     * 
     * @param listings
     * @return
     */
    public Collection<String> getRoomType(ArrayList<IListing> listings);

    /**
     * this method computes the distance between two IListing objects based on
     * lat and lon
     * 
     * @param l1
     * @param l2
     * @return
     */
    public double computeDistance(IListing l1, IListing l2);

    /**
     * make a complete Graph of n vertices from all listings make a complete
     * Graph of n vertices from all listings
     * 
     * @param listings
     * @return
     */
    public Graph makeGraph(ArrayList<IListing> listings);

    /**
     * this method returns a clique of listings where that are <= maxDistance
     * away from the input listings. If this is true, then add an edge between
     * the two listings
     * 
     * @param listings
     * @param id
     * @param maxDistance
     * @param gComp
     * @return
     */
    public ArrayList<IListing> makeClique(ArrayList<IListing> listings, int id, double maxDistance,
            Graph gComp);

    /**
     * As the user ranks each feature type (1-6), it will be stored in a map
     * associating each feature to a rank
     * 
     * @param s
     * @return
     */
    public Map<String, Integer> userRank(Scanner s);

}
