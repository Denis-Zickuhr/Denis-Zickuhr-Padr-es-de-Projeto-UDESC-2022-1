package Model.Terrain;

import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;
import Model.BoardEntity;
import Model.ConcreteModel.ConcreteMachine.Basic.SoldierMachine;
import Model.Terrain.Adapter.MovementBehaviourAdapter;

import java.util.Arrays;

public class Terrain {

    private final TerrainType terrainType;
    private final BoardEntity board;
    public Terrain(TerrainType terrainType, BoardEntity board) {
        this.terrainType = terrainType;
        this.board = board;
    }

    private Machine machine;

    public TerrainType getTerrainType() {
        return terrainType;
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

    public Machine getMachine() {
        return machine;
    }

    public boolean receivePiece(Machine machine){
        if(this.machine == null){
            this.machine = machine;
            return true;
        }else{
            return false;
        }
    }

    public void dropPiece(){
        this.machine = null;
    }

    public boolean movePiece(int[] cords) throws Exception {
        if (board.getTerrain(cords).getMachine() == null){
            Machine tempMachine = this.machine;
            this.machine = null;
            board.getTerrain(cords).receivePiece(tempMachine);
            return true;
        }
        return false;
    }

    public boolean attackMachine(Machine machine){
        int damage = getMachine().getAttackPoints() + terrainType.value();
        machine.setHealth(machine.getHealth() - damage);
        return true;
    }

    public boolean overCharge(){
        return true;
    }

    public boolean specialAttack() throws Exception {
        getMachine().getMovement().specialAttack();
        return false;
    }

}
