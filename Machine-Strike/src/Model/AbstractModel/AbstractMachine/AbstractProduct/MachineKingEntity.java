package Model.AbstractModel.AbstractMachine.AbstractProduct;

import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;
import Model.AbstractModel.Armor;
import Model.Terrain.Adapter.MovementAdapterKing;
import Model.Terrain.Adapter.MovementAdapterQueen;

public abstract class MachineKingEntity extends Machine {

    public MachineKingEntity() {
        setHealth(2);
        setAttackPoints(10);
        setAttackDistance(1);
        setMoveSpan(1);
        setArmors(new Armor[]{Armor.Resistant, Armor.Resistant, Armor.Resistant, Armor.Resistant});
        setMovement(new MovementAdapterKing(this));
    }

    public void KingShine(){

    }

}
