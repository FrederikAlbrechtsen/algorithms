#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

// Structure to represent an edge
struct Edge {
    int u, v, w;
};

// Function to perform Bellman-Ford algorithm
void bellmanFord(struct Edge* edges, int V, int E, int src) {
    int distance[V];
    for (int i = 0; i < V; i++) {
        distance[i] = INT_MAX;
    }
    distance[src] = 0;

    // Relax all edges V-1 times
    for (int i = 1; i <= V - 1; i++) {
        for (int j = 0; j < E; j++) {
            int u = edges[j].u;
            int v = edges[j].v;
            int weight = edges[j].w;
            if (distance[u] != INT_MAX && distance[u] + weight < distance[v]) {
                distance[v] = distance[u] + weight;
            }
        }
    }

    // Check for negative-weight cycles
    for (int i = 0; i < E; i++) {
        int u = edges[i].u;
        int v = edges[i].v;
        int weight = edges[i].w;
        if (distance[u] != INT_MAX && distance[u] + weight < distance[v]) {
            printf("Graph contains a negative weight cycle\n");
            return;
        }
    }

    // Print the distances from the source
    for (int i = 0; i < V; i++) {
        printf("Vertex %d, distance from source: %d\n", i, distance[i]);
    }
}

int main() {
    int V = 5; // Number of vertices
    int E = 8; // Number of edges
    struct Edge edges[] = {{0, 1, -1}, {0, 2, 4}, {1, 2, 3}, {1, 3, 2}, {1, 4, 2}, {3, 2, 5}, {3, 1, 1}, {4, 3, -3}};
    int source = 0; // Source vertex

    bellmanFord(edges, V, E, source);

    return 0;
}
