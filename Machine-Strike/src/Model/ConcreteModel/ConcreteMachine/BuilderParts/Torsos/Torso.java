package Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos;

public abstract class Torso {

    public int health;
    public int attackPoints;
    public int attackDistance;
    public int moveSpan;
    protected String s = "#";
    protected String b = "torso.png";
    protected String[] buffer;

    public Torso() {
        this.health = 1;
        this.attackPoints = 1;
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