package Model.ConcreteModel.ConcreteMachine.BuilderParts.Torsos;

import Model.ConcreteModel.ConcreteMachine.BuilderParts.Legs.Leg;

public class TorsoBlack extends Torso {
    public TorsoBlack() {
        this.health = 10;
        this.attackPoints = 10;
        this.attackDistance = 1;
        this.moveSpan = 0;
        String a = "black";
        this.buffer = new String[]{"Assets\\"+s+a+b};
    }
}