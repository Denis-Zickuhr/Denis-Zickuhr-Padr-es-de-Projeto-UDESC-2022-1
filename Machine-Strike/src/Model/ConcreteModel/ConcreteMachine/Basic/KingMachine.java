package Model.ConcreteModel.ConcreteMachine.Basic;

import Model.AbstractModel.AbstractMachine.AbstractProduct.MachineKingEntity;

public class KingMachine extends MachineKingEntity {

    public KingMachine() {
        super();
        setBuffer(new String[]{"Assets\\king.png"});
    }
}
