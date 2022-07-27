package Model.AbstractModel.AbstractMachine.AbstractProduct;

import Model.AbstractModel.AbstractMachine.Machine;
import Model.AbstractModel.Armor;
import Model.Terrain.Adapter.MovementAdapterKing;

public abstract class MachineKingEntity extends Machine {

    public MachineKingEntity() {
        setHealth(100);
        setAttackPoints(10);
        setAttackDistance(1);
        setMoveSpan(1);
        setArmors(new Armor[]{Armor.Resistant, Armor.Resistant, Armor.Resistant, Armor.Resistant});
        setMovement(new MovementAdapterKing(this));
    }

    public void KingShine(){

    }

}
