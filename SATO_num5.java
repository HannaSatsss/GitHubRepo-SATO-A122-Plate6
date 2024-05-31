import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
public class SATO_num5 {
    int satoRed = 1;
    int satoBlue = 2;
    int satoNotVisited = 0;
    public boolean satoCheck(Map<String, List<String>> satoGraph) {
        Map<String, Integer> satoTable = new HashMap<>();
        Queue<String> satoQueue = new LinkedList<>();
        for (String satoNode : satoGraph.keySet()) {
            if (satoTable.containsKey(satoNode)) continue;
            satoQueue.add(satoNode);
            satoTable.put(satoNode, satoBlue);
            while (!satoQueue.isEmpty()) {
                String satoFirst = satoQueue.poll();
                List<String> satoConnect = satoGraph.get(satoFirst);
                int satoCurrentColor = satoTable.get(satoFirst);
                int satoTargetColor = satoCurrentColor == satoRed ? satoBlue : satoRed;
                for (String satoNeighbor : satoConnect) {
                    if (satoTable.getOrDefault(satoNeighbor, satoNotVisited) == satoCurrentColor)
                    	return false;
                    if (!satoTable.containsKey(satoNeighbor)) {
                        satoQueue.add(satoNeighbor);
                        satoTable.put(satoNeighbor, satoTargetColor);
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
    	SATO_num5 satoBipart = new SATO_num5();
        List<String> satoFileNames = Arrays.asList("test1_num5.txt", "test2_num5.txt",
        		"test3_num5.txt","test4_num5.txt","test5_num5.txt");

        for (String satoFileName : satoFileNames) {
            try {
                Map<String, List<String>> satoGraph = readGraphFromFile(satoFileName);
                boolean satoResult = satoBipart.satoCheck(satoGraph);
                System.out.println("Graph from " + satoFileName + " is " + 
                (satoResult ? "bipartite.\n\n\n" : "not bipartite.\n\n\n"));
            } catch (IOException satoE) {
                System.out.println("Error reading file " + satoFileName);
                satoE.printStackTrace();
            }
        }
    }
    private static Map<String, List<String>> readGraphFromFile(String satoFileName)
    		throws IOException {
    	Map<String, List<String>> satoGraph = new HashMap<>();
        List<String> satoLines = Files.readAllLines(Paths.get(satoFileName));
        
        System.out.println("The edges of the graph:");
        for (String satoLine : satoLines) {
            String[] satoParts = satoLine.split(" ");
            if (satoParts.length == 2) {
                String satoVertex1 = satoParts[0];
                String satoVertex2 = satoParts[1];
                System.out.println("("+satoVertex1+","+satoVertex2+")");
                satoGraph.computeIfAbsent(satoVertex1, k -> new ArrayList<>()).add(satoVertex2);
                satoGraph.computeIfAbsent(satoVertex2, k -> new ArrayList<>()).add(satoVertex1);
            }
        }
        System.out.println();
        return satoGraph;
    }
}
