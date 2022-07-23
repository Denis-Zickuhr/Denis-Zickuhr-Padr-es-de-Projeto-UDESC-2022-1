package Model.AbstractModel;

public enum Armor {
    Weak(-1), Neutral(0), Resistant(1);
    int value;

    Armor(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
