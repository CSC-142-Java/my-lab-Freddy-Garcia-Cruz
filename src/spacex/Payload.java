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

    // Accessor "getter" methods for Payload Class
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getMass() {
        return mass;
    }

    public String getOrbit() {
        return orbit;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", mass=" + mass +
                ", orbit='" + orbit + '\'' +
                '}';
    }
}