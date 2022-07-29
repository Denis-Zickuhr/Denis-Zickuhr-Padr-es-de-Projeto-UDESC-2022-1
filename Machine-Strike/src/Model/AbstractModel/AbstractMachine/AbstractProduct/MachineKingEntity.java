package Model.AbstractModel.AbstractMachine.AbstractProduct;

import Model.AbstractModel.AbstractMachine.Machine;
import Model.AbstractModel.Armor;
import Model.Terrain.Adapter.MovementAdapterKing;

public abstract class MachineKingEntity extends Machine {

    public MachineKingEntity() {
        setHealth(3);
        setAttackPoints(5);
        setAttackDistance(1);
        setMoveSpan(3);
        setMovement(new MovementAdapterKing(this));
    }

    public void KingShine(){
        setHealth(getHealth()+3);
        setAttackPoints(getAttackPoints()+5);
        setAttackDistance(getAttackDistance()+1);
        setMoveSpan(getMoveSpan()+3);
        setSpecial(true);
    }

    public void kingDarken(){
        setHealth(getHealth()-3);
        setAttackPoints(getAttackPoints()-5);
        setAttackDistance(getAttackDistance()-1);
        setMoveSpan(getMoveSpan()-3);
        setSpecial(false);
    }

}
