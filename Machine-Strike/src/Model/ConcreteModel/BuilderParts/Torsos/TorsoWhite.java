package Model.ConcreteModel.BuilderParts.Torsos;

public class TorsoWhite extends Torso {
    public TorsoWhite() {
        this.health = 2;
        this.attackPoints = 5;
        this.attackDistance = 1;
        this.moveSpan = 0;
        String a = "white";
        this.buffer = new String[]{"Assets\\"+s+a+b};
    }
}