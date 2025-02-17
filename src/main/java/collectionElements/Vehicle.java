package collectionElements;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import exceptions.WrongDataException;
import utils.IDGenerator;

import java.time.ZonedDateTime;

public class Vehicle extends Element {
    private Long id;
    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "coordinates")
    private Coordinates coordinates;
    private ZonedDateTime creationDate;
    @JacksonXmlProperty(localName = "enginePower")
    private Long enginePower;
    @JacksonXmlProperty(localName = "capacity")
    private double capacity;
    @JacksonXmlProperty(localName = "distanceTravelled")
    private Long distanceTravelled;
    @JacksonXmlProperty(localName = "fuelType")
    private FuelType fuelType;

    public Vehicle(String name, Coordinates coordinates, ZonedDateTime creationDate, Long enginePower, double capacity, Long distanceTravelled, FuelType fuelType) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.enginePower = enginePower;
        this.capacity = capacity;
        this.distanceTravelled = distanceTravelled;
        this.fuelType = fuelType;
        id = (long) IDGenerator.getNewID();
        creationDate = ZonedDateTime.now();
    }

    @Override
    public void validate() throws WrongDataException {
        if (id == null || id <= 0) {
            throw new WrongDataException("Wrong id");
        }
        if (name == null || name.isEmpty()) {
            throw new WrongDataException("Wrong name");
        }
        if (coordinates == null) {
            throw new WrongDataException("Wrong coordinates");
        }
        coordinates.validate();
        if (creationDate == null) {
            throw new WrongDataException("Wrong creation date");
        }
        if (enginePower == null || enginePower <= 0) {
            throw new WrongDataException("Wrong engine power");
        }
        if (capacity <= 0) {
            throw new WrongDataException("Wrong capacity");
        }
        if (!(distanceTravelled == null) && distanceTravelled <= 0) {
            throw new WrongDataException("Wrong distance travelled");
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Long getEnginePower() {
        return enginePower;
    }

    public double getCapacity() {
        return capacity;
    }

    public Long getDistanceTravelled() {
        return distanceTravelled;
    }

    public FuelType getFuelType() {
        return fuelType;
    }
}
