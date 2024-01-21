public class Edge {
    private Integer src;
    private Integer dest;

    public Edge(Integer src, Integer dest) {
        this.src = src;
        this.dest = dest;
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
}