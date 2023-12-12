import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Vehicle {
    private final String make;
    private String model;
    private int year;
    private double price;

    public Vehicle(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getDetails() {
        return make + " " + model + " (" + year + ") - $" + String.format("%.2f", price);
    }

    public Object getMake() {
        return null;
    }

    public double getPrice() {
        return 0;
    }
}

class Car extends Vehicle {
    private int mileage;
    private String fuelType;

    public Car(String make, String model, int year, double price, int mileage, String fuelType) {
        super(make, model, year, price);
        this.mileage = mileage;
        this.fuelType = fuelType;
    }

    public String getDetails() {
        return super.getDetails() + " - " + mileage + " miles, " + fuelType;
    }
}

class Truck extends Vehicle {
    private double bedSize;
    private int towingCapacity;

    public Truck(String make, String model, int year, double price, double bedSize, int towingCapacity) {
        super(make, model, year, price);
        this.bedSize = bedSize;
        this.towingCapacity = towingCapacity;
    }

    public String getDetails() {
        return super.getDetails() + " - " + bedSize + " ft bed, " + towingCapacity + " lbs towing";
    }
}

class Dealership {
    private List<Vehicle> inventory;

    public Dealership() {
        this.inventory = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public void listInventory() {
        inventory.forEach(vehicle -> System.out.println(vehicle.getDetails()));
    }

    public List<Vehicle> findVehicleByMake(String make) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getMake().equals(make))
                .collect(Collectors.toList());
    }

    public List<Vehicle> findVehicleByPriceRange(double minPrice, double maxPrice) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }
}

class Main {
    public static void main(String[] args) {
        // Create vehicles
        Car honda_civic = new Car("Honda", "Civic", 2023, 22000, 15000, "Gasoline");
        Truck honda_ridgeline = new Truck("Honda", "Ridgeline", 2022, 35000, 6.5, 13500);

        // Create dealership and add vehicles to inventory
        Dealership dealership = new Dealership();
        dealership.addVehicle(honda_civic);
        dealership.addVehicle(honda_ridgeline);

        // List all vehicles in inventory
        dealership.listInventory();

        // Find vehicles by make (Honda)
        List<Vehicle> hondaVehicles = dealership.findVehicleByMake("Honda");
        System.out.println("\nHonda vehicles:");
        hondaVehicles.forEach(vehicle -> System.out.println(vehicle.getDetails()));

        // Find vehicles by price range (under $25,000)
        List<Vehicle> affordableVehicles = dealership.findVehicleByPriceRange(0, 25000);
        System.out.println("\nVehicles under $25,000:");
        affordableVehicles.forEach(vehicle -> System.out.println(vehicle.getDetails()));
    }
}
