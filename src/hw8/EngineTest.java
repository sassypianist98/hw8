package hw8;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

public class EngineTest {

    /**
     * tests that getListings returns the expected list of listings
     * tests listing getters implicitly
     */
    @Test
    public void testGetListings() {
        Engine e = new Engine();
        ArrayList<IListing> listings = e.getListings("test.txt");
        
        // check for expected output size
        assertEquals(3, listings.size());
        
        // check for expected listing values
        assertEquals("Art Deco-Era Apartment with 2B/2B", ((Listing) listings.get(0)).getListingName());
        assertEquals(37.39473, ((Listing) listings.get(0)).getLat(), 0);
        assertEquals(-128.39437, ((Listing) listings.get(0)).getLon(), 0);
        assertEquals("Apartment", ((Listing) listings.get(0)).getPropertyType());
        assertEquals("Entire Apartment", ((Listing) listings.get(0)).getRoomType());
        
        assertEquals(2, ((Listing) listings.get(2)).getAccommodates());
        assertEquals(5, ((Listing) listings.get(0)).getAccommodates());
        assertEquals(120, ((Listing) listings.get(2)).getPrice(), 0);
        assertEquals(59, ((Listing) listings.get(1)).getNumReviews());
    }

    /**
     * implicitly tests the comparator
     * tests that topX num of listings are output in descending score order
     */
    @Test
    public void testOutputListings() {
        Engine e = new Engine();
        ArrayList<IListing> allListings = new ArrayList<>();
        Listing listing1 = new Listing();
        listing1.setScore(38.39);
        allListings.add(listing1);
        Listing listing2 = new Listing();
        listing2.setScore(38.37);
        allListings.add(listing2);
        Listing listing3 = new Listing();
        listing3.setScore(14.394);
        allListings.add(listing3);
        Listing listing4 = new Listing();
        listing4.setScore(0.349);
        allListings.add(listing4);
        Listing listing5 = new Listing();
        listing5.setScore(0.583);
        allListings.add(listing5);
        
        // check that output size is as expected
        assertEquals(5, e.outputListings(allListings, 10).size());
        assertEquals(3, e.outputListings(allListings, 3).size());
        
        // check that ordering is as expected
        ArrayList<IListing> sortedFour = (ArrayList<IListing>) e.outputListings(allListings, 4);
        assertEquals(4, sortedFour.size());
        assertEquals(38.39, ((Listing) sortedFour.get(0)).getScore(), 0.01);
        assertEquals(38.37, ((Listing) sortedFour.get(1)).getScore(), 0.01);
        assertEquals(14.394, ((Listing) sortedFour.get(2)).getScore(), 0.001);
        assertEquals(0.583, ((Listing) sortedFour.get(3)).getScore(), 0.001);
    }

    /**
     * checks that correct string property values are output
     * tests using test.txt
     */
    @Test
    public void testGetPropertyType() {
        Engine e = new Engine();
        ArrayList<IListing> listings = e.getListings("test.txt");
        TreeSet<String> propertyTypes = (TreeSet<String>) e.getPropertyType(listings);
        
        // check that correct property types have been output
        assertEquals(3, propertyTypes.size());
        Iterator<String> it = propertyTypes.iterator();
        assertEquals("Apartment", it.next());
        assertEquals("Bed and Breakfast", it.next());
        assertEquals("Cottage", it.next());
    }

    /**
     * checks that correct string room type values are output
     */
    @Test
    public void testGetRoomType() {
        Engine e = new Engine();
        ArrayList<IListing> listings = e.getListings("test.txt");
        TreeSet<String> roomTypes = (TreeSet<String>) e.getRoomType(listings);
        
        // check that correct room type values have been output
        assertEquals(2, roomTypes.size());
        Iterator<String> it = roomTypes.iterator();
        assertEquals("Entire Apartment", it.next());
        assertEquals("Private Room", it.next());
    }

    /**
     * checks that the created graph has expected values
     */
    @Test
    public void testMakeGraph() {
        // make graph
        Engine e = new Engine();
        ArrayList<IListing> listings = e.getListings("test.txt");
        Graph g = e.makeGraph(listings);
        
        // check that a complete graph exists
        assertEquals(3, g.nodeCount());
        assertEquals(12, g.edgeCount());
    }

    /**
     * checks that a clique is created as expected
     */
    @Test
    public void testMakeClique() {
        // init listings
        Engine e = new Engine();
        ArrayList<IListing> listings = e.getListings("test.txt");
        
        // make clique
        Graph g = e.makeGraph(listings);
        ArrayList<IListing> closest = e.makeClique(listings, 0, 297, g);
        
        // checks that clique created only includes listings within the chosen radius
        assertEquals(2, closest.size());
        assertEquals(270.945, ((Listing) closest.get(0)).getDistance(), 0.001);
        assertEquals(296.423, ((Listing) closest.get(1)).getDistance(), 0.001);
    }

    /**
     * checks that getter returns epicenter with correct values
     */
    @Test
    public void testGetEpicenter() {
        // get epicenter
        Engine e = new Engine();
        Listing epicenter = e.getEpicenter();
        
        // check for expected values
        assertEquals(37.80880860279576, epicenter.getLat(), 0.00000000000001);   
        assertEquals(-122.40981027333432, epicenter.getLon(), 0.00000000000001);
    }

    /** 
     * tests getters + setters for maxAccommodates
     */
    @Test
    public void testGetSetMaxAccommodates() {
        Engine e = new Engine();
        
        // set and get to check
        e.setMaxAccommodates(34838);
        assertEquals(34838, e.getMaxAccommodates());
        e.setMaxAccommodates(-192);
        assertEquals(-192, e.getMaxAccommodates());
    }

    /**
     * tests getters + setters for maxPrice
     */
    @Test
    public void testGetSetMaxPrice() {
        Engine e = new Engine();
        
        // set and get to check
        e.setMaxPrice(1500.34);
        assertEquals(1500.34, e.getMaxPrice(), 0.01);
    }

    /**
     * tests getters + setters for maxNumReviews
     */
    @Test
    public void testGetSetMaxNumReviews() {
        Engine e = new Engine();
        
        // set and get to check
        e.setMaxNumReviews(2593);
        assertEquals(2593, e.getMaxNumReviews());
    }
}
