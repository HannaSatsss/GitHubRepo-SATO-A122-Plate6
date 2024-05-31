import java.util.*;

public class SATO_num7 {
    public static void main(String[] args) {
        Scanner satoSc = new Scanner(System.in);
        for (int satoA = 1; satoA <= 5; satoA++) {
            System.out.println("Test case " + satoA + ":");
            System.out.print("Enter the number of edges:");
            int satoNumEdges = satoSc.nextInt();
            int[][] satoEdges = new int[satoNumEdges][2];
            int[] satoOccurrences = new int[satoNumEdges];

            System.out.println("Enter the edges (format: node1 node2):");
            for (int satoB = 0; satoB < satoNumEdges; satoB++) {
                String satoVertex1 = satoSc.next();
                String satoVertex2 = satoSc.next();
                satoEdges[satoB][0] = satoVertex1.charAt(0) - 'A'; // Convert vertex labels to numeric representation
                satoEdges[satoB][1] = satoVertex2.charAt(0) - 'A';
            }

            System.out.println("Enter the occurrences of each edge:");
            for (int satoC = 0; satoC < satoNumEdges; satoC++) {
                satoOccurrences[satoC] = satoSc.nextInt();
            }

            testIncidenceMatrix(satoEdges, satoOccurrences);
            System.out.println();
        }
        satoSc.close();
    }
    private static int getMaxNode(int[][] sato_edges) {
        int sato_max = 0;
        for (int[] sato_edge : sato_edges) {
            for (int sato_node : sato_edge) {
                if (sato_node > sato_max) {
                    sato_max = sato_node;
                }
            }
        }
        return sato_max;
    }
    private static void testIncidenceMatrix(int[][] sato_edges, int[] sato_occurrences) {
        int satoC = getMaxNode(sato_edges) + 1;
        int satoD = sato_edges.length;
        int[][] satoMatrix = new int[satoC][satoD];

        for (int satoE = 0; satoE < satoD; satoE++) {
            int[] sato_edge = sato_edges[satoE];
            satoMatrix[sato_edge[0]][satoE] = sato_occurrences[satoE];
            satoMatrix[sato_edge[1]][satoE] = sato_occurrences[satoE];
        }
        // Print the incidence matrix
        System.out.println("Incidence Matrix:");
        for (int satoF = 0; satoF < satoC; satoF++) {
            for (int satoG = 0; satoG < satoD; satoG++) {
                System.out.print(satoMatrix[satoF][satoG] + " ");
            }
            System.out.println();
        }
    }
}