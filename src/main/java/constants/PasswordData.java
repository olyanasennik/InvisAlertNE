package constants;

public enum PasswordData {

    PASSWORD("secret_sauce");

    private String value;

    PasswordData(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
