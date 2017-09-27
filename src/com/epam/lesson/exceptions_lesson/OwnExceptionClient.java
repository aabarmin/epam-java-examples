package com.epam.lesson.exceptions_lesson;

/**
 * @author ABarmin
 */
public class OwnExceptionClient {
    public static void main(String[] args) {
        try {
            throw new OwnException("This is exception text");
        } catch (OwnException e) {
            throw new OwnRuntimeException(e);
        }
    }
}

class OwnException extends Exception {
    public OwnException() {
    }

    public OwnException(String message) {
        super(message);
    }

    public OwnException(String message, Throwable cause) {
        super(message, cause);
    }
}

class OwnRuntimeException extends RuntimeException {
    public OwnRuntimeException() {
    }

    public OwnRuntimeException(String message) {
        super(message);
    }

    public OwnRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public OwnRuntimeException(Throwable cause) {
        super(cause);
    }
}
