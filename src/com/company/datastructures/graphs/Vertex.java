package com.company.datastructures.graphs;

public class Vertex <T> {

    public T label; // Label of the object
    private boolean visited; // If the object is visited or not

    // Constructor
    public Vertex(T label) {
        this.label = label;
        this.visited = false;
    }

    // Methhods
    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label=" + label +
                '}'+"\n";
    }


// equals and hashCode
}
