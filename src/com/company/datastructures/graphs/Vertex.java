package com.company.datastructures.graphs;

public class Vertex <T> {

    public T label;
    private boolean visited;

    public Vertex(T label) {
        this.label = label;
        this.visited = false;
    }

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
