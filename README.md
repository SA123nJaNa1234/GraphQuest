# 🚀 Graph Visualizer

An interactive **Java-based Graph Visualization tool** that demonstrates multiple graph traversal and pathfinding algorithms in real-time using intuitive color coding and animations.

---

## 📌 Overview

This project visually explains how different graph algorithms work by showing step-by-step execution on a graph.
It is designed to improve understanding of traversal and shortest-path algorithms through interactive visualization.

---

## 🎯 Features

* 🔍 Real-time visualization of graph algorithms
* 🌐 Supports multiple algorithms:

  * Breadth First Search (BFS)
  * Depth First Search (DFS)
  * Dijkstra’s Algorithm
  * A* (A-Star) Algorithm
  * Greedy Best-First Search
* 🎨 Color-based node state representation
* 🖥️ Interactive UI using Java Swing
* ⚡ Step-by-step execution

---

## 🎨 Node Color Representation

| Color    | Meaning        |
| -------- | -------------- |
| 🟢 Green | Unvisited Node |
| 🔵 Blue  | Visited Node   |
| 🔴 Red   | Goal Node      |

---

## 🧠 Algorithms Implemented

### 🔹 BFS (Breadth First Search)

* Explores nodes level by level
* Uses a Queue
* Guarantees shortest path in unweighted graphs

### 🔹 DFS (Depth First Search)

* Explores as deep as possible
* Uses Stack / Recursion
* Not guaranteed shortest path

### 🔹 Dijkstra’s Algorithm

* Finds shortest path in weighted graphs
* Uses Priority Queue
* Guarantees optimal path

### 🔹 A* (A-Star) Algorithm

* Uses heuristic + cost
* Faster than Dijkstra in many cases
* Widely used in games and navigation systems

### 🔹 Greedy Best-First Search

* Chooses node closest to goal (heuristic only)
* Fast but not always optimal

---

## 🖥️ Tech Stack

* **Language:** Java
* **GUI:** Swing
* **Concepts Used:**

  * Graph Data Structures
  * Priority Queue
  * Heuristics (A*)
  * Object-Oriented Programming

---

## 🎥 Demo



[▶ Watch Demo](demo.mp4)


---

## 📂 Project Structure

```
src/
 ├── algorithms/     # BFS, DFS, Dijkstra, A*, Greedy
 ├── graph/          # Graph, Node, Edge classes
 ├── ui/             # GUI components
```

---

## ⚙️ How to Run

1. Clone the repository

```
git clone https://github.com/your-username/your-repo-name.git
```

2. Open in VS Code / Eclipse

3. Run the main class

---

## 💡 Future Improvements

* Add weighted graph visualization controls
* Add maze/pathfinding scenarios
* Improve UI animations and transitions
* Add performance comparison between algorithms

---

## 🤝 Contributing

Contributions are welcome!
Feel free to fork this repo and submit a pull request.

---

## 📜 License

This project is open-source and available under the MIT License.

---

## ⭐ Acknowledgment

This project is built for learning and visualizing graph algorithms in an interactive way.
