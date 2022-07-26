package Controller.BoardController;

import Model.Terrain.Terrain;
import View.Action;

import javax.swing.*;
import java.util.ArrayList;

public interface BoardObserver {
    void draw(ArrayList<Terrain> board);
    void redraw(ArrayList<Terrain> board);
    void toggleAction(JPanel jp_buttons , boolean enable, Action action);
}
