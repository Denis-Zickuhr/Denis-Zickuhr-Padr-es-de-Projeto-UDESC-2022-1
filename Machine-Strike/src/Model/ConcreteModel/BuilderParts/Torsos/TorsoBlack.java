package Model.ConcreteModel.BuilderParts.Torsos;

public class TorsoBlack extends Torso {
    public TorsoBlack() {
        this.health = 1;
        this.attackPoints = 2;
        this.attackDistance = 1;
        this.moveSpan = 0;
        String a = "black";
        this.buffer = new String[]{"Assets\\"+s+a+b};
    }
}