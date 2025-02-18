package collectionElements;

/**
 * Перечисление видов топлива
 * @author Андрей
 * */
public enum FuelType {
    ELECTRICITY("ELECTRICITY"),
    DIESEL("DIESEL"),
    MANPOWER("MANPOWER"),
    NUCLEAR("NUCLEAR"),
    ANTIMATTER("ANTIMATTER");

    public String fuelType;

    /**
     * Конструктор
     * @param fuelType - строковое представление элемента перечисления
     * */
    FuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
