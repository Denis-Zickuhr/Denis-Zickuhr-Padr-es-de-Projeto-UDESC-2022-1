package Model.AbstractModel;

import Model.ConcreteModel.Adapter.MovementBehaviourAdapter;

public abstract class Machine extends TeamMember implements Cloneable {

    protected int health;
    protected int attackPoints;
    protected int attackDistance;
    protected int moveSpan;
    protected String[] buffer;
    protected MovementBehaviourAdapter movement;
    protected int attacks = 1;
    protected int movements = 1;
    protected boolean overcharged = false;
    protected boolean special = false;

    public MovementBehaviourAdapter getAdapter() {
        return movement;
    }

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public void setMovement(MovementBehaviourAdapter movement) {
        this.movement = movement;
    }

    @Override
    public String toString() {
        return
                '\u2694' + "" + this.attackPoints + ""+
                        '\u2661' + this.health + ""+
                '\u27B3' + "" + this.attackDistance + ""+
                        "\uD83E\uDDB6" + this.moveSpan;
    }

    public String[] getBuffer() {
        return buffer;
    }

    public boolean isOvercharged() {
        return overcharged;
    }

    public void setOvercharged(boolean overcharged) {
        this.overcharged = overcharged;
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

    abstract public int getAmmo();

    abstract public void setAmmo(int ammo);

    abstract public void shoot();

    abstract public void reload();

    @Override
    public int getPoints() {
        if(getHealth() > 0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int getAttacks() {
        return attacks;
    }

    @Override
    public int getMovements() {
        return movements;
    }

    @Override
    public void resetMovements() {
        this.movements = 1;
    }

    @Override
    public void resetAttacks() {
        this.attacks = 1;
    }

    @Override
    public void blockAttacks() {
        this.attacks = 0;
    }

    @Override
    public void blockMovements() {
        this.movements = 0;
    }

    @Override
    public void reset() {
        this.movements = 1;
        this.attacks = 1;
    }

    @Override
    public void block(){
        this.attacks = 0;
        this.movements = 0;
    }

    @Override
    public Machine clone() {
        try {
            Machine machine = (Machine) super.clone();
            // Aberto a modificações
            return machine;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public boolean isBlocked(){
        return (this.getMovements() + this.getAttacks()) == 0;
    }

}
