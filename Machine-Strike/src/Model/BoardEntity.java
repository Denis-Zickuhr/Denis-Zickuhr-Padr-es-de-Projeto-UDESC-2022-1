package Model;

import Model.AbstractModel.AbstractMachine.BaseProduct.Machine;
import Model.Terrain.Terrain;
import Model.Terrain.TerrainType;

import java.util.ArrayList;
import java.util.List;

public class BoardEntity {

    public BoardEntity() {
        for (int i = 0; i < 64; i++) {
            terrains.add(new Terrain(TerrainType.GrasslandField, this));
        }
    }

    private List<Machine> pieceSetAlpha;
    private List<Machine> pieceSetBeta;
    private final List<Machine> temporaryPieceSet = new ArrayList<>();
    private final List<Terrain> terrains = new ArrayList<>(64);

    public Terrain getTerrain(int[] cords) throws Exception {
        StringBuilder aux = new StringBuilder("");
        for (int i: cords
             ) {
            aux.append(i);
        }
        int base10cords = Integer.parseInt(aux.toString(),10);
        if(0 >= base10cords | 63 >= base10cords){
            return terrains.get(base10cords);
        }
        throw new Exception("Index out of bounds Exception at BoardEntity.getTerrain()");
    }

    public ArrayList<Terrain> getTerrains() {
        return (ArrayList<Terrain>) terrains;
    }

    public List<Machine> getPieceSetAlpha() {
        return pieceSetAlpha;
    }
    public List<Machine> getPieceSetBeta() {
        return pieceSetBeta;
    }
    public List<Machine> getTemporaryPieceSet() {
        return temporaryPieceSet;
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
    public void build(){

        for (int i = 0; i < 32; i++) {
            if(i == pieceSetAlpha.size())
                break;
            Machine machine = pieceSetAlpha.get(i);
            terrains.get(i).receivePiece(machine);
        }
        int aux = 63;
        for (int i = 32; i < 64; i++) {
            if(i-32 == pieceSetBeta.size())
                break;
            Machine machine = pieceSetBeta.get(i-32);
            terrains.get(aux).receivePiece(machine);
            aux--;
        }

    }
}
