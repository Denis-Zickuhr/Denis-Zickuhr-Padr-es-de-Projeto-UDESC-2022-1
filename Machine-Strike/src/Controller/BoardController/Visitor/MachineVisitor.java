package Controller.BoardController.Visitor;

import Model.ConcreteModel.Terrain;

public interface MachineVisitor {

    void visit(Terrain terrain) throws Exception;

}
