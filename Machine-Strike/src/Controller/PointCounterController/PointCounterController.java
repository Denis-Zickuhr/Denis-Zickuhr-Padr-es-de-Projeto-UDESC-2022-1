package Controller.PointCounterController;

import Controller.MachineSelection.MachineSelectionObserver;

import java.util.ArrayList;
import java.util.List;

public class PointCounterController {

    public static PointCounterController getInstance() {
        if(pointCounterController == null)
            pointCounterController = new PointCounterController();
        return pointCounterController;
    }

    private static PointCounterController pointCounterController;

    private final List<PointControllerObserver> observer = new ArrayList<>();
    public void attach(PointControllerObserver observer){
        this.observer.add(observer);
    }

    public void propagateUpdate(){
        for (PointControllerObserver obs: observer
             ) {
            obs.update();
        }
    }
}
