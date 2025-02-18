package collectionElements;

public enum FuelType {
    ELECTRICITY("ELECTRICITY"),
    DIESEL("DIESEL"),
    MANPOWER("MANPOWER"),
    NUCLEAR("NUCLEAR"),
    ANTIMATTER("ANTIMATTER");

    public String fuelType;

    FuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }
}
