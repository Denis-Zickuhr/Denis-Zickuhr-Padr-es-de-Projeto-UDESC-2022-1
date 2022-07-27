package Model.AbstractModel.AbstractMachine;

import Model.AbstractModel.Armor;
import Model.TeamMember;
import Model.Terrain.Adapter.MovementBehaviourAdapter;

import java.util.Arrays;

public abstract class Machine extends TeamMember implements Cloneable {

    protected int health;
    protected int attackPoints;
    protected int attackDistance;
    protected int moveSpan;
    protected int[] cords;
    protected Armor[] armors = new Armor[4];
    protected String[] buffer;
    protected MovementBehaviourAdapter movement;
    protected int attacks = 1;
    protected int movements = 1;

    public int[] getCords() {
        return cords;
    }

    public void setCords(int[] cords) {
        this.cords = cords;
    }

    public MovementBehaviourAdapter getAdapter() {
        return movement;
    }

    public void setMovement(MovementBehaviourAdapter movement) {
        this.movement = movement;
    }


    @Override
    public String toString() {
        return
                "Attack: " + this.attackPoints + ","+
                "Health: " + this.health + ","+
                "Attack Distance" + this.attackDistance + ","+
                "Move Span: " + this.moveSpan + ","+
                "Armor set: " + Arrays.toString(this.armors);
    }

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
    public void block(){
        this.attacks = 0;
        this.movements = 0;
    }

    @Override
    public Machine clone() {
        try {
            return (Machine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
