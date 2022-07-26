package Model;

import Controller.BoardController.Visitor.MachineVisitor;
import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;
import Model.Terrain.Terrain;
import Model.Terrain.TerrainType;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public Board() {
        for (int i = 0; i < 64; i++) {
            terrains.add(new Terrain(TerrainType.GrasslandField, decimalToCord(i)));
        }
    }

    private int[] decimalToCord(int key){
        String[] temp = (Integer.toString(key, 8) + "").split("");
        int[] cords;
        if (temp.length == 1){
            cords = new int[]{0, Integer.parseInt(temp[0])};
        }else{
            cords = new int[]{Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};
        }
        return cords;
    }

    public void accept(MachineVisitor visitor) throws Exception {
        for (Terrain terrain: terrains)
            terrain.accept(visitor);
    }

    private List<Machine> pieceSetAlpha;
    private List<Machine> pieceSetBeta;

    public List<Machine> getPieceSetAlpha() {
        return pieceSetAlpha;
    }
    public List<Machine> getPieceSetBeta() {
        return pieceSetBeta;
    }


    public List<Machine> getTemporaryPieceSet() {
        return temporaryPieceSet;
    }
    private final List<Machine> temporaryPieceSet = new ArrayList<>();

    private final List<Terrain> terrains = new ArrayList<>(64);

    public ArrayList<Terrain> getTerrains() {
        return (ArrayList<Terrain>) terrains;
    }

    public Terrain getTerrain(int[] cords) throws Exception {
        StringBuilder aux = new StringBuilder("");
        for (int i: cords
             ) {
            aux.append(i);
        }
        int base10cords = Integer.parseInt(aux.toString(),8);
        if(0 >= base10cords | 63 >= base10cords){
            return terrains.get(base10cords);
        }
        throw new Exception("Index out of bounds Exception at Board.getTerrain()");
    }

    public void setPieceSetAlpha(List<Machine> pieceSetAlpha) {
        this.pieceSetAlpha = pieceSetAlpha;
    }

    public void setPieceSetBeta(List<Machine> pieceSetBeta) {
        this.pieceSetBeta = pieceSetBeta;
    }

    public void clearTemporaryPieceSet() {
        this.temporaryPieceSet.clear();
    }

    public void AddToTemporaryPieceSet(Machine machine){
        this.temporaryPieceSet.add(machine);
    }

    public void assembleBoard(){

        for (int i = 0; i < 32; i++) {
            if(i == pieceSetAlpha.size())
                break;
            Machine machine = pieceSetAlpha.get(i);
            terrains.get(i).addMachine(machine);
        }
        int aux = 63;
        for (int i = 32; i < 64; i++) {
            if(i-32 == pieceSetBeta.size())
                break;
            Machine machine = pieceSetBeta.get(i-32);
            terrains.get(aux).addMachine(machine);
            aux--;
        }

    }

}
