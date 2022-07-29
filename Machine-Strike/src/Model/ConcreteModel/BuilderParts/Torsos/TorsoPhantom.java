package Model.ConcreteModel.BuilderParts.Torsos;

public class TorsoPhantom extends Torso {
    public TorsoPhantom() {
        this.health = 15;
        this.attackPoints = 0;
        this.attackDistance = 0;
        this.moveSpan = 0;
        String a = "phantom";
        this.buffer = new String[]{"Assets\\"+s+a+b};
    }
}