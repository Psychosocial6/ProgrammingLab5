package interfaces;

import exceptions.WrongDataException;

public interface Validatable {
    void validate() throws WrongDataException;
}
