package Model;

import Controller.BoardController.Visitor.MachineVisitor;
import Model.AbstractModel.AbstractMachine.Machine;
import Model.Terrain.Terrain;
import Model.Terrain.TerrainType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Board {

    private static Player player1;
    private static Player player2;

    public static Player getPlayer1() {
        if(player1 == null)
            player1 = new Player();
        return player1;
    }

    public static Player getPlayer2() {
        if(player2 == null)
            player2 = new Player();
        return player2;
    }

    public void addPlayerMachine(boolean player1Ready, Machine machine){
        if(!player1Ready){
            Board.getPlayer1().addMachine(machine);
        }else{
            Board.getPlayer2().addMachine(machine);
        }
    }

    public Board() {
        for (int i = 0; i < 64; i++) {
            terrains.add(new Terrain(TerrainType.GrasslandField, decimalToCord(i)));
        }
    }

    private int[] decimalToCord(int key){
        String[] temp = (Integer.toString(key, 8) + "").split("").clone();
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

    public void assembleBoard() {

        Random r = new Random();
        for (Machine machine : Board.getPlayer1().getMachines()
        ) {
            int number = r.nextInt(31);
            while (terrains.get(number).getMachine() != null) {
                number = r.nextInt(31);
            }
            terrains.get(number).addMachine(machine);
        }

        for (Machine machine : Board.getPlayer2().getMachines()
        ) {
            int number = r.nextInt(31) + 32;
            while (terrains.get(number).getMachine() != null) {
                number = r.nextInt(31);
            }
            terrains.get(number).addMachine(machine);
        }
    }

}
