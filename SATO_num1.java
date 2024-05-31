import java.io.*;
import java.util.*;
public class SATO_num1 {
    private Map<String, List<String>> sato_map;
    public SATO_num1() {this.sato_map = new HashMap<>();}

    public void sato_addEdge(String sato_vertex1, String sato_vertex2) {
    	sato_map.computeIfAbsent(sato_vertex1, k -> new ArrayList<>()).add(sato_vertex2);
    	sato_map.computeIfAbsent(sato_vertex2, k -> new ArrayList<>()).add(sato_vertex1);
    }
    public boolean sato_isConnected() {
        Set<String> sato_visited = new HashSet<>();
        sato_dfs(sato_map.keySet().iterator().next(), sato_visited);
        return sato_visited.size() == sato_map.size();
    }

    private void sato_dfs(String sato_node, Set<String> sato_visited) {
        if (!sato_visited.contains(sato_node)) {
            sato_visited.add(sato_node);
            List<String> sato_neighbors = sato_map.get(sato_node);
            if (sato_neighbors != null) {
                for (String sato_neighbor : sato_neighbors) {
                	sato_dfs(sato_neighbor, sato_visited);
                }
            }
        }
    }
    public int sato_countConnected() {
        Set<String> sato_visited = new HashSet<>();
        int sato_count = 0;
        for (String sato_node : sato_map.keySet()) {
            if (!sato_visited.contains(sato_node)) {
            	sato_dfs(sato_node, sato_visited);
                sato_count++;
            }
        }
        return sato_count;
    }
    public static void main(String[] args) {
        SATO_num1 sato_graph = new SATO_num1();
        String[] sato_fileNames = {"sato_graph1_num1.txt","sato_graph2_num1.txt","sato_graph3_num1.txt",
                              "sato_graph4_num1.txt","sato_graph5_num1.txt"};
        int sato_graphNumber = 1; 
        for (String sato_fileName : sato_fileNames) {
            try (BufferedReader sato_reader = new BufferedReader(new FileReader(sato_fileName))) 
                {String sato_line;
                System.out.println("Edges in graph " + sato_graphNumber + ":\n");
                while ((sato_line = sato_reader.readLine()) != null) {
                    String[] sato_parts = sato_line.split(" ");
                    String sato_vertex1 = sato_parts[0];
                    String sato_vertex2 = sato_parts[1];
                    sato_graph.sato_addEdge(sato_vertex1, sato_vertex2);
                    System.out.println("{"+sato_vertex1 + "," + sato_vertex2+"}");
                }
                System.out.println("\nIs the graph connected?: " + sato_graph.sato_isConnected());
                System.out.println("Number of connected components: " + sato_graph.sato_countConnected() + "\n\n\n\n");
                sato_graph = new SATO_num1();
                sato_graphNumber++;    
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
