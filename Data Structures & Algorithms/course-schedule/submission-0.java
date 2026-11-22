/**
Toplogical sort. course b must be done before course a. (directed graph)
1. build graph
2. detect cycle

*/
class Solution {
    Map<Integer, List<Integer>> adjList;
    Set<Integer> visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.adjList = buildGraph(numCourses, prerequisites);
        this.visited = new HashSet<>();

        // next detect a cycle
        for (int course =0; course < numCourses; course++){
            // we only run dfs why the adjList is not empty(meaning there are preq courses for the course)
            if (!adjList.get(course).isEmpty() &&!hasCycle(course)){
                return false;
            }

        }

        return true;
    }

    public boolean hasCycle(int course){

        if (adjList.get(course).isEmpty()){
            return true;// no preq (or we resolved them)
        }
        if (visited.contains(course)){
            return false;
        }

        visited.add(course);
        for (int preq : adjList.get(course)){
            if (!hasCycle(preq)){
                return false;// exit all the way back up.
            }
        }
        // when we finish exploring a course preqs, we remove them from its adj List
        adjList.put(course, new ArrayList<>());
        visited.remove(course);

        return true;
    }
    public Map<Integer, List<Integer>> buildGraph(int numCourses,int[][] preqs) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        // Step 1: Initialize every course
        for (int course = 0; course < numCourses; course++) {
            adjList.put(course, new ArrayList<>());
        }

        // Step 2: Add prerequisite edges
        for (int[] preq : preqs) {
            int dependentCourse = preq[0];
            int preqCourse = preq[1];
            adjList.computeIfAbsent(dependentCourse, k -> new ArrayList<>()).add(preqCourse);
        }

        return adjList;
    }
}
