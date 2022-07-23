package Model.AbstractModel;

public abstract class MachineRadioactiveEntity {

    private int health;
    private int attackPoints;
    private int attackDistance;
    private int moveSpan;
    private int radRadius;
    private Armor[] armors = new Armor[4];;

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

    public int getRadRadius() {
        return radRadius;
    }

    public void setRadRadius(int radRadius) {
        this.radRadius = radRadius;
    }

    public Armor[] getArmors() {
        return armors;
    }

    public void setArmors(Armor[] armors) {
        this.armors = armors;
    }

}
