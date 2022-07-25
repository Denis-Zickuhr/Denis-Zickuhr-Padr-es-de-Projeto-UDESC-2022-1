package Model.ConcreteModel.ConcreteMachine.Armed;

import Model.AbstractModel.AbstractMachine.AbstractProduct.MachineKingEntity;

import java.util.Arrays;

public class KingArmedMachine extends MachineKingEntity {

    int ammo = 2;

    @Override
    public String toString() {
        return super.toString() +
        "Ammo: " + this.ammo;
    }

    public KingArmedMachine() {
        super();
        setBuffer(new String[]{"Assets\\#kingarmed.png"});
    }
}
