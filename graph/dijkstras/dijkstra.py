import heapq as hq

def dijkstra(G: dict, start: int) -> dict:
    """
    Dijkstra's algorithm is an algorithm for finding the shortest paths between nodes in a graph, 
    which may represent, e.g., road networks.

    :param G: A graph of nodes and distance between nodes
    :param start: Start is the index of the starting location
    :return: The found solution
    """
    distances = {vertex: float('inf') for vertex in G}
    distances[start] = 0
    heap = [(0, start)]
    while heap:
        (distance, current) = hq.heappop(heap)
        if distance > distances[current]:
            continue
        for neighbor, weight in G[current].items():
            distance = distances[current] + weight
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                hq.heappush(heap, (distance, neighbor))
    return distances

G = {
    'A': {'B': 5, 'D': 3, 'E': 12, 'F': 8},
    'B': {'A': 5, 'D': 1,},
    'C': {'E': 1, 'F': 13},
    'D': {'A': 3, 'B': 1, 'E': 1},
    'E': {'A': 10, 'C': 1, 'D': 1, 'F': 2},
    'F': {'A': 5, 'C': 13, 'E': 2},
}

print('Shortest distances', dijkstra(G, 'A'))