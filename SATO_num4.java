import java.io.*;
import java.util.*;
public class SATO_num4 {
    public static void main(String[] args) {
        List<String[]> sato_edges = new ArrayList<>();

        String[] sato_fileNames = {"sato_pairs1_num4.txt","sato_pairs2_num4.txt","sato_pairs3_num4.txt"
        		,"sato_pairs4_num4.txt", "sato_pairs5_num4.txt"};
        int sato_graphNumber = 1; // Initialize graph number
        for (String sato_fileName : sato_fileNames) {
            try (BufferedReader satoRead = new BufferedReader(new FileReader(sato_fileName))) {
                String sato_line;
                System.out.println("Vertex pairs in graph " + sato_graphNumber + ":\n");
                while ((sato_line = satoRead.readLine()) != null) {
                    String[] sato_parts = sato_line.split(" ");
                    String sato_vertex1 = sato_parts[0];
                    String sato_vertex2 = sato_parts[1];
                    sato_edges.add(new String[]{sato_vertex1, sato_vertex2});
                    System.out.println("("+sato_vertex1 + "," + sato_vertex2+")");
                }

                // Call the method to compute vertex degrees
                Map<String, Integer> sato_degrees =  satoDegrees(sato_edges);

                // Print the degree of each vertex
                System.out.println("\nVertex Degrees in graph " + sato_graphNumber + ":");
                for (Map.Entry<String, Integer> satoEntry : sato_degrees.entrySet()) {
                    System.out.println("deg(" + satoEntry.getKey() + ")= " + satoEntry.getValue());
                }
                System.out.println("\n\n\n\n");

                // Clear the edges list for the next graph
                sato_edges.clear();
                sato_graphNumber++;

            } catch (IOException satoE) {
                satoE.printStackTrace();
            }
        }
    }

    public static Map<String, Integer> satoDegrees(List<String[]> satoEdges) {
        Map<String, Integer> satoDegreeMap = new HashMap<>();

        // Iterate over each edge
        for (String[] satoEdge : satoEdges) {
            String satoVertex1 = satoEdge[0];
            String satoVertex2 = satoEdge[1];

            // Increment the degree for each vertex in the edge
            satoDegreeMap.put(satoVertex1, satoDegreeMap.getOrDefault(satoVertex1, 0) + 1);
            satoDegreeMap.put(satoVertex2, satoDegreeMap.getOrDefault(satoVertex2, 0) + 1);
        }

        return satoDegreeMap;
    }
}
