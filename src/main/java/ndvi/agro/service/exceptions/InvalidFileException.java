package ndvi.agro.service.exceptions;

/**
 * Expcetion that is thrown when invalid file is sent from the client.
 */
public class InvalidFileException extends RuntimeException {
    public InvalidFileException(String message) {
        super(message);
    }
    
    public InvalidFileException(String message, Exception e) {
    	super(message, e);
    }
}
