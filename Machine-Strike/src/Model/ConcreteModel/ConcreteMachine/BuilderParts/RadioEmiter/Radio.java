package Model.ConcreteModel.ConcreteMachine.BuilderParts.RadioEmiter;

public abstract class Radio {

    protected int health;
    protected int attackPoints;
    protected int attackDistance;
    protected int moveSpan;
    protected int radRadius;
    protected String[] buffer;


    public Radio() {
        this.health = 0;
        this.attackPoints = 0;
        this.attackDistance = 0;
        this.moveSpan = 0;
        this.radRadius = 0;
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

    public int getRadRadius() {
        return radRadius;
    }
}