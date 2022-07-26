package View;

public enum Action {
    MOVE(0), ATTACK(1), OVERCHARGE(2), SPECIAL_ATTACK(3), SPIN(4), ARMED_ATTACK(5), CANCEL(6);

    int index;

    public int getIndex() {
        return index;
    }

    Action(int index) {
        this.index = index;
    }

}
