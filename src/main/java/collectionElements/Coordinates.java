package collectionElements;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import exceptions.WrongDataException;

public class Coordinates extends Element {
    @JacksonXmlProperty(localName = "x")
    private Integer x;

    @JacksonXmlProperty(localName = "x")
    private Long y;

    public Coordinates(Integer x, Long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void validate() throws WrongDataException {
        if (x == null || x > 232) {
            throw new WrongDataException("Wrong x coordinate");
        }
        if (y == null || y > 281) {
            throw new WrongDataException("Wrong y coordinate");
        }
    }
}
