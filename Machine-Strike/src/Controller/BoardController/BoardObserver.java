package Controller.BoardController;

import Model.Player;
import Model.Terrain.Terrain;
import View.Action;

import javax.swing.*;
import java.util.ArrayList;

public interface BoardObserver {
    void draw(ArrayList<Terrain> board);
    void redraw(ArrayList<Terrain> board);
    void toggleAction(Player player, boolean enable, Action action);
    void disableAllButtons();
}
