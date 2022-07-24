package Model.AbstractModel.AbstractMachine.AbstractProduct;

import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;
import Model.AbstractModel.Armor;

public abstract class MachineBeastEntity extends Machine {

    public MachineBeastEntity() {
        setHealth(10);
        setAttackPoints(5);
        setAttackDistance(3);
        setMoveSpan(5);
        setArmors(new Armor[]{Armor.Weak, Armor.Weak, Armor.Weak, Armor.Weak});
    }

    public void AttackEveryMachine(){

    }
    
}
