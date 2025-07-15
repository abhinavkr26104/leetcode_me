import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list and in-degree array
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            adj[i] = new ArrayList<>();

        int[] inDegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            adj[prereq].add(course);   // prereq -> course
            inDegree[course]++;
        }

        // Topological Sort using Kahn's Algorithm
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;

            for (int neighbor : adj[curr]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0)
                    q.add(neighbor);
            }
        }

        // If all courses are visited, return true
        return count == numCourses;
    }
}
