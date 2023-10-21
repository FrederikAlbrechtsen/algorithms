def floyd_warshall(graph):
    V = len(graph)
    
    dist = [row[:] for row in graph]
    
    for k in range(V):
        for i in range(V):
            for j in range(V):
                if dist[i][j] > dist[i][k] + dist[k][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]
    
    return dist

INF = float('inf')
graph = [
    [0, 3, INF, 7, INF],
    [8, 0, 2, INF, INF],
    [5, INF, 0, 1, 4],
    [2, INF, INF, 0, 1],
    [6, 2, INF, INF, 0]
]

result = floyd_warshall(graph)
for row in result:
    print(row)
