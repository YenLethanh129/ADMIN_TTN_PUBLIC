package ct07.adminmanagerforttn.util;

/**
 *
* @author CT07N0161 VoThiBichTuyen CT07N0162 LeThanhYen
 */
public abstract class Resource<T> {
    private final Status status;
    private final T data;
    private final String message;

    private Resource(Status status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static class Success<T> extends Resource<T> {
        public Success(T data) {
            super(Status.SUCCESS, data, null);
        }
    }

    public static class Error<T> extends Resource<T> {
        public Error(String message, T data) {
            super(Status.ERROR, data, message);
        }

        public Error(String message) {
            super(Status.ERROR, null, message);
        }
    }

    public static class Loading<T> extends Resource<T> {
        public Loading() {
            super(Status.LOADING, null, null);
        }
    }

    public Status getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public enum Status {
        SUCCESS,
        ERROR,
        LOADING
    }
}
