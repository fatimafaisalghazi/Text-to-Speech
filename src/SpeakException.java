public class SpeakException extends Exception {
    public SpeakException(String message) {
        super(message);
    }
}

class NetworkException extends SpeakException {
    public NetworkException(String message) {
        super(message);
    }

    public NetworkException() {
        super("Network error occurred");
    }
}

class InputException extends SpeakException {
    public InputException(String message) {
        super(message);
    }

    public InputException() {
        super("Invalid input");
    }
}