package Model.ConcreteModel;

public enum TerrainType {
    Chasm(-2, "Assets\\TerrainChasm.png"),
    Marsh(-1, "Assets\\TerrainMarsh.png"),
    GrasslandField(0, "Assets\\TerrainGrass.png"),
    ForrestRain(1, "Assets\\TerrainForrest.png"),
    HillTerrain(2, "Assets\\TerrainHill.png"),
    Water(3, "Assets\\TerrainWater.png");

    private final int value;
    private final String buffer;

    TerrainType(int value, String buffer){
        this.value = value;
        this.buffer = buffer;
    }

    public int value() {
        return value;
    }

    public String buffer(){
        return this.buffer;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
