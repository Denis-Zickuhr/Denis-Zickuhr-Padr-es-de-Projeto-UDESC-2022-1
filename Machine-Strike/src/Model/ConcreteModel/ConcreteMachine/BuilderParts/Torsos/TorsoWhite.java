package Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos;

public class TorsoWhite extends Torso {
    public TorsoWhite() {
        this.health = 10;
        this.attackPoints = 10;
        this.attackDistance = 1;
        this.moveSpan = 0;
        String a = "white";
        this.buffer = new String[]{"Assets\\"+s+a+b};
    }
}