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

        for (IListing listing : listings) {

            if (((Listing) listing).getScore() >= minScore) {
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
    public int checkPrice(IListing listing, int upperBound, int lowerBound) {
        if ((((Listing) listing).getPrice() > lowerBound)
                && (((Listing) listing).getPrice() < upperBound)) {
            return 1;
        }
        return 0;
    }

    @Override
    public void checkDistance(IListing listing, int maxDistance) {
        if (((Listing) listing).getDistance() <= maxDistance) {
            ((Listing) listing).setDistanceCheck(1);
        } else {
            listing.setDistanceCheck(0);
        }
    }

    @Override
    public int checkReviews(IListing listing, int numReviewsMin) {
        if (listing.getNumReviews() >= numReviewsMin) {
            listing.setReviewsCheck(1);
        } else {
            listing.setReviewsCheck(0);
        }
    }

    @Override
    public int checkPropertyType(IListing listing, String propertyType) {
        if (listing.getPropertyType().equals(propertyType)) {
            listing.setPropertyTypeCheck(1);
        } else {
            listing.setPropertyTypeCheck(0);
        }
    }

    @Override
    public int checkRoomType(IListing listing, String roomType) {
        if (listing.getRoomType().equals(roomType)) {
            listing.setRoomTypeCheck(1);
        } else {
            listing.setRoomTypeCheck(0);
        }
    }

    @Override
    public int checkAccommodates(IListing listing, int accommodates) {
        if (listing.getAccommodates() >= accommodates) {
            listing.setAccommodatesCheck(1);
        } else {
            listing.setAccommodatesCheck(0);
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
