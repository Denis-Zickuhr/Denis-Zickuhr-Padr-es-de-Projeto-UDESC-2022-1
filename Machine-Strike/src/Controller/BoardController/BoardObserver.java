package Controller.BoardController;

import Model.Terrain.Terrain;

import java.util.ArrayList;

public interface BoardObserver {
    void draw(ArrayList<Terrain> board);
}
