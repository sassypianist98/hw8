package hw8;

import java.util.Collection;

public class Engine implements IEngine {

    private double maxDistance;
    private IListing root;
    private Collection<IListing> allListings;
    // TODO - add stuff about graphs

    @Override
    public Collection<IListing> getListings(String fileName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<IListing> outputListings(Collection<IListing> listings, double minScore) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void printListings(Collection<IListing> listings) {
        // TODO Auto-generated method stub

    }

    @Override
    public void checkPrice(IListing listing, int upperBound, int lowerBound) {
        // TODO Auto-generated method stub

    }

    @Override
    public void checkDistance(IListing listing, int maxDistance) {
        // TODO Auto-generated method stub

    }

    @Override
    public void checkReviews(IListing listing, int numReviewsMin) {
        // TODO Auto-generated method stub

    }

    @Override
    public void checkPropertyType(IListing listing, String propertyType) {
        // TODO Auto-generated method stub

    }

    @Override
    public void checkRoomType(IListing listing, String roomType) {
        // TODO Auto-generated method stub

    }

    @Override
    public void checkAccommodates(IListing listing, int accommodates) {
        // TODO Auto-generated method stub

    }

    @Override
    public Collection<String> getPropertyType(Collection<IListing> listings) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<String> getRoomType(Collection<IListing> listings) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * using the haversine formula to compute the distance between two points in
     * miles
     * 
     * Sources used for formula:
     * https://andrew.hedges.name/experiments/haversine/
     * https://www.movable-type.co.uk/scripts/latlong.html
     */
    @Override
    public double computeDistance(IListing l1, IListing l2) {
        double earthRadius = 3961;

        double lat2Rad = ((Listing) l2).getLat() * Math.PI / 180;
        double lat1Rad = ((Listing) l1).getLat() * Math.PI / 180;
        double dLonRad = (((Listing) l2).getLon() - ((Listing) l1).getLon()) * Math.PI / 180;
        double dLatRad = (((Listing) l2).getLat() - ((Listing) l1).getLat()) * Math.PI / 180;

        double a = Math.pow(Math.sin(dLatRad / 2), 2)
                + (Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(dLonRad / 2), 2));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double dist = earthRadius * c;

        return dist;
    }

    @Override
    public Graph makeClique(Collection<IListing> allListings, IListing listing,
            double maxDistance) {
        return null;

        // traverse the Collection

        // if the distance bw listing and current one is <= maxDistance then
        // add an edge - construct a new graph

    }

}
