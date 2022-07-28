package View;

import Model.Terrain.Terrain;
import Model.Terrain.TerrainType;

import java.util.ArrayList;
import java.util.List;

public class BoardMap {

    private static final List<TerrainType> list = new ArrayList<>(64);

    public static List<TerrainType> getList() {
        if(list.isEmpty()) {
            range(0, 10, TerrainType.HillTerrain);
            range(10, 15, TerrainType.Chasm);
            range(19, 29, TerrainType.Water);
            range(29, 42, TerrainType.GrasslandField);
            range(42, 63, TerrainType.HillTerrain);
        }
        return list;
    }

    public static void range(int from, int to, TerrainType terrainType){
        for (int i = from; i <= to; i++) {
            list.add(terrainType);
        }
    }

    public void clear(){
        list.clear();
    }

}
