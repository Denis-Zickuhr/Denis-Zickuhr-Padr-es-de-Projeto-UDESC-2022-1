package Controller.MachineSelection;

import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;

public interface MachineSelectionObserver {

    void prevMachineClicked();
    void nextMachineClicked();
    void selMachineClicked();
    void newMachineClicked();
    void radMachineClicked();
    void drawMachine(Machine machine);

}
