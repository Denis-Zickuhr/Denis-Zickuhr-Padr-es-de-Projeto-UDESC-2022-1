package Model.AbstractModel.AbstractMachine.BaseProduct;

import Model.AbstractModel.Armor;

public abstract class Machine {

    private int health;
    private int attackPoints;
    private int attackDistance;
    private int moveSpan;
    private Armor[] armors = new Armor[4];
    private String[] buffer;

    public String[] getBuffer() {
        return buffer;
    }

    public void setBuffer(String[] buffer) {
        this.buffer = buffer;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getAttackDistance() {
        return attackDistance;
    }

    public void setAttackDistance(int attackDistance) {
        this.attackDistance = attackDistance;
    }

    public int getMoveSpan() {
        return moveSpan;
    }

    public void setMoveSpan(int moveSpan) {
        this.moveSpan = moveSpan;
    }

    public Armor[] getArmors() {
        return armors;
    }

    public void setArmors(Armor[] armors) {
        this.armors = armors;
    }

}
