package com.tugas;

import java.util.*;

public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList <Integer> ();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<Integer>();

        visited[startVertex] = true;
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            System.out.print(currentVertex + " ");

            LinkedList<Integer> adjacentVertices = adjacencyList[currentVertex];
            for (int adjacentVertex : adjacentVertices) {
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    stack.push(adjacentVertex);
                }
            }
        }
    }

    public void bfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<Integer>();

        visited[startVertex] = true;
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            LinkedList<Integer> adjacentVertices = adjacencyList[currentVertex];
            for (int adjacentVertex : adjacentVertices) {
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    queue.offer(adjacentVertex);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(4, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 6);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        System.out.println("DFS traversal:");
        graph.dfs(0);

        System.out.println("\nBFS traversal:");
        graph.bfs(0);
    }
}

