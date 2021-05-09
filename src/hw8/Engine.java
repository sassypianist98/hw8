package hw8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Engine implements IEngine {

    double maxDistance;
    IListing root;
    Collection<IListing> allListings;
    ArrayList<IListing> outputList;
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
        Collections.sort(outputList, IListing.byDescendingOrder());
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
    public int checkDistance(IListing listing, int maxDistance) {
        if (((Listing) listing).getDistance() <= maxDistance) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int checkReviews(IListing listing, int numReviewsMin) {
        if (((Listing) listing).getNumReviews() >= numReviewsMin) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int checkPropertyType(IListing listing, String propertyType) {
        if (((Listing) listing).getPropertyType().equals(propertyType)) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int checkRoomType(IListing listing, String roomType) {
        if (((Listing) listing).getRoomType().equals(roomType)) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int checkAccommodates(IListing listing, int accommodates) {
        if (((Listing) listing).getAccommodates() >= accommodates) {
            return 1;
        } else {
            return 0;
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
