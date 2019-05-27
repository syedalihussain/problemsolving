package CtCI_Trees_and_Graphs;

import java.util.LinkedList;

public class routeBetweenNodes_4_1 {
	enum State {Unvisited, Visited; }

	public static boolean search(Graph g, Node start, Node end) {
		if (start == end) return true;
		LinkedList<Node> unvisited = new LinkedList<>();
		LinkedList<Node> visited = new LinkedList<>();

		unvisited.push(start);
		while(!unvisited.isEmpty()) {
			Node n = unvisited.removeFirst();
			Node[] adjacentNodes = n.getAdjacent();
			for (Node node : adjacentNodes) {
				if (node.getVertex() == end.getVertex())
					return true;
				unvisited.push(node);
			}
			visited.push(n);
		}
		return false;
	}

	public static Graph createNewGraph() {
		Graph g = new Graph();
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}

	public static void main(String[] args) {
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[3];
		Node end = n[5];
		System.out.println(search(g, start, end));
	}
}
