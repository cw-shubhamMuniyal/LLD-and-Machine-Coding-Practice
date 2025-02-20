package models;

public enum CoinType {

    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100);

    public Integer getDenonimation() {
        return denonimation;
    }

    private final Integer denonimation;

    CoinType(Integer denonimation) {
        this.denonimation = denonimation;
    }


}
