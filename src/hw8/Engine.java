package hw8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Engine implements IEngine {

    private ArrayList<IListing> outputList;
    private List<IListing> allListings;
    private int maxAccommodates;
    private double maxPrice;
    private int maxNumReviews;
    private Listing epicenter;
    
    public Engine() {
        maxAccommodates = 0;
        maxPrice = 0;
        maxNumReviews = 0;
        epicenter = new Listing();
        epicenter.setLat(IListing.LAT);
        epicenter.setLon(IListing.LON);
    }
    
    public Listing getEpicenter() {
        return epicenter;
    }

    public int getMaxAccommodates() {
        return maxAccommodates;
    }


    public void setMaxAccommodates(int maxAccommodates) {
        this.maxAccommodates = maxAccommodates;
    }


    public double getMaxPrice() {
        return maxPrice;
    }


    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }


    public int getMaxNumReviews() {
        return maxNumReviews;
    }


    public void setMaxNumReviews(int maxNumReviews) {
        this.maxNumReviews = maxNumReviews;
    }


    @Override
    public Collection<IListing> getListings(String fileName) {
        List<IListing> listings = new ArrayList<>();

        try {
            // add new key and empty list to the map
            BufferedReader r = new BufferedReader(new FileReader(fileName));

            String line = r.readLine();

            // get all sequences in the current file
            int count = 0;
            while ((line = r.readLine()) != null) {

                String[] details = line.split(",");

                IListing listing = new Listing();
                ((Listing) listing).setListingName(details[0]);
                ((Listing) listing).setLat(Double.parseDouble(details[1]));
                ((Listing) listing).setLon(Double.parseDouble(details[2]));
                ((Listing) listing).setPropertyType(details[3]);
                ((Listing) listing).setRoomType(details[4]);
                
                // check max accommodates
                Integer accommodates = Integer.parseInt(details[5]);
                if (accommodates > maxAccommodates) {
                    maxAccommodates = accommodates;
                }
                ((Listing) listing).setAccommodates(accommodates);
                
                // check max price
                Double price = Double.parseDouble(details[6].replaceAll("[^\\d.]", ""));
                if (price > maxPrice) {
                    maxPrice = price;
                }
                ((Listing) listing).setPrice(price);
                
                // check max num of reviews
                Integer numReviews = Integer.parseInt(details[7]);
                if (numReviews > maxNumReviews) {
                    maxNumReviews = numReviews;
                }
                ((Listing) listing).setNumReviews(numReviews);
                
                ((Listing) listing).setId(count++);
                
                listings.add(listing);
            }

            r.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        allListings = listings;
        return listings;
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
    public Collection<String> getPropertyType(Collection<IListing> listings) {
        Set<String> propertyTypes = new TreeSet<>();

        for (IListing listing : listings) {
            if (!propertyTypes.contains(((Listing) listing).getPropertyType())) {
                propertyTypes.add(((Listing) listing).getPropertyType());
            }
        }

        return propertyTypes;
    }

    @Override
    public Collection<String> getRoomType(Collection<IListing> listings) {
        Set<String> roomTypes = new TreeSet<>();

        for (IListing listing : listings) {
            if (!roomTypes.contains(((Listing) listing).getRoomType())) {
                roomTypes.add(((Listing) listing).getRoomType());
            }
        }

        return roomTypes;
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

    /**
     * Return the neighbors ids of a specific node
     * 
     * @param id the id of the page
     * @return the array of neighbor(s)
     */
    @Override
    public int[] getNeighbors(Graph g, int id) {
        return g.neighbors(id);
    }

    @Override
    public Graph makeGraph(Collection<IListing> allListings) {
        Graph gComp = new GraphL();
        gComp.init(allListings.size());

        for (int i = 0; i < allListings.size(); i++) {
            for (int j = 0; j < allListings.size(); j++) {

                int v = ((Listing) ((ArrayList<IListing>) allListings).get(i)).getId();
                int w = ((Listing) ((ArrayList<IListing>) allListings).get(j)).getId();

                if (v != w) {
                    gComp.addEdge(v, w, 1);
                    gComp.addEdge(w, v, 1);
                }
            }
        }

        return gComp;
    }

    @Override
    public Graph makeClique(IListing root, double maxDistance) {
        Graph gComp = makeGraph(allListings);
        int rootId = ((Listing) root).getId();

        // do bfs to delete edges and compute within the radius
        for (int i : getNeighbors(gComp, rootId)) {

                if (computeDistance(root,
                        ((Listing) ((ArrayList<IListing>) allListings).get(i))) > maxDistance) {
                    gComp.removeEdge(rootId, i);
                    gComp.removeEdge(i, rootId);
                }
        }
        return gComp;
    }
}
