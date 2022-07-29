package Model.ConcreteModel.BuilderParts.Torsos;

public class TorsoRed extends Torso {
    public TorsoRed() {
        this.health = 10;
        this.attackPoints = 5;
        this.attackDistance = 1;
        this.moveSpan = 0;
        String a = "red";
        this.buffer = new String[]{"Assets\\"+s+a+b};
    }
}