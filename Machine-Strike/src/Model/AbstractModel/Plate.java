package Model.AbstractModel;

public enum Plate {
    Frontal(0), Back(2), Right(3), Left(1);
    int value;

    Plate(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}


