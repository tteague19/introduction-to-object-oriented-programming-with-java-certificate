// An unchecked exception with two constructors
//
// Constructors
// InvalidPetException() has message “Your pet is invalid!”
// InvalidPetException(String s) has message s

public class InvalidPetException extends RuntimeException {
    public InvalidPetException() {
        super("Your pet is invalid!");
    }

    public InvalidPetException(String s) {
        super(s);
    }
}
