package com.epam.lesson.validation;

public class ValidationClient {
    private static final Validator VALIDATOR = Validator.newInstance(ValidationClient.class);

    private String value;

    public void setValue(String value) {
        VALIDATOR.assertNotNull(value);
        this.value = value;
    }

    public static void main(String[] args) {
        final ValidationClient client = new ValidationClient();
        client.setValue(null);
    }
}
