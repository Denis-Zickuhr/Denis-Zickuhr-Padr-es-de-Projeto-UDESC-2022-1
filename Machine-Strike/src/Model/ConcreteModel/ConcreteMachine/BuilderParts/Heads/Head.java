package Model.ConcreteModel.ConcreteMachine.BuilderParts.Heads;

public abstract class Head {

    public int health;
    public int attackPoints;
    public int attackDistance;
    public int moveSpan;

    public Head() {
        this.health = 1;
        this.attackPoints = 0;
        this.attackDistance = 0;
        this.moveSpan = 0;
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