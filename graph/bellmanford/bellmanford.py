def bellman_ford(G: list, s: int) -> list:
    """
    The Bellman-Ford algorithm solves the single-source shortest-paths problem 
    in the general case in which edge weights may be negative.

    :param G: A weighted directed graph
    :param s: The source
    :return: The found solution
    """   
    distance = [float('inf')] * len(G)
    distance[s] = 0
    for _ in range(len(G) - 1):
        for u, v, w in G:
            if distance[u] + w < distance[v]:
                distance[v] = distance[u] + w
    for u, v, w in G:
        if distance[u] + w < distance[v]:
            print("G contains negative weight cycle")
            return
    return distance
    
if __name__ == '__main__':
    G = [(0, 1, -1),
            (0, 2, 4),
            (1, 2, 3),
            (1, 3, 2),
            (1, 4, 2),
            (3, 2, 5),
            (3, 1, 1),
            (4, 3, -3)]
    for i in range(0,5):
        print(f"Vertex {i}, distanceance from source: ", bellman_ford(G, 0)[i])