package Model.ConcreteModel.ConcreteMachine.BuilderParts.RadioEmiter;

public abstract class Radio {

    private int health;
    private int attackPoints;
    private int attackDistance;
    private int moveSpan;
    private int radRadius;


    public Radio() {
        this.health = 0;
        this.attackPoints = 0;
        this.attackDistance = 0;
        this.moveSpan = 0;
        this.radRadius = 0;
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