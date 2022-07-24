package Model.AbstractModel.AbstractMachine.AbstractProduct;

import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;
import Model.AbstractModel.Armor;

public abstract class MachineKingEntity extends Machine {

    public MachineKingEntity() {
        setBuffer(new String[]{"Assets\\Piece2B.png"});
        setHealth(2);
        setAttackPoints(10);
        setAttackDistance(1);
        setMoveSpan(1);
        setArmors(new Armor[]{Armor.Resistant, Armor.Resistant, Armor.Resistant, Armor.Resistant});
    }

    public void KingShine(){

    }

}
