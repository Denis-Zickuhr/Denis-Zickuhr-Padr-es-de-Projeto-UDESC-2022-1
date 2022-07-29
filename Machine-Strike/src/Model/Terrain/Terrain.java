package Model.Terrain;

import Controller.BoardController.BoardController;
import Controller.BoardController.Visitor.MachineVisitor;
import Model.AbstractModel.AbstractMachine.Machine;
import Model.Board;
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
            if(this.machine.getPoints() <= 0){
                return new String[]{terrainType.buffer(), "Assets/fire.png"};
            }
            int bufferLength = machine.getBuffer().length;
            if(machine.getClass() == SoldierMachine.class){
                bufferLength += -1;
            }
            String[] buffer = new String[2 + bufferLength];
            buffer[0] = terrainType.buffer();
            for (int i = 1; i < bufferLength+1; i++) {
                buffer[i] = machine.getBuffer()[i - 1].replaceAll("#", "small");
            }
            String teamCard;
            if(Board.getPlayer1().getMachines().contains(machine)){
                teamCard = "Assets/t1card.png";
            }else{
                teamCard = "Assets/t2card.png";
            }
            buffer[buffer.length-1] = teamCard;
            return buffer;
        }

        return new String[]{terrainType.buffer()};
    }

}
