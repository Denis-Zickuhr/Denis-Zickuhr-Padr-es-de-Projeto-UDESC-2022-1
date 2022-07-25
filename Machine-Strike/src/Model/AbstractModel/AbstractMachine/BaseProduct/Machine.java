package Model.AbstractModel.AbstractMachine.BaseProduct;

import Model.AbstractModel.Armor;
import Model.Terrain.Adapter.MovementBehaviourAdapter;

import java.util.Arrays;

public abstract class Machine {

    protected int health;
    protected int attackPoints;
    protected int attackDistance;
    protected int moveSpan;
    protected int[] cords;
    protected Armor[] armors = new Armor[4];
    protected String[] buffer;
    protected MovementBehaviourAdapter movement;

    public int[] getCords() {
        return cords;
    }

    public void setCords(int[] cords) {
        this.cords = cords;
    }

    public MovementBehaviourAdapter getMovement() {
        return movement;
    }

    public void setMovement(MovementBehaviourAdapter movement) {
        this.movement = movement;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     * @apiNote In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * The string output is not necessarily stable over time or across
     * JVM invocations.
     * @implSpec The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     */
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

}
