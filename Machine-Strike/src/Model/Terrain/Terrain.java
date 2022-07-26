package Model.Terrain;

import Controller.BoardController.Visitor.MachineVisitor;
import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;
import Model.ConcreteModel.ConcreteMachine.Basic.SoldierMachine;

public class Terrain {

    private final TerrainType terrainType;
    private final int[] cords;

    public Terrain(TerrainType terrainType, int[] cords) {
        this.terrainType = terrainType;
        this.cords = cords;
    }

    private Machine machine;

    public int[] getCords() {
        return cords;
    }

    public TerrainType getTerrainType() {
        return terrainType;
    }

    public Machine getMachine() {
        return machine;
    }

    public void addMachine(Machine machine){
        if(this.machine == null){
            this.machine = machine;
        }
    }

    public void removeMachine(){
        this.machine = null;
    }

    public void accept(MachineVisitor visitor) throws Exception {
        visitor.visit(this);
    }

    public String[] getDraw() {
        if (this.machine != null) {
            int bufferLength = machine.getBuffer().length;
            // Gambiarra temporaria, onde recalculo o tamanho do buffer caso for uma peça com buffer [3]
            // O builder tá gerando apenas como 4
            if(machine.getClass() == SoldierMachine.class){
                bufferLength += -1;
            }
            String[] buffer = new String[1 + bufferLength];
            buffer[0] = terrainType.buffer();
            for (int i = 1; i < bufferLength+1; i++) {
                buffer[i] = machine.getBuffer()[i - 1].replaceAll("#", "small");
            }
            return buffer;
        }
        return new String[]{terrainType.buffer()};
    }

}
