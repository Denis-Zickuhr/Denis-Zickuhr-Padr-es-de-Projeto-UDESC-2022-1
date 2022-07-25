package Model.Terrain;

public enum TerrainType {
    Chasm(-2, "Assets\\Terrain.png"),
    Marsh(-1, "Assets\\Terrain.png"),
    GrasslandField(0, "Assets\\Terrain.png"),
    ForrestRain(1, "Assets\\Terrain.png"),
    HillTerrain(2, "Assets\\Terrain.png"),
    MountainTerrain(3, "Assets\\Terrain.png");

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
