package with_edge_weight;

public class Edge {
    private Integer src;
    private Integer dest;

    private Integer weight;

    public Edge(Integer src, Integer dest, Integer weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public Integer getSrc() {
        return src;
    }

    public void setSrc(Integer src) {
        this.src = src;
    }

    public Integer getDest() {
        return dest;
    }

    public void setDest(Integer dest) {
        this.dest = dest;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
