package hw8;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ListingTest {

    /**
     * checks that compareTo returns 
     * implicitly tests getters and setters for listingName
     */
    @Test
    public void testCompareTo() {
        Listing listing1 = new Listing();
        listing1.setListingName("Beautiful Countryside Home");
        Listing listing2 = new Listing();
        listing2.setListingName("Wonderful Home");
        Listing listing3 = new Listing();
        listing3.setListingName("Beautiful Countryside Home");
        
        // check for lexicographic order
        assertEquals(0, listing1.compareTo(listing3));
        assertTrue(listing3.compareTo(listing2) < 0);
        assertTrue(listing2.compareTo(listing1) > 0);
    }

    /**
     * check that checkPrice returns 0 or 1 when in/out of range
     * implicitly tests setter + getter for price and getter for priceChekc
     */
    @Test
    public void testCheckPrice() {
        Listing listing = new Listing();
        listing.setPrice(150.55);
        
        // checks in-bounds/out-of-bounds
        assertEquals(150.55, listing.getPrice(), 0.01);
        listing.checkPrice(listing, 150, 35);
        assertEquals(0, listing.getPriceCheckValue());
        listing.checkPrice(listing, 150.56, 30);
        assertEquals(1, listing.getPriceCheckValue());
        listing.checkPrice(listing, 200, 150);
        assertEquals(1, listing.getPriceCheckValue());
    }

    /**
     * checks that distance returns 0 or 1 when in/out of range
     * implicitly tests the distance setter + getter and getter for checkDistance
     */
    @Test
    public void testCheckDistance() {
        Listing listing = new Listing();
        listing.setDistance(3.4937);
        
        // checks in-bounds/out-of-bounds
        assertEquals(3.4937, listing.getDistance(), 0.0001);
        listing.checkDistance(listing, 3.48);
        assertEquals(0, listing.getDistanceCheckValue());
        listing.checkDistance(listing,  4);
        assertEquals(1, listing.getDistanceCheckValue());
    }

    /**
     * checks that num of reviews returns 0 or 1 when in/out of range
     * implicitly tests the reviews setter + getter and getter for checkReviews
     */
    @Test
    public void testCheckReviews() {
       Listing listing = new Listing();
       listing.setNumReviews(34);
       
       // checks in-bounds/out-of-bounds
       assertEquals(34, listing.getNumReviews());
       listing.checkReviews(listing, 32);
       assertEquals(1, listing.getReviewCheckValue());
       listing.checkReviews(listing, 35);
       assertEquals(0, listing.getReviewCheckValue());
    }

    /**
     * checks that correct property type returns 0 or 1 when valid type of property
     * implicitly tests the property type setter + getter and getter for checkPropertyType
     */
    @Test
    public void testCheckPropertyType() {
        Listing listing = new Listing();
        listing.setPropertyType("Villa");
        
        // checks if listing is valid
        assertEquals("Villa", listing.getPropertyType());
        listing.checkPropertyType(listing, "Loft");
        assertEquals(0, listing.getPropertyCheckValue());
        listing.checkPropertyType(listing, "Villa");
        assertEquals(1, listing.getPropertyCheckValue());
    }

    /**
     * checks that correct room type returns 0 or 1 when valid type of room
     * implicitly tests the room setter + getter and getter for checkRoomType
     */
    @Test
    public void testCheckRoomType() {
        Listing listing = new Listing();
        listing.setRoomType("Private Bedroom");
        
        // checks if listing is vliad
        assertEquals("Private Bedroom", listing.getRoomType());
        listing.checkRoomType(listing, "Entire Home");
        assertEquals(0, listing.getRoomTypeCheckValue());
        listing.checkRoomType(listing, "Private Bedroom");
        assertEquals(1, listing.getRoomTypeCheckValue());
    }

    /**
     * checks that num of people the listing accommodates returns 0/1 when listing meets min
     * implicitly tests the acommodates setter + getter and getter for checkAccommodates
     */
    @Test
    public void testCheckAccommodates() {
        Listing listing = new Listing();
        listing.setAccommodates(5);
        
        // checks if accommodates is in bounds
        assertEquals(5, listing.getAccommodates());
        listing.checkAccommodates(listing, 3);
        assertEquals(1, listing.getAccommodatesCheckValue());
        listing.checkAccommodates(listing, 8);
        assertEquals(0, listing.getAccommodatesCheckValue());
    }

    /**
     * checks that a give listing and ranking computes the correct score
     * tests getter + setter for score
     */
    @Test
    public void testComputeScore() {
        // init listing
        Listing listing = new Listing();
        listing.setPrice(95);
        listing.setDistance(3.14);
        listing.setNumReviews(69);
        listing.setAccommodates(5);
        listing.setRoomType("Entire Home");
        listing.setPropertyType("Villa");
        listing.checkAccommodates(listing, 4);
        listing.checkPrice(listing, 100, 35);
        listing.checkDistance(listing, 3);
        listing.checkReviews(listing, 50);
        listing.checkRoomType(listing, "Entire Home");
        listing.checkPropertyType(listing, "Apartment");
        
        // init map
        Map<String, Integer> rankingMap = new HashMap<String, Integer>() {{
            put("Price", 2);
            put("Accommodates", 1);
            put("Property Type", 3);
            put("Room Type", 4);
            put("Number of Reviews", 5);
            put("Distance", 6);
        }};

        listing.setScore(listing.computeScore(rankingMap));
        assertEquals(0.559, listing.getScore(), 0.001);
    }

    /**
     * check that toString returns the correctly formatted listing values
     * tests setters for many listing values
     */
    @Test
    public void testToString() {
        // init listing
        Listing listing = new Listing();
        listing.setId(34);
        listing.setListingName("Gorgeous villa in the Marina - sunny garden area w/breakfast service");
        listing.setPrice(95);
        listing.setDistance(3.14);
        listing.setNumReviews(69);
        listing.setAccommodates(5);
        listing.setRoomType("Entire Home");
        listing.setPropertyType("Villa");
        listing.setScore(0.98);
        
        // check that listing toString output is correct
        assertEquals("        34 |             Gorgeous"
                + " villa in the Marina - sunny garden area w/breakfast service"
                + " |      95.00 |                Villa |          Entire Home"
                + " |                    5 |                   69 |     "
                + "  0.98", listing.toString());
    }
}
