package spacex;

// Update this class to complete the OOP design document description (see Canvas).
public class Mission {
    private final String flightNumber;
    private final Date launchDate;
    private final Time launchTime;
    private final String launchSite;
    private final String vehicleType;
    private final double mass;
    private final Payload payload;
    private final Customer customer;
    private final String missionOutcome;
    private final String failureReason;
    private final String landingType;
    private final String landingOutcome;

    private Mission(Builder builder) {
        this.flightNumber = builder.flightNumber;
        this.launchDate = builder.launchDate;
        this.launchTime = builder.launchTime;
        this.launchSite = builder.launchSite;
        this.vehicleType = builder.vehicleType;
        this.mass = builder.mass;
        this.payload = builder.payload;
        this.customer = builder.customer;
        this.missionOutcome = builder.missionOutcome;
        this.failureReason = builder.failureReason;
        this.landingType = builder.landingType;
        this.landingOutcome = builder.landingOutcome;
    }

    public static class Builder {
        private String flightNumber;
        private Date launchDate;
        private Time launchTime;
        private String launchSite;
        private String vehicleType;
        private double mass;
        private Payload payload;
        private Customer customer;
        private String missionOutcome;
        private String failureReason;
        private String landingType;
        private String landingOutcome;

        public Builder flightNumber(String flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

        public Builder launchDate(Date launchDate) {
            this.launchDate = launchDate;
            return this;
        }

        public Builder launchTime(Time launchTime) {
            this.launchTime = launchTime;
            return this;
        }

        public Builder launchSite(String launchSite) {
            this.launchSite = launchSite;
            return this;
        }

        public Builder vehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
            return this;
        }

        public Builder mass(double mass) {
            this.mass = mass;
            return this;
        }

        public Builder payload(Payload payload) {
            this.payload = payload;
            return this;
        }

        public Builder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder missionOutcome(String missionOutcome) {
            this.missionOutcome = missionOutcome;
            return this;
        }

        public Builder failureReason(String failureReason) {
            this.failureReason = failureReason;
            return this;
        }

        public Builder landingType(String landingType) {
            this.landingType = landingType;
            return this;
        }

        public Builder landingOutcome(String landingOutcome) {
            this.landingOutcome = landingOutcome;
            return this;
        }

        public Mission build() {
            return new Mission(this);
        }
    }

    // Accessor "getter" methods for Mission Class
    public Customer getCustomer() {
        return customer;
    }

    public Payload getPayload() {
        return payload;
    }

    public String toString() {
        return "Mission{" +
                "flightNumber='" + flightNumber + '\'' +
                ", launchDate=" + launchDate +
                ", launchTime=" + launchTime +
                ", launchSite='" + launchSite + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", mass=" + mass +
                ", payload=" + payload +
                ", customer=" + customer +
                ", missionOutcome='" + missionOutcome + '\'' +
                ", failureReason='" + failureReason + '\'' +
                ", landingType='" + landingType + '\'' +
                ", landingOutcome='" + landingOutcome + '\'' +
                '}';
    }
}