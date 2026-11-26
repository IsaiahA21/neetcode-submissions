class Solution {
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }
        dfs("JFK");
        return res;
    }

    private void dfs(String src) {
        PriorityQueue<String> dests = adj.get(src);
        while (dests != null && !dests.isEmpty()) {
            dfs(dests.poll());
        }
        res.addFirst(src);
    }
}
