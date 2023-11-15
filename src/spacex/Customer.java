package spacex;

public class Customer {

    //data fields
    private String name;
    private String type;
    private String country;


    //overloaded constructors
    public Customer(){
        this("", "", "");
    }

    public Customer(String name, String type, String country) {
        this.name     = name;
        this.type     = type;
        this.country  = country;
    }


    //TODO : Create Accessor "gettor" methods for Customer Class

    public String toString(){
        //TODO: update with display pattern discussed in design documentation
        return "";
    }

}
