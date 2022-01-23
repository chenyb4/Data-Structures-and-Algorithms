package com.company.prim;

public class MinimumSpanningTree {

    //The number of vertices in the graph
    private static final int V = 5;


    //finding the vertex witht he smallest key value
    public int minKey(int key[], Boolean mstSet[])
    {
        int min = Integer.MAX_VALUE, min_index = -1;
        //to compare and find min
        for (int v = 0; v < V; v++){
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }


    //to print the minimum spanning tree in parent[]
    public void printMST(int parent[], int graph[][])
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++){
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }


    //build the minimum spanning tree
    public void primMinimumSpanningTree(int graph[][])
    {
        //the built tree
        int parent[] = new int[V];
        // for getting minimum weight
        int key[] = new int[V];
        // vertices in the tree
        Boolean mstSet[] = new Boolean[V];

        //make all keys ultimately big
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick thd minimum key vertex from the set of vertices
            // not yet included in MST
            int u = minKey(key, mstSet);

            // Add the picked vertex to the MST Set
            mstSet[u] = true;

            for (int v = 0; v < V; v++)


                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        // print the constructed MST
        printMST(parent, graph);
    }




}
