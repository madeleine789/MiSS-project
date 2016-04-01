package pl.edu.agh.miss.intruders.model.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Node {
    public final static double DEFAULT_PROBABILITY = 0.01;
    private String nodeId;
    private List<Edge> incidentEdges = new ArrayList<>();

    public Node(String nodeId) {
        this.nodeId = nodeId;
    }

    public List<Edge> getIncidentEdges() {
        return incidentEdges;
    }

    public void setIncidentEdges(List<Edge> incidentEdges) {
        this.incidentEdges = incidentEdges;
    }

    public String getNodeId() {
        return nodeId;
    }

    public boolean deleteEdge(String from, String to) {
        Optional<Edge> edgeOp = incidentEdges.stream().filter(
                e -> Objects.equals(e.getNodeFromId(), from) && Objects.equals(e.getNodeToId(), to)
        ).findFirst();
        if (edgeOp.isPresent()) {
            incidentEdges.remove(edgeOp.get());
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t").append(getNodeId()).append("\n");
        getIncidentEdges().forEach(edge -> sb.append("\t\t").append(edge.toString()).append("\n"));
        return sb.toString();
    }

}

