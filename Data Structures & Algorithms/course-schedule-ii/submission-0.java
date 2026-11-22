class Solution {
    Set<Integer> res;
    Map<Integer, List<Integer>> adjList;
    Set<Integer> visited;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.res = new LinkedHashSet<>();
        this.adjList = buildGraph(numCourses, prerequisites);
        this.visited = new HashSet<>();

        for (int crs = 0; crs < numCourses; crs++) {
            if (!hasCycle(crs)) {
                return new int[] {};
            }
            res.add(crs);
        }
        // List<Integer> temp
        return List.copyOf(res).stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean hasCycle(int course) {
        if (adjList.get(course).isEmpty()) {
            return true;
        }
        if (visited.contains(course)) {
            return false;
        }
        visited.add(course);
        for (int preq : adjList.get(course)) {
            if (!hasCycle(preq)) {
                return false; // exit all the way back up.
            }
            res.add(preq);
        }
        // when we finish exploring a course preqs, we remove them from its adj List
        adjList.put(course, new ArrayList<>());
        visited.remove(course);

        return true;
    }

    public Map<Integer, List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int course = 0; course < numCourses; course++) {
            adjList.put(course, new ArrayList<>());
        }

        // build adj list
        for (int[] preq : prerequisites) {
            int course = preq[0];
            int preCrs = preq[1];

            adjList.get(course).add(preCrs);
        }

        return adjList;
    }
}
