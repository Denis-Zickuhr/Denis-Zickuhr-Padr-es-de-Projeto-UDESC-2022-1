package View;

public enum Action {
    MOVE(0), ATTACK(1), OVERCHARGE(2), SPECIAL_MOVE(3), ARMED_ATTACK(4), CANCEL(5);

    int index;

    public int getIndex() {
        return index;
    }

    Action(int index) {
        this.index = index;
    }

}
