package Model.ConcreteModel.ConcreteMachine.CustomMachineBuilder.Parts.Torsos;

public abstract class Torso {

    public int health;
    public int attackPoints;
    public int attackDistance;
    public int moveSpan;

    public Torso() {
        this.health = 1;
        this.attackPoints = 1;
        this.attackDistance = 1;
        this.moveSpan = 1;
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