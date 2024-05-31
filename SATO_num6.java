import java.io.*;
import java.util.*;

public class SATO_num6 {
    public static void main(String[] args) {
        String[] satoFileNames = {"case1.txt","case2.txt","case3.txt","case4.txt","case5.txt"};  
        int satoA = 1;
        try {
            for (String satoFileName : satoFileNames) {
                BufferedReader satoReader = new BufferedReader(new FileReader(satoFileName));
                String satoLine;
                // Read the number of vertices
                satoLine = satoReader.readLine();
                int satoNumVertices = Integer.parseInt(satoLine.trim());
                // Initialize the adjacency matrix
                int[][] satoMatrix = new int[satoNumVertices][satoNumVertices];
                // To map vertex names to indices
                Map<String, Integer> satoVertexIndexMap = new HashMap<>();
                List<String> satoVertexNames = new ArrayList<>();
                int satoCurrentIndex = 0;
                // Read the edges
                while ((satoLine = satoReader.readLine()) != null) {
                    String[] satoVertex = satoLine.split(" ");
                    String satoSource = satoVertex[0];
                    String satoDestination = satoVertex[1];
                    // Map source vertex to index
                    if (!satoVertexIndexMap.containsKey(satoSource)) {
                        satoVertexIndexMap.put(satoSource, satoCurrentIndex);
                        satoVertexNames.add(satoSource);
                        satoCurrentIndex++;
                    }
                    // Map destination vertex to index
                    if (!satoVertexIndexMap.containsKey(satoDestination)) {
                        satoVertexIndexMap.put(satoDestination, satoCurrentIndex);
                        satoVertexNames.add(satoDestination);
                        satoCurrentIndex++;
                    }
                    int satoSourceIndex = satoVertexIndexMap.get(satoSource);
                    int satoDestinationIndex = satoVertexIndexMap.get(satoDestination);
                    satoMatrix[satoSourceIndex][satoDestinationIndex]++;
                    // For undirected graph, uncomment the following line
                    // satoMatrix[destinationIndex][sourceIndex]++;
                }
                satoReader.close();
                System.out.println("Adjacency Matrix " + satoA + ":");
                satoPrintMatrix(satoMatrix, satoVertexNames);
                System.out.println("\n\n");
                satoA++;
            }
        } catch (IOException satoE) {
            satoE.printStackTrace();
        }
    }

    private static void satoPrintMatrix(int[][] satoMatrix, List<String> satoVertexNames) {
        // Print the column headers
        System.out.print("  ");
        for (String satoName : satoVertexNames) {
            System.out.print(satoName + " ");
        }
        System.out.println();

        // Print the matrix with row headers
        for (int satoI = 0; satoI < satoMatrix.length; satoI++) {
            System.out.print(satoVertexNames.get(satoI) + " ");
            for (int satoJ = 0; satoJ < satoMatrix[satoI].length; satoJ++) {
                System.out.print(satoMatrix[satoI][satoJ] + " ");
            }
            System.out.println();
        }
    }
}
