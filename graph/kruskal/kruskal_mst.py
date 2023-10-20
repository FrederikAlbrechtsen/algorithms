def kruskal_mst(graph):
    def find(parent, i):
        if parent[i] == i:
            return i
        else:
            return find(parent, parent[i])
    
    def union(parent, rank, x, y):
        xroot = find(parent, x)
        yroot = find(parent, y)
        if rank[xroot] < rank[yroot]:
            parent[xroot] = yroot
        elif rank[xroot] > rank[yroot]:
            parent[yroot] = xroot
        else:
            parent[yroot] = xroot
            rank[xroot] += 1
        
    graph = sorted(graph, key=lambda item: item[2])
    num_vertices = max(max(graph, key=lambda item: item[1])[1], max(graph, key=lambda item: item[0])[0]) + 1
    parent = [i for i in range(num_vertices)]
    rank = [0] * num_vertices
    result = []
    i, e = 0, 0

    while e < num_vertices - 1:
        u, v, w = graph[i]
        i += 1
        x = find(parent, u)
        y = find(parent, v)
        if x != y:
            e += 1
            result.append([u, v, w])
            union(parent, rank, x, y)

    return result

graph = [
    (0, 1, 2), (0, 2, 4), (0, 3, 1), (1, 3, 3), (1, 4, 10),
    (2, 3, 2), (2, 5, 5), (3, 4, 7), (3, 5, 8), (4, 5, 6)
]
kruskal_result = kruskal_mst(graph)

print("Minimum Spanning Tree Edges found by Kruskal's Algorithm:")
for u, v, w in kruskal_result:
    print(f"{u} - {v}: {w}")

