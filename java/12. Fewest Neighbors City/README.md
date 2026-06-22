# LeetCode 1334: Find the City With the Smallest Number of Neighbors at a Threshold Distance

### Problem Summary
Given a weighted, undirected graph of `n` cities, find the city that can reach the **fewest** number of other cities within a given `distanceThreshold`. If there is a tie, return the city with the **greatest** ID.

---

### 💡 Strategy & Complexity
We use the **Floyd-Warshall algorithm** to calculate the shortest path between all pairs of cities. It is perfectly optimized here due to the small constraint on cities (N <= 100).

* **Time Complexity:** O(N^3) 
* **Space Complexity:** O(N^2) 
---
