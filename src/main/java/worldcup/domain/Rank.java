package worldcup.domain;

public enum Rank {

    FIRST("1위"),
    SECOND("2위"),
    THIRD("3위"),
    FOURTH("4위");

    private final String rank;

    Rank(String rank){
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }
}
