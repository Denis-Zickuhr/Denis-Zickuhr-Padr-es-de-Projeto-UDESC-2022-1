package Model;


import Model.ConcreteModel.TerrainType;
import View.BoardMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Packer {



    public String loadPuzzle(String path) throws Exception {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            String result = "empty";
            if (line != null) {
                result = line;
                sb.append(line);
                sb.append(System.lineSeparator());
            }

            buildMap(result);
            return result;

        } catch (IOException e) {
            throw new Exception("Arquivo não selecionado pelo usuário");
        }
    }


    public void buildMap(String result){
        int last = 0;
        for (String s : result.split(";")
             ) {
            String[] range = s.split("-");
            TerrainType terrainType;
            switch (range[1]){
                case "M" : {
                    terrainType = TerrainType.Marsh;
                    break;
                }
                case "W" : {
                    terrainType = TerrainType.Water;
                    break;
                }
                case "C" : {
                    terrainType = TerrainType.Chasm;
                    break;
                }
                case "F" : {
                    terrainType = TerrainType.ForrestRain;
                    break;
                }
                case "H" : {
                    terrainType = TerrainType.HillTerrain;
                    break;
                }
                case "G" : {
                    terrainType = TerrainType.GrasslandField;
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + range[2]);
            }
            BoardMap.range(last, Integer.parseInt(range[0]), terrainType);
            last = Integer.parseInt(range[0]);
        }
    }
}
