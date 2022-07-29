package Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos;

public class TorsoYellow extends Torso {
    public TorsoYellow() {
        this.health = 3;
        this.attackPoints = 5;
        this.attackDistance = 1;
        this.moveSpan = 0;
        String a = "yellow";
        this.buffer = new String[]{"Assets\\"+s+a+b};
    }
}