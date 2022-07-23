package Model.AbstractModel;

public enum Plate {
    Frontal(0), Back(3), Right(1), Left(2);
    int value;

    Plate(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}


