package constants;

public enum Variables {

    USER_FIRSTNAME_ONE("koval"),
    USER_FIRSTNAME_TWO("jiko"),
    USER_FIRSTNAME_THREE("geunjk"),
    USER_LASTNAME_ONE("Nikko"),
    USER_LASTNAME_TWO("Bob"),
    USER_LASTNAME_THREE("Vgo"),
    ZIP_CODE_ONE("19115"),
    ZIP_CODE_TWO("18978"),
    ZIP_CODE_THREE("15666");

    private String value;

    Variables(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}