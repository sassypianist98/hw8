package hw8;

import static org.junit.Assert.*;

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
     * implicitly tests setter for price and getter for priceChekc
     */
    @Test
    public void testCheckPrice() {
        Listing listing = new Listing();
        listing.setPrice(150.55);
        
        // checks in-bounds/out-of-bounds
        listing.checkPrice(listing, 150, 35);
        assertEquals(0, listing.getPriceCheckValue());
        listing.checkPrice(listing, 150.56, 30);
        assertEquals(1, listing.getPriceCheckValue());
        listing.checkPrice(listing, 200, 150);
        assertEquals(1, listing.getPriceCheckValue());
    }

    /**
     * checks that distance returns 0 or 1 when in/out of range
     * implicitly tests the distance setter and getter for checkDistance
     */
    @Test
    public void testCheckDistance() {
        fail("Not yet implemented");
    }

    @Test
    public void testCheckReviews() {
        fail("Not yet implemented");
    }

    @Test
    public void testCheckPropertyType() {
        fail("Not yet implemented");
    }

    @Test
    public void testCheckRoomType() {
        fail("Not yet implemented");
    }

    @Test
    public void testCheckAccommodates() {
        fail("Not yet implemented");
    }

    @Test
    public void testComputeScore() {
        fail("Not yet implemented");
    }

    @Test
    public void testToString() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetPropertyType() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetPropertyType() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetRoomType() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetRoomType() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetPrice() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetPrice() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetAccommodates() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetAccommodates() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetLat() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetLat() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetLon() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetLon() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetNumReviews() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetNumReviews() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetClique() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetClique() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetScore() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetScore() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetDistance() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetDistance() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetId() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetId() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetRadiusDist() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetRadiusDist() {
        fail("Not yet implemented");
    }

}
