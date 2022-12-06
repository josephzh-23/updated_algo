package Graph.Top_6;

import java.util.ArrayList;
import java.util.List;

class Course_Schedule4 {

    List<Integer>[] adj;
    boolean[] visited;
    boolean[] explored;

    public boolean canFinish(int numCourses, int[][] prerequisites){
        adj = new ArrayList[numCourses];

        // Initialize a new list for each node here
        for(int i = 0; i< numCourses; i++){
            adj[i] = new ArrayList<>();

        }
        visited = new boolean[numCourses];
        explored = new boolean[numCourses];

        // [1, 2]   ->    1: [2]
        for(int i= 0; i< prerequisites.length; i++){
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(isCyclic(i)){
                    return false;
                }
            }
        }
        return true;

    }
    boolean isCyclic(int i){

        visited[i] = true;
        for(Integer j: adj[i]){
            if(!visited[j]){
                if(isCyclic(j)){
                    return true;
                }
            }
            else if(!explored[j]){
                return true;
            }
        }
        explored[i] = true;
        return false;
    }
}

