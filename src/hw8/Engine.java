package hw8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Engine class implementation
 * 
 * @author Tiffany Chen, Sarah Engheta, Sarah Shamsie
 *
 */
public class Engine implements IEngine {

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

    @Override
    public ArrayList<IListing> getListings(String fileName) {
        ArrayList<IListing> listings = new ArrayList<>();

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
                ((Listing) listing).setDistance(computeDistance(epicenter, listing));
                ((Listing) listing).setId(count++);

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
    public Collection<IListing> outputListings(ArrayList<IListing> listings, int topX) {
        Collections.sort(listings, IListing.byDescendingOrder());

        // if number of listings is less than the top X num, return all listings
        if (listings.size() < topX) {
            return listings;
        }

        // otherwise, add the top X listings to an arraylist
        List<IListing> outputList = new ArrayList<IListing>();

        for (int i = 0; i < topX; i++) {
            outputList.add(listings.get(i));
        }

        return outputList;
    }

    @Override
    public void printListings(ArrayList<IListing> listings) {

        // print lisitngs using toString method
        for (int i = 0; i < listings.size(); i++) {
            System.out.println(listings.get(i).toString());
        }
    }

    @Override
    public Collection<String> getPropertyType(ArrayList<IListing> listings) {
        Set<String> propertyTypes = new TreeSet<>();

        // return the unique list of property types
        for (IListing listing : listings) {
            Listing curr = (Listing) listing;
            if (!propertyTypes.contains(curr.getPropertyType())) {
                propertyTypes.add(curr.getPropertyType());
            }
        }
        return propertyTypes;
    }

    @Override
    public Collection<String> getRoomType(ArrayList<IListing> listings) {
        Set<String> roomTypes = new TreeSet<>();

        // return the unique list of room types
        for (IListing listing : listings) {
            Listing curr = (Listing) listing;
            if (!roomTypes.contains(curr.getRoomType())) {
                roomTypes.add(curr.getRoomType());
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

        // compute the distance in miles between two points
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
    private int[] getNeighbors(Graph g, int id) {
        return g.neighbors(id);
    }

    @Override
    public Graph makeGraph(ArrayList<IListing> listings) {
        Graph gComp = new GraphL();
        gComp.init(listings.size());

        // loop through the listings and create an undirected graph off of the
        // top x listings
        for (int i = 0; i < listings.size(); i++) {
            for (int j = 0; j < listings.size(); j++) {

                if (i != j) {
                    gComp.addEdge(i, j, 1);
                    gComp.addEdge(j, i, 1);
                }
            }
        }

        return gComp;
    }

    @Override
    public ArrayList<IListing> makeClique(ArrayList<IListing> listings, int id, double maxDistance,
            Graph gComp) {

        // get the new id for the listing based on the truncated list
        int rootId = 0;
        IListing root = null;

        for (int i = 0; i < listings.size(); i++) {
            Listing curr = (Listing) listings.get(i);
            if (curr.getId() == id) {
                rootId = i;
                root = curr;
                break;
            }
        }

        // do bfs to delete edges and compute within the radius
        for (int i : getNeighbors(gComp, rootId)) {

            if (computeDistance(root, (Listing) listings.get(i)) > maxDistance) {
                gComp.removeEdge(rootId, i);
                gComp.removeEdge(i, rootId);
            }
        }

        // loop through the neighbors of the listing and compute the distance
        ArrayList<IListing> radiusList = new ArrayList<>();

        for (int i : getNeighbors(gComp, rootId)) {

            // compute radius distance bw root and neighbor
            ((Listing) listings.get(i))
                    .setRadiusDist(computeDistance(root, (Listing) listings.get(i)));

            // add all neighbors to arraylist
            radiusList.add(listings.get(i));
        }
        Collections.sort(radiusList, IListing.byRadiusDistance());
        return radiusList;
    }

    @Override
    public Map<String, Integer> userRank(Scanner s) {
        Map<String, Integer> rankingMap = new HashMap<String, Integer>();

        rankingMap.put("Price", 0);
        rankingMap.put("Accommodates", 0);
        rankingMap.put("Property Type", 0);
        rankingMap.put("Room Type", 0);
        rankingMap.put("Number of Reviews", 0);
        rankingMap.put("Distance", 0);

        for (Map.Entry<String, Integer> entry : rankingMap.entrySet()) {
            System.out.println("Enter ranking (1-6) for: " + entry.getKey());

            int rank = s.nextInt();
            boolean badInput = rankingMap.containsValue(rank) || (rank < 1) || (rank > 6);

            while (badInput) {

                if (rankingMap.containsValue(rank)) {
                    System.out.println(
                            "You've already used this rank for another feature. Please enter another number 1-6:");
                    rank = s.nextInt();
                    badInput = rankingMap.containsValue(rank) || (rank < 1) || (rank > 6);
                } else if ((rank < 1) || (rank > 6)) {
                    System.out.println("Invalid Rank. Please enter another number 1-6:");
                    rank = s.nextInt();
                    badInput = rankingMap.containsValue(rank) || (rank < 1) || (rank > 6);
                }
            }
            rankingMap.put(entry.getKey(), rank);

        }
        return rankingMap;
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
}
