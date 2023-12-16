package spacex;

public class Customer {

    //data fields
    private String name;
    private String type;
    private String country;

    // Accessor "getter" methods for Customer Class
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCountry() {
        return country;
    }

    //overloaded constructors
    public Customer(){
        this("", "", "");
    }

    public Customer(String name, String type, String country) {
        this.name     = name;
        this.type     = type;
        this.country  = country;
    }

    public String toString(){
        return "Name: " + name + ", Type: " + type + ", Country: " + country;
    }
}