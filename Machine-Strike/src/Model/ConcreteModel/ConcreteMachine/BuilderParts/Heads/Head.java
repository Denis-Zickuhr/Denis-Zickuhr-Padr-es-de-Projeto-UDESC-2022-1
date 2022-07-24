package Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads;

public abstract class Head {

    protected int health;
    protected int attackPoints;
    protected int attackDistance;
    protected int moveSpan;
    protected String s = "#";
    protected String b = "head.png";
    protected String[] buffer;

    public Head() {
        this.health = 1;
        this.attackPoints = 0;
        this.attackDistance = 0;
        this.moveSpan = 0;
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