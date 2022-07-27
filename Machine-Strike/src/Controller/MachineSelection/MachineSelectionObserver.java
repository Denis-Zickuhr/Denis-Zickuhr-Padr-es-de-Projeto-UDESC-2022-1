package Controller.MachineSelection;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.Machine;

public interface MachineSelectionObserver {

    void drawMachine(Machine machine);
    void addPieceStrategy(AbstractStrategy st);
    AbstractStrategy getStrategy();
    void enableComboBox(Boolean enabled);
    void alterTittle();
    void dispose();

}
