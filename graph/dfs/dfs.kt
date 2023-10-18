fun dfs(graph: Map<String, List<String>>, node: String, visited: MutableSet<String>) {
    if (node !in visited) {
        print("$node ")
        visited.add(node)
        for (neighbor in graph[node] ?: emptyList()) {
            dfs(graph, neighbor, visited)
        }
    }
}

// Example usage
fun main() {
    val graph = mapOf(
        "A" to listOf("B", "C"),
        "B" to listOf("A", "D", "E"),
        "C" to listOf("A", "F"),
        "D" to listOf("B"),
        "E" to listOf("B", "F"),
        "F" to listOf("C", "E")
    )
    
    val visited = mutableSetOf<String>()
    dfs(graph, "A", visited)
}
