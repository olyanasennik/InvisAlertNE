package constants;

public enum LoginNames {

    STANDARD_USER("standard_user"),
    LOCKED_OUT_USER("locked_out_user"),
    PROBLEM_USER("problem_user"),
    PERFOMANCE_GLITCH_USER("performance_glitch_user"),
    ERROR_USER("error_user"),
    VISUAL_USER("visual_user");


    private String value;

    LoginNames(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
