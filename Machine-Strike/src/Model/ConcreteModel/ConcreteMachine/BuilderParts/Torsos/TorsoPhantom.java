package Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos;

public class TorsoPhantom extends Torso {
    public TorsoPhantom() {
        this.health = 10;
        this.attackPoints = 10;
        this.attackDistance = 1;
        this.moveSpan = 0;
        String a = "phantom";
        this.buffer = new String[]{"Assets\\"+s+a+b};
    }
}