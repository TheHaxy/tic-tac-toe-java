public enum Symbol {
    X("X"),
    O("O"),

    Null("-");

    private final String value;

    private Symbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

