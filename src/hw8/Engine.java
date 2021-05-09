package hw8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Engine implements IEngine {

    double maxDistance;
    IListing root;
    Collection<IListing> allListings;
    // TODO - add stuff about graphs

    @Override
    public Collection<IListing> getListings(String fileName) {
        List<IListing> listings = new ArrayList<>();
        
        try {
            // add new key and empty list to the map
            BufferedReader r = new BufferedReader(new FileReader(fileName));

            String line = r.readLine();
            
            // get all sequences in the current file
            while ((line = r.readLine()) != null) {

                System.out.println(line);
                String[] details = line.split(",");
                
                System.out.println(details.length);
                
                IListing listing = new Listing();
                ((Listing) listing).setListing(details[0]);
                ((Listing) listing).setPropertyType(details[3]);
                ((Listing) listing).setRoomType(details[4]);
                ((Listing) listing).setAccommodates(Integer.parseInt(details[5]));
                ((Listing) listing).setLat(Double.parseDouble(details[1]));
                ((Listing) listing).setLong(Double.parseDouble(details[2]));
                ((Listing) listing).setPrice(Double.parseDouble(details[6]
                        .replaceAll("[^\\d.]", "")));
                ((Listing) listing).setNumReviews(Integer.parseInt(details[7]));
                
                listings.add(listing);
            }
            
            r.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return listings;
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
        Set<String> propertyTypes = new HashSet<>();
        
        for (IListing listing : listings) {
            if (!propertyTypes.contains(((Listing) listing).retPropertyType())) {
                propertyTypes.add(((Listing) listing).retPropertyType());
            }
        }
        
        return propertyTypes;
    }

    @Override
    public Collection<String> getRoomType(Collection<IListing> listings) {
        Set<String> roomTypes = new HashSet<>();
        
        for (IListing listing : listings) {
            if (!roomTypes.contains(((Listing) listing).retRoomType())) {
                roomTypes.add(((Listing) listing).retRoomType());
            }
        }
        
        return roomTypes;
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
    
    public static void main(String[] args) {
        Engine e = new Engine();
        e.getListings("listings.csv");
    }

}
