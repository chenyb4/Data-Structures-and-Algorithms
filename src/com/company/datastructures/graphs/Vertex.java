package com.company.datastructures.graphs;

public class Vertex <T> {

    public T label;

    Vertex(T label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label=" + label +
                '}'+"\n";
    }


// equals and hashCode
}
