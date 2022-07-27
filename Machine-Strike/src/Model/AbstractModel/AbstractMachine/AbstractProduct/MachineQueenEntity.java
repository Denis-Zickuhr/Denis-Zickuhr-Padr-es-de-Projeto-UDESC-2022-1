package Model.AbstractModel.AbstractMachine.AbstractProduct;

import Model.AbstractModel.AbstractMachine.Machine;
import Model.AbstractModel.Armor;
import Model.Terrain.Adapter.MovementAdapterQueen;

public abstract class MachineQueenEntity extends Machine {

    public MachineQueenEntity() {
        setHealth(2);
        setAttackPoints(10);
        setAttackDistance(1);
        setMoveSpan(1);
        setArmors(new Armor[]{Armor.Resistant, Armor.Resistant, Armor.Weak, Armor.Resistant});
        setMovement(new MovementAdapterQueen(this));
    }

    public void Stone(){}

}
