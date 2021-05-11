# CIT 594 Final Project: Airbnb Search Engine

## Overview
#### This project is the capstone installment to the Spring 2021 CIT 594 course. In this program, we use Kaggle-provided [Airbnb listings](https://www.kaggle.com/jeploretizo/san-francisco-airbnb-listings) in San Francisco, and provide booking recommendations for users based on their preferences. There are two components to this project.

## Part I: Preference-Based Recommendation Engine
#### 
In Part I of our simulation, we will ask users a series of questions based on their living preferences to provide tailored reommendations. Specifically, we ask users to provide exact ranges and ideas of dwellings for the following six dimensions:

* Price
* Number of Reviews
* Distance from a popular "tourist location" (pre-selected as Fisherman's Wharf)
* Property Type
* Room Type
* Number of people a listing accommodates

We then ask the users to score these features 1-6, in order of importance to them (1 = most important, 6 = least important). These features are then matched against the Listings provided in the dataset and the top n that a user would like to see are displayed.

### Elements of CIT 594
#### 
Part I uses the following themes relevant to coursework:
* **File I/O** to read the dataset in as a buffered stream
* **Interfaces** for the Listing and Engine data types
* **Comparators** to sort and order recommended Listings by various dimensions
* **TreeSets** to sort the Property Types and Room Types by natural ordering (lexicographic)

## Part II: Listings within a Specifed Radius
#### 
In Part II of our simulation, we will show users "similar" listings within a specified distance of a user-selected listing. We first create a complete graph in adjacency list representation of the top 100 listings that met criteria in Part I, and then ask the user to select a Listing ID from this list and a max distance they would be willing to travel. We then traverse the graph using Breadth First Search and compute the [Haversine Distance](https://www.movable-type.co.uk/scripts/latlong.html) between two listings based on their latitude and logitude, and remove edges between two Listings if they are further apart than the max distance. The final list of nearby listings is displayed to the user.

### Elements of CIT 594
#### 
Part II uses the following themes relevant to coursework:
* **Comparators** to sort and order recommended Listings by various dimensions
* **Various Graph Representations** to store the Listings as vertices
* **Breadth First Search** to traverse the graph

## Part III: Class Diagram
####
Supplementary to our code, we provide a Class Diagram that displays the hierarchical and strategic relationships between our classes.

### Composite Design
Hierchical relationships are shown between IListing and Listing (aggregate, parent-child relationship), IEngine and Engine, and Graph and GraphL. We show a one-to-one relationship between Engine and Listing, one-to-one relationship between Engine and Graph, one-to-one relationship between SearchEngineRunner and Engine, and one-to-many relationship between GraphL and Edge.

### Strategy Design
A Strategy relationship is shown in the Listing class for a Collection of ways to sort a Collection of Lisitng objects (ListingComparison). We implement Comparators in three different ways:
* Lexicographic, or the natural ordering based on Listing name
* Descending order, by computed score in Part I
* Distance order, by the haversine distance between two listings in Part II

## Part IV: Unit Testing
####
JUnit tests are provided for the Listing and Engine classes.
