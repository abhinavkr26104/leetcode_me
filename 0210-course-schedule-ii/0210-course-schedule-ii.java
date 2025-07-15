class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            adj[i] = new ArrayList<>();

        int[] inDegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            adj[prereq].add(course);
            inDegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }

        int[] topo = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            topo[index++] = curr;

            for (int neighbor : adj[curr]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0)
                    q.add(neighbor);
            }
        }

        if (index == numCourses)
            return topo;

        return new int[0];
    }
}
