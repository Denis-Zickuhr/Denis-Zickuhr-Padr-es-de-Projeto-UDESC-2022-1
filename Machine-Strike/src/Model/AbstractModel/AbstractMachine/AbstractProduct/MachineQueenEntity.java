package Model.AbstractModel.AbstractMachine.AbstractProduct;

import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;
import Model.AbstractModel.Armor;

public abstract class MachineQueenEntity extends Machine {

    public MachineQueenEntity() {
        setBuffer(new String[]{"Assets\\Piece1B.png"});
        setHealth(2);
        setAttackPoints(10);
        setAttackDistance(1);
        setMoveSpan(1);
        setArmors(new Armor[]{Armor.Resistant, Armor.Resistant, Armor.Weak, Armor.Resistant});
    }

    public void Stone(){}

}
