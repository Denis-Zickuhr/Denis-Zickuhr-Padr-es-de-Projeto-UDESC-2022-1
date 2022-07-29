package Controller.MachineSelection;

import Model.AbstractModel.AbstractStrategy;
import Model.AbstractModel.Machine;

public interface MachineSelectionObserver {

    void drawMachine(Machine machine);
    void addPieceStrategy(AbstractStrategy st);
    AbstractStrategy getStrategy();
    void enableComboBox(Boolean enabled);
    void alterTittle();
    void dispose();

}
