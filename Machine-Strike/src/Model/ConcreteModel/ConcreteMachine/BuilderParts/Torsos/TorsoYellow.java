package Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos;

public class TorsoYellow extends Torso {
    public TorsoYellow() {
        this.health = 10;
        this.attackPoints = 10;
        this.attackDistance = 1;
        this.moveSpan = 0;
        String a = "yellow";
        this.buffer = new String[]{"Assets\\"+s+a+b};
    }
}