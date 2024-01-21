package enum_ops;// Demo of Enum methods

public enum Operation {

    ADD {
        public Integer apply(Integer val1, Integer val2) {
            return val1 + val2;
        }
    },

    SUBTRACT {
        public Integer apply(Integer val1, Integer val2) {
            return val1 - val2;
        }
    };

    public abstract Integer apply(Integer val1, Integer val2);
}
