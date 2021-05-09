package hw8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Engine implements IEngine {


    private ArrayList<IListing> outputList;
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
