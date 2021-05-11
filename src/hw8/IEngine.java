package hw8;

import java.util.ArrayList;
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
    public ArrayList<IListing> getListings(String fileName);

    /**
     * this method creates a list of listings that meet the score threshold
     * 
     * @param listings
     * @param score
     * @return
     * 
     * @TODO - Sarah E
     */
    public Collection<IListing> outputListings(ArrayList<IListing> listings, int topX);

    /**
     * Prints listing information
     * 
     * @param listings
     * @TODO - Sarah E
     */
    public void printListings(ArrayList<IListing> listings);

    /*
     * outputs list of property types
     * 
     * @param listings
     * 
     * @ TODO - Tiffany
     */
    public Collection<String> getPropertyType(ArrayList<IListing> listings);

    /*
     * outputs list of room types
     * 
     * @param listings
     * 
     * @TODO - Tiffany
     */
    public Collection<String> getRoomType(ArrayList<IListing> listings);

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
     * make a complete Graph of n vertices from all listings
     * 
     * @param allListings
     * @return
     */
    public Graph makeGraph();

    /**
     * this method returns a clique of listings where that are <= maxDistance
     * away from the input listings. If this is true, then add an edge between
     * the two listings
     * 
     * @param listing     - root of the clique
     * @param maxDistance
     * @TODO - Sarah S
     */
    public ArrayList<IListing> makeClique(IListing root, double maxDistance);

    /**
     * As the user ranks each feature type (1-6), it will be stored in a map
     * associating each feature to a rank
     * 
     * @param user input scores (1-6)
     * @return map of features to ranking of importance
     * 
     * @TODO - Sarah E
     */
    public Map<String, Integer> userRank(Scanner s);

}
