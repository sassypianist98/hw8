package hw8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Engine implements IEngine {

    double maxDistance;
    IListing root;
    Collection<IListing> allListings;
    Collection<IListing> outputList;
    // TODO - add stuff about graphs

    @Override
    public Collection<IListing> getListings(String fileName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<IListing> outputListings(Collection<IListing> listings, double minScore) {
        outputList = new ArrayList<IListing>();

        for(IListing listing : listings) {

            if(listing.getScore() >= minScore) {
                outputList.add(listing);
            } 
        }
        return outputList;
    }

    @Override
    public void printListings(Collection<IListing> listings) {
        System.out.println(outputList);

    }

    @Override
    public void checkPrice(IListing listing, int upperBound, int lowerBound) {
        if((listing.getPrice() > lowerBound ) &&(listing.getPrice()< upperBound)) {
            listing.setPriceCheck(true);
        }
        else {
            listing.setPriceCheck(false);
        }
    }

    @Override
    public void checkDistance(IListing listing, int maxDistance) {
        if(listing.getDistance() <= maxDistance){
            listing.setDistanceCheck(true);
        }
        else {
            listing.setDistanceCheck(false);
        }
    }

    @Override
    public void checkReviews(IListing listing, int numReviewsMin) {
        if(listing.getNumReviews() >= numReviewsMin) {
            listing.setReviewsCheck(true);
        }
        else {
            listing.setReviewsCheck(false);
        }
    }

    @Override
    public void checkPropertyType(IListing listing, String propertyType) {
        if(listing.getPropertyType().equals(propertyType)) {
            listing.setPropertyTypeCheck(true);
        }
        else {
            listing.setPropertyTypeCheck(false);
        }
    }

    @Override
    public void checkRoomType(IListing listing, String roomType) {
        if(listing.getRoomType().equals(roomType)) {
            listing.setRoomTypeCheck(true);
        }
        else {
            listing.setRoomTypeCheck(false);
        }
    }

    @Override
    public void checkAccommodates(IListing listing, int accommodates) {
        if(listing.getAccommodates() >= accommodates) {
            listing.setAccommodatesCheck(true);
        }
        else {
            listing.setAccommodatesCheck(false);
        }
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
