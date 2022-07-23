package Controller;

import View.MachineSelectionView;

import java.util.ArrayList;
import java.util.List;

public class MachineSelectionController{

    private final List<MachineSelectionObserver> observer = new ArrayList<>();

    public void attach(MachineSelectionObserver observer){
        this.observer.add(observer);
    }

    public MachineSelectionController() {
        MachineSelectionView cl = new MachineSelectionView(this);
    }

    public void prevMachine() {
        for (MachineSelectionObserver obs : observer) {
            obs.prevMachineClicked();
        }
    }
    public void nextMachine() {
        for (MachineSelectionObserver obs : observer) {
            obs.nextMachineClicked();
        }
    }
    public void newMachine() {
        for (MachineSelectionObserver obs : observer) {
            obs.nextMachineClicked();
        }
    }
    public void selectMachine() {
        for (MachineSelectionObserver obs : observer) {
            obs.nextMachineClicked();
        }
    }
    public void toggleRadMachine() {
        for (MachineSelectionObserver obs : observer) {
            obs.nextMachineClicked();
        }
    }

    public static void main(String[] args) {
        MachineSelectionController msc = new MachineSelectionController();
    }

}


