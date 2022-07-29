package Controller.BoardController;

import Model.ConcreteModel.Player;
import Model.ConcreteModel.Terrain;
import View.Action;

import java.util.ArrayList;

public interface BoardObserver {
    void draw(ArrayList<Terrain> board);
    void redraw(ArrayList<Terrain> board);
    void toggleAction(Player player, boolean enable, Action action);
    void disableAllButtons();
}
