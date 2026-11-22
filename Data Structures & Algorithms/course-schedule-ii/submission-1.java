class Solution {
    Set<Integer> cycle; // if we have a cycle in the current DFS. if we have seen this couse before
    List<Integer> res;
    Map<Integer, List<Integer>> adjList;
    Set<Integer> visited; // if we have ever visited this course

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.adjList = buildGraph(numCourses, prerequisites);
        this.visited = new HashSet<>();
        this.cycle = new HashSet<>();
        this.res = new ArrayList<>();

        for (int crs = 0; crs < numCourses; crs++) {
            if (!hasCycle(crs)) {
                return new int[] {};
            }
        }

return res.stream().mapToInt(i -> i).toArray();
    }

    public boolean hasCycle(int course) {

        // check if the current DFS has seen this course.
        if (cycle.contains(course)) {
            return false;
        }

        // check if we have seen the course below globally
        if (visited.contains(course)) {
            return true;
        }

        cycle.add(course);
        for (int preq : adjList.get(course)) {
            if (!hasCycle(preq)) {
                return false; // exit all the way back up.
            }
        }

        cycle.remove(course);// prune
        // add that we have visited this course.
        visited.add(course);
        res.add(course);

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
