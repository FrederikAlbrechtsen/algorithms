function bellmanFord(G, s) {
    const n = G.length;
    const distance = new Array(n).fill(Infinity);
    distance[s] = 0;

    for (let i = 0; i < n - 1; i++) {
        for (const [u, v, w] of G) {
            if (distance[u] + w < distance[v]) {
                distance[v] = distance[u] + w;
            }
        }
    }

    for (const [u, v, w] of G) {
        if (distance[u] + w < distance[v]) {
            console.log("Graph contains a negative weight cycle");
            return [];
        }
    }

    return distance;
}

const G = [[0, 1, -1], [0, 2, 4], [1, 2, 3], [1, 3, 2], [1, 4, 2], [3, 2, 5], [3, 1, 1], [4, 3, -3]];
const result = bellmanFord(G, 0);

for (let i = 0; i < 5; i++) {
    console.log(`Vertex ${i}, distance from source: ${result[i]}`);
}