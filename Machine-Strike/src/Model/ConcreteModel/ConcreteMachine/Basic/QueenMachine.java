package Model.ConcreteModel.ConcreteMachine.Basic;

import Model.AbstractModel.AbstractMachine.AbstractProduct.MachineQueenEntity;

public class QueenMachine extends MachineQueenEntity {
    public QueenMachine() {
        super();
        setBuffer(new String[]{"Assets\\queen.png"});
    }
}
