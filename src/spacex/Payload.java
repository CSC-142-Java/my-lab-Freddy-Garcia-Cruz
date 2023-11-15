package spacex;

public class Payload {

    private String name;
    private String type;
    private double mass;
    private String orbit;

    public Payload(String name, String type, double mass, String orbit) {
        this.name = name;
        this.type = type;
        this.mass = mass;
        this.orbit = orbit;
    }

    //TODO : Create Accessor "gettor" methods for Payload Class

    @Override
    public String toString() {
        //TODO: update with display pattern discussed in design documentation
        return "";
    }

}
