package Model.ConcreteModel.ConcreteMachine.BuilderParts.Legs;

public abstract class Leg {

    protected int health;
    protected int attackPoints;
    protected int attackDistance;
    protected int moveSpan;
    protected String s = "#";
    protected String b = "leg.png";
    protected String[] buffer;

    public Leg() {
        this.health = 1;
        this.attackPoints = 0;
        this.attackDistance = 1;
        this.moveSpan = 1;
    }

    public String[] getBuffer() {
        return buffer;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getAttackDistance() {
        return attackDistance;
    }

    public int getMoveSpan() {
        return moveSpan;
    }
}