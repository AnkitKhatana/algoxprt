package famousAlgos.medium;

import util.Utils;

import java.util.*;

public class TopologicalSort {

    enum State {
        NEW , ACTIVE , COMPLETED , ABSENT
    }

    public static boolean postOrderDfs(int currentVertex , State[] vertexState , List<Integer>[] adjacencyList, List<Integer> postOrderTraversal) {
        vertexState[currentVertex] = State.ACTIVE;
        List<Integer> adjacentVertices = adjacencyList[currentVertex];
        if (adjacentVertices != null)
            for (int vertex : adjacentVertices) {
                if (vertexState[vertex] == State.NEW) {
                    if (postOrderDfs(vertex, vertexState, adjacencyList, postOrderTraversal))
                        return true;
                }
                else if (vertexState[vertex] == State.ACTIVE)
                    return true;
            }
        vertexState[currentVertex] = State.COMPLETED;
        if(vertexState[currentVertex] != State.ABSENT)
            postOrderTraversal.add(currentVertex);
        return false;
    }

    public static void initializeVertexState(State[] vertexState , List<Integer> jobs){
        for(int i=0; i<jobs.size(); i++)
            vertexState[jobs.get(i)] = State.NEW;
        for (int i=0; i<vertexState.length; i++)
            if(vertexState[i] == null)
                vertexState[i] = State.ABSENT;
    }

    public static void getAdjacencyList(List<Integer>[] adjacencyList, List<Integer[]> deps){
        for(Integer[] dep : deps){
            List<Integer> list = adjacencyList[dep[0]];
            if(list == null){
                list = new ArrayList<>();
                adjacencyList[dep[0]] = list;
            }
            list.add(dep[1]);
        }
    }
    public static List<Integer> topologicalSort(
            List<Integer> jobs, List<Integer[]> deps
    ) {
        // Write your code here.
        State[] vertexState = new State[jobs.size()+1];
        ArrayList<Integer> postOrderTraversal = new ArrayList<>();
        List<Integer>[] adjacencyList = new List[jobs.size()+1];

        initializeVertexState(vertexState , jobs);
        getAdjacencyList(adjacencyList,deps);

        boolean cycle = false;
        for(int i=0; i<vertexState.length; i++){
            if(vertexState[i] == State.NEW)
                cycle = postOrderDfs(i,vertexState,adjacencyList,postOrderTraversal);
            if(cycle)
                return new ArrayList<>();
        }

        List<Integer> topologicalOrder = new ArrayList<>();
        for(int i=postOrderTraversal.size()-1; i>=0; i--)
            topologicalOrder.add(postOrderTraversal.get(i));

        return topologicalOrder;
    }


    public static void main1(String[] args) {
        List<Integer> jobs = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        Integer[][] depsArray =
                new Integer[][] {{1, 2},  {2, 3},  {3, 4},  {4, 5},  {5, 6},  {6, 7},  {7, 8},  {8, 1}};
        List<Integer[]> deps = new ArrayList<Integer[]>();
        fillDeps(depsArray, deps);
        List<Integer> order = topologicalSort(jobs, deps);
        Utils.assertTrue(isValidTopologicalOrder(order, jobs, deps));
    }

    public static void main(String[] args) {
        List<Integer> jobs = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        Integer[][] depsArray =
                new Integer[][] {{1, 2}, {1, 3}, {3, 2}, {4, 2}, {4, 3}};
        List<Integer[]> deps = new ArrayList<Integer[]>();
        fillDeps(depsArray, deps);
        List<Integer> order = topologicalSort(jobs, deps);
        Utils.assertTrue(isValidTopologicalOrder(order, jobs, deps));
    }

    static void fillDeps(Integer[][] depsArray, List<Integer[]> deps) {
        for (Integer[] depArray : depsArray) {
            deps.add(depArray);
        }
    }

    static boolean isValidTopologicalOrder(
            List<Integer> order, List<Integer> jobs, List<Integer[]> deps
    ) {
        Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        for (Integer candidate : order) {
            for (Integer[] dep : deps) {
                if (candidate == dep[0] && visited.containsKey(dep[1])) return false;
            }
            visited.put(candidate, true);
        }
        for (Integer job : jobs) {
            if (!visited.containsKey(job)) return false;
        }
        return order.size() == jobs.size();
    }
}
