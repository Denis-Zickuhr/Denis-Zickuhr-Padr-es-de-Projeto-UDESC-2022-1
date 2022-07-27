package Controller.BoardController.Visitor;

import Model.Terrain.Terrain;

public interface MachineVisitor {

    void visit(Terrain terrain) throws Exception;

}
