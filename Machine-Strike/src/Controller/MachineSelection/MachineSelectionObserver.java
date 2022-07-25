package Controller.MachineSelection;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy.AbstractStrategy;
import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;

public interface MachineSelectionObserver {

    void drawMachine(Machine machine);
    void addPieceStrategy(AbstractStrategy st);
    AbstractStrategy getStrategy();
    void enableComboBox(Boolean enabled);
    void confirmSet(int current);
    void dispose();

}
