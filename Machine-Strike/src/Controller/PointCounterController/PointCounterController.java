package Controller.PointCounterController;

import Controller.BoardController.BoardController;
import Controller.BoardController.Command.CommandInvoker;

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

    public void redo() throws Exception {
        CommandInvoker.getCommandInvoker().redo();
    }

    public void undo() throws Exception {
        CommandInvoker.getCommandInvoker().undo();
    }

    public void swap(){
        BoardController.getInstance().getTurn().block();
        BoardController.getInstance().toggleTurn();
        propagateUpdate();
    }

}
