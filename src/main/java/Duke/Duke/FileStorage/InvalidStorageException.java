package Duke.FileStorage;

public class InvalidStorageException extends Exception{
    public InvalidStorageException(String errorMsg) {
        super(errorMsg);
    }
}