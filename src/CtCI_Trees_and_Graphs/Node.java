package CtCI_Trees_and_Graphs;

public class Node {
	private Node[] adjacent;
	public int adjacentCount;
	private String vertex;
	public routeBetweenNodes_4_1.State state;

	public Node(String vertex, int adjacentLength) {
		this.vertex = vertex;
		adjacentCount = 0;
		adjacent = new Node[adjacentLength];
	}

	public void addAdjacent(Node x) {
		if (adjacentCount < adjacent.length) {
			adjacent[adjacentCount] = x;
			adjacentCount++;
		} else {
			System.out.println("No more adjacent could be added");
		}
	}

	public Node[] getAdjacent() {
		return adjacent;
	}

	public String getVertex() {
		return vertex;
	}
}
