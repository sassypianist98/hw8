package hw8;

import java.util.Collection;

public class Engine implements IEngine {

    double maxDistance;
    IListing root;
    Collection<IListing> allListings;
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

    @Override
    public double computeDistance(double latOrigin, double lonOrigin, double latDestination,
            double lonDestination) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Collection<IListing> makeClique(Collection<IListing> allListings, IListing listing,
            double maxDistance) {
        // TODO Auto-generated method stub
        return null;
    }

}
