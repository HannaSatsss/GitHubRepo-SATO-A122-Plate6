import java.util.*;

public class SATO_num8 {
    private static Map<Integer, List<Integer>> satoAdjList1;
    private static Map<Integer, List<Integer>> satoAdjList2;

    public static void main(String[] args) {
        Scanner satoSc = new Scanner(System.in);

        for (int satoA = 1; satoA <= 5; satoA++) {
            satoAdjList1 = new HashMap<>();
            satoAdjList2 = new HashMap<>();
            System.out.println("Test case " + satoA + ":");
            System.out.println("Enter the number of edges for the first graph:");
            int satoNumEdges1 = satoSc.nextInt();
            System.out.println("Enter the edges for the first graph (format: node1 node2):");
            for (int satoB = 0; satoB < satoNumEdges1; satoB++) {
                int satoC = satoSc.nextInt();
                int satoD = satoSc.nextInt();
                satoAdjList1.computeIfAbsent(satoC, k -> new ArrayList<>()).add(satoD);
                satoAdjList1.computeIfAbsent(satoD, k -> new ArrayList<>()).add(satoC);
            }

            System.out.println("Enter the number of edges for the second graph:");
            int satoNumEdges2 = satoSc.nextInt();
            System.out.println("Enter the edges for the second graph (format: node1 node2):");
            for (int satoB = 0; satoB < satoNumEdges2; satoB++) {
                int satoC = satoSc.nextInt();
                int satoD = satoSc.nextInt();
                satoAdjList2.computeIfAbsent(satoC, k -> new ArrayList<>()).add(satoD);
                satoAdjList2.computeIfAbsent(satoD, k -> new ArrayList<>()).add(satoC);
            }

            System.out.println("Are Isomorphic: " + areIsomorphic());
            System.out.println();
        }
        satoSc.close();
    }

    private static boolean areIsomorphic() {
        if (satoAdjList1.size() != satoAdjList2.size()) return false;
        Map<Integer, Integer> satoMapping = new HashMap<>();
        return isIsomorphic(new ArrayList<>(satoAdjList1.keySet()), new ArrayList<>(satoAdjList2.keySet()), satoMapping);
    }

    private static boolean isIsomorphic(List<Integer> satoNodes1, List<Integer> satoNodes2, Map<Integer, Integer> satoMapping) {
        if (satoNodes1.isEmpty() && satoNodes2.isEmpty()) return true;
        if (satoNodes1.size() != satoNodes2.size()) return false;

        int satoNode1 = satoNodes1.get(0);
        for (int satoNode2 : satoNodes2) {
            if (isValidMapping(satoNode1, satoNode2, satoMapping)) {
                satoMapping.put(satoNode1, satoNode2);
                List<Integer> satoNextNodes1 = new ArrayList<>(satoNodes1);
                List<Integer> satoNextNodes2 = new ArrayList<>(satoNodes2);
                satoNextNodes1.remove(Integer.valueOf(satoNode1));
                satoNextNodes2.remove(Integer.valueOf(satoNode2));
                if (isIsomorphic(satoNextNodes1, satoNextNodes2, satoMapping)) return true;
                satoMapping.remove(satoNode1);
            }
        }
        return false;
    }

    private static boolean isValidMapping(int satoNode1, int satoNode2, Map<Integer, Integer> satoMapping) {
        List<Integer> satoNeighbors1 = satoAdjList1.get(satoNode1);
        List<Integer> satoNeighbors2 = satoAdjList2.get(satoNode2);

        if (satoNeighbors1 == null || satoNeighbors2 == null) return false;

        for (int satoNeighbor1 : satoNeighbors1) {
            if (satoMapping.containsKey(satoNeighbor1)) {
                int satoNeighbor2 = satoMapping.get(satoNeighbor1);
                if (!satoNeighbors2.contains(satoNeighbor2)) return false;
            }
        }
        return true;
    }
}
