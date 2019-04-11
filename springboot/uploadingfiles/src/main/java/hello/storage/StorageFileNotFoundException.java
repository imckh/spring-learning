package hello.storage;

/**
 * @author CKH
 * @date 2018/12/20 21:22
 */
public class StorageFileNotFoundException  extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
