package AZStriverPlaylist.Graph.TopologicalSort;

import java.util.*;
import java.util.stream.Collectors;

public class AlienDictionary {

    public static String findOrder(String[] words) {
        List<Integer>[] graph = new List[26];
        for(int i=0;i<26;i++) graph[i] = new ArrayList<>();
        boolean[] present = new boolean[26];

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                present[ch - 'a'] = true;
            }
        }

        // Build graph
        for (int i = 0; i < words.length - 1; i++) {

            String first = words[i];
            String second = words[i + 1];

            int len = Math.min(first.length(), second.length());

            int j = 0;
            while (j < len && first.charAt(j) == second.charAt(j)) {
                j++;
            }

            // Invalid case:
            // ["abcd", "ab"]
            if (j == len) {
                if (first.length() > second.length()) {
                    return "";
                }
                continue;
            }

            int u = first.charAt(j) - 'a';
            int v = second.charAt(j) - 'a';

            // Avoid duplicate edges
            if (!graph[u].contains(v)) {
                graph[u].add(v);
            }
        }

        int[] topoSortResult = kahnsTopoSort(26, graph);
        return Arrays.stream(topoSortResult).filter(a->present[a]).mapToObj(i -> String.valueOf((char) ('a' + i))).collect(Collectors.joining());
    }

    public static int[] kahnsTopoSort(int V, List<Integer>[] adj) {
        int[] indegree = new int[V];
        int[] result = new int[V];
        Queue<Integer> queue = new LinkedList<>();

        for(List<Integer> edge: adj){
            edge.forEach(a->indegree[a]++);
        }

        for(int i=0;i<V;i++){
            if(indegree[i]==0) queue.add(i);
        }

        int i=0;
        while(!queue.isEmpty()){
            Integer vertex = queue.poll();
            result[i++] = vertex;
            for(Integer neighbour : adj[vertex]){
                indegree[neighbour]--;
                if(indegree[neighbour]==0) queue.add(neighbour);
            }
        }

        if (i != V){
            return new int[]{};
        }

        return result;
    }

    public static void main(String[] args) {
        String words[] = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(findOrder(words));
        System.out.println("---------------------------------------");
        String words1[] = {"caa", "aaa", "aab"};
        System.out.println(findOrder(words1));
        System.out.println("---------------------------------------");
        String words2[] = {"ab", "cd", "ef", "ad"};
        System.out.println(findOrder(words2));
        System.out.println("---------------------------------------");
    }
}
