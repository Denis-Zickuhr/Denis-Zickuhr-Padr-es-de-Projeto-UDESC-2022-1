package Model.AbstractModel.AbstractMachine.AbstractProduct;

import Model.AbstractModel.AbstractMachine.Machine;
import Model.AbstractModel.Armor;
import Model.Terrain.Adapter.MovementAdapterQueen;

public abstract class MachineQueenEntity extends Machine {

    public MachineQueenEntity() {
        setHealth(2);
        setAttackPoints(8);
        setAttackDistance(1);
        setMoveSpan(7);
        setMovement(new MovementAdapterQueen(this));
    }

    public void stone(){
        setHealth(getHealth()+10);
        setHealth(getMoveSpan()-3);
    }
    public void destone(){
        setHealth(getHealth()-10);
        setHealth(getMoveSpan()+3);
    }

}
