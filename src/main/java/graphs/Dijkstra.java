package graphs;
import java.util.*;
import java.util.stream.Collectors;

public class Dijkstra {
    public static class Node {
        int id;
        int distance;

        Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof Node)) {
                return false;
            } else {
                Node n = (Node) o;
                return this.id == n.id && this.distance == n.distance;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, distance);
        }
    }

    public static class Tuple {
        int value;
        boolean checked;

        public Tuple(int value, boolean checked) {
            this.value = value;
            this.checked = checked;
        }
    }


    private static class AdjacencyListGraph {

        public Map<Node, ArrayList<Node>> adjacencyList = new HashMap<>();

        public void addVertex(Node n, ArrayList<Node> neighbours) {
            adjacencyList.put(n, neighbours);
        }

        public void showGraph() {
            adjacencyList.entrySet().stream().forEach(entry -> {
                System.out.println("node " + entry.getKey().id + " " + "adjacent list" + entry.getValue().stream().map(node -> node.id).collect(Collectors.toList()));
            });
        }
    }


    private static int minDistanceIndex(Tuple d[]) {
        int min = 0;
        for (int i = 0; i < d.length; i++) {
            if (!d[i].checked) {
                min = d[i].value;
                break;
            }//else all checked
        }
        int min_index = 0;
        for (int i = 0; i < d.length; i++) {
            if ((!d[i].checked) && d[i].value <= min) {
                min = d[i].value;
                min_index = i;
            }
        }
        return min_index;
    }

    private static void dijkstry(Map<Node, ArrayList<Node>> graph, Node start) {
        Set<Integer> Q = graph.keySet().stream().map(node -> node.id).collect(Collectors.toSet());

        Tuple[] d = new Tuple[graph.size()];
        int[] p = new int[graph.size()];
        // for each vertex in graph, set initial values d[infinity], p[-1/undefined]
        for (int i = 0; i < graph.size(); i++) {
            d[i] = new Tuple(Integer.MAX_VALUE, false);
            p[i] = -1;
        }
        d[start.id].value = 0;

        while (!Q.isEmpty()) {
            int u = minDistanceIndex(d);
            graph.get(new Node(u, 0)).forEach(neighbour -> {
                if (d[neighbour.id].value > neighbour.distance + d[u].value) {
                    d[neighbour.id].value = neighbour.distance + d[u].value;
                    d[u].checked = true;

                    p[neighbour.id] = u;
                }
            });
            Q.remove(u);
        }

    }

    public static void main(String[] args) {
        AdjacencyListGraph agl = new AdjacencyListGraph();

        ArrayList<Node> node0_neighbours = new ArrayList<>();
        node0_neighbours.add(new Node(1, 3));
        node0_neighbours.add(new Node(4, 3));
        agl.addVertex(new Node(0, 0), node0_neighbours);

        ArrayList<Node> node1_neighbours = new ArrayList<>();
        node1_neighbours.add(new Node(2, 1));
        agl.addVertex(new Node(1, 0), node1_neighbours);

        ArrayList<Node> node2_neighbours = new ArrayList<>();
        node2_neighbours.add(new Node(3, 3));
        node2_neighbours.add(new Node(5, 1));
        agl.addVertex(new Node(2, 0), node2_neighbours);

        ArrayList<Node> node3_neighbours = new ArrayList<>();
        node3_neighbours.add(new Node(1, 3));
        agl.addVertex(new Node(3, 0), node3_neighbours);

        ArrayList<Node> node4_neighbours = new ArrayList<>();
        node4_neighbours.add(new Node(5, 2));
        agl.addVertex(new Node(4, 0), node4_neighbours);

        ArrayList<Node> node5_neighbours = new ArrayList<>();
        node5_neighbours.add(new Node(0, 6));
        node5_neighbours.add(new Node(3, 1));
        agl.addVertex(new Node(5, 0), node5_neighbours);

        // draw graph
        agl.showGraph();
        // run algorithm
        // parameters: graph_representation, start_vertex(id_0, self_distance so 0)
        dijkstry(agl.adjacencyList, new Node(0, 0));
    }

}
