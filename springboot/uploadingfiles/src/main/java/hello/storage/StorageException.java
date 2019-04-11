package hello.storage;

/**
 * @author CKH
 * @date 2018/12/20 21:23
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}