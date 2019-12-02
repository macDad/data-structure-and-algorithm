package com.mac.dna.dijkstra;

import java.util.ArrayList;

public class Graph {
    private Node[] nodes;
    private int noOfNodes;
    private Edge[] edges;
    private int noOfEdges;

    public Graph(Edge[] edges) {
        this.edges = edges;

        //create all nodes ready to be update with the edges.
        this.noOfNodes = calculateNoOfNodes(edges);
        this.nodes = new Node[this.noOfNodes];

        for (int i = 0; i < this.noOfNodes; i++) {
            this.nodes[i] = new Node();
        }
        //add all the edges to the nodes, each edge added to two nods (to and from)
        this.noOfEdges = edges.length;

        for (int j = 0; j < this.noOfEdges; j++) {
            this.nodes[edges[j].getFromNodeIndex()].getEdges().add(edges[j]);
            this.nodes[edges[j].getToNodeIndex()].getEdges().add(edges[j]);

        }
    }

    private int calculateNoOfNodes(Edge[] edges) {
        int noOfNodesT = 0;
        for (Edge edge : edges) {
            if (edge.getToNodeIndex() > noOfNodesT)
                noOfNodesT = edge.getToNodeIndex();
            if (edge.getFromNodeIndex() > noOfNodesT)
                noOfNodesT = edge.getFromNodeIndex();
        }
        noOfNodesT++;
        return noOfNodesT;
    }

    public void calShortestDistances() {
        //node 0 as a source
        this.nodes[0].setDistanceFromSource(0);
        int nextNode = 0;
        //visit every node
        for (int i = 0; i < this.nodes.length; i++) {
            //loop around the edges of current node
            ArrayList<Edge> currentNodeEdges = this.nodes[nextNode].getEdges();

            for (int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++) {
                int neighbourIndex = currentNodeEdges.get(joinedEdge).getNeighbourIndex(nextNode);

                //only if not visited
                if (!this.nodes[neighbourIndex].isVisited()) {
                    int tentative = this.nodes[nextNode].getDistanceFromSource() + currentNodeEdges.get(joinedEdge).getLength();

                    if (tentative < nodes[neighbourIndex].getDistanceFromSource()) {
                        nodes[neighbourIndex].setDistanceFromSource(tentative);
                    }
                }
            }

            //all neighbours checked so node visited
            nodes[nextNode].setVisited(true);

            //next node must be with shortest distence
            nextNode = getNodeShortestDistanced();
        }
    }

    private int getNodeShortestDistanced() {
        int storedNodeIndex = 0;
        int storedDist = Integer.MAX_VALUE;

        for (int i = 0; i < this.nodes.length; i++) {
            int currentDist = this.nodes[i].getDistanceFromSource();

            if (!this.nodes[i].isVisited() && currentDist < storedDist) {
                storedDist = currentDist;
                storedNodeIndex = i;
            }
        }
        return storedNodeIndex;
    }


    //print result
    public void printResult() {
        String output = "Number of nodes :" + this.noOfNodes;
        output += "\nNumber of Edges :" + this.noOfEdges;
        for (int i = 0; i < this.nodes.length; i++) {
            output += ("\nThe Shortest distence from node 0 to node " + i + " is " + nodes[i].getDistanceFromSource());

        }
        System.out.println(output);
    }

    public Node[] getNodes() {
        return nodes;
    }

    public int getNoOfNodes() {
        return noOfNodes;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public int getNoOfEdges() {
        return noOfEdges;
    }
}
