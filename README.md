# practice-graphs

A Java project for practicing graph algorithms and data structures. This repository contains implementations for graph representations, traversals, and foundational structures, organized for learning and experimentation.

## Project Structure

```
practice-graphs/
├── topic0_structure/        # Core graph structures (Node, Edge, Graph)
├── topic1_representation/   # Graph representations (Adjacency List/Matrix, Pair, Unit)
├── topic2_traversal/        # Traversal algorithms (BFS, DFS, GraphTraversal)
├── topic3_minimum_spanning_tree/ # (Placeholder for MST algorithms)
├── .vscode/                 # VS Code tasks and launch configs
├── .gitignore
└── README.md
```

## Key Features

- **Graph Representations**
  - Adjacency List (`topic1_representation/AdjList.java`)
  - Adjacency Matrix (`topic1_representation/AdjMat.java`)
- **Core Structures**
  - Node (`topic0_structure/Node.java`)
  - Edge (`topic0_structure/Edge.java`)
  - Graph (`topic0_structure/Graph.java`)
- **Graph Traversal Algorithms**
  - Breadth-First Search (`topic2_traversal/BFS.java`)
  - Depth-First Search (`topic2_traversal/DFS.java`)
  - Example runner (`topic2_traversal/GraphTraversal.java`)
- **Extensible for MST and other algorithms**

## How to Build & Run

### Prerequisites

- Java 11 or higher
- [VS Code](https://code.visualstudio.com/) (recommended for provided tasks/configs)

### Build

From the workspace root, run:

```sh
# Compile all Java files to 'out' directory
javac -d out topic1_representation/*.java topic0_structure/*.java topic2_traversal/*.java
```

Or use the VS Code build task:

- Open the Command Palette (`Cmd+Shift+P`)
- Run `Tasks: Run Build Task` and select `javac-build`

### Run

Use the provided launch configurations in VS Code:

- **GraphTraversal**: Runs graph traversal demos
- **GraphRepresentation**: Runs graph representation demos

Or run manually:

```sh
java -cp out topic2_traversal.GraphTraversal
java -cp out topic1_representation.GraphRepresentation
```

## Example Usage

- See `topic2_traversal/GraphTraversal.java` for sample graph construction and traversal.
- See `topic1_representation/GraphRepresentation.java` for adjacency list/matrix demos.

## Contributing

Feel free to fork and extend with new algorithms, tests, or optimizations!

## License

This project is for educational purposes.

---

**Note:** Directory/package names may differ from file paths. Adjust build/run commands if