package Controller.Factory;

import Model.AbstractModel.MachineEntity;
import Model.AbstractModel.MachineRadioactiveEntity;

public class CustomMachineFactory implements AbstractMachineFactory{
    @Override
    public MachineEntity createMachine() {
        // Aqui vamos usar o builder
        return null;
    }

    @Override
    public MachineRadioactiveEntity createRadioactiveMachine() throws Exception {
        throw new Exception("Radioactive custom machine not available");
    }
}
