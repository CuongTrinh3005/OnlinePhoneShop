package com.example.onlinephoneshop.enums;

public enum CustomMessages {
    USER_NOT_FOUND("User with ID %s not found."),
    USERNAME_NOT_FOUND("User with username %s not found."),
    AUTHENTICATION_INCORRECT("Incorrect username or/and password."),
    FAIL_TO_DISABLE_TOKEN("Fail to disable the token."),
    LOGOUT_SUCCESS("Logged out successfully."),
    OLD_PASSWORD_INCORRECT("Password is incorrect."),
    FIRSTNAME_NULL("First name cannot be null."),
    LASTNAME_NULL("Last name cannot be null."),
    DOB_NULL("Date of birth cannot be null."),
    LOCATION_NULL("Location cannot be null."),
    AGE_LESS_THAN_18("Age must be older than 18."),
    JOINED_DATE_NULL("Joined date cannot be null."),
    JOINED_DATE_BEFORE_DOB("Joined date must be after Date of Birth."),
    JOINED_DATE_UNAVAILABLE("Joined date is only available from Monday to Friday."),
    USER_CREATED("Account created successfully!"),
    USER_UPDATED("Update successful!"),
    PASSWORD_UPDATED("Your password has been changed successfully!"),
    USER_HAS_BEEN_DISABLED("The corresponding user has been disabled."),
	USER_HAS_VALID_ASSIGNMENT("Can not disable user has valid assignment!"),
    ASSIGNMENT_NOT_FOUND_BY_ASSET_CODE("Assignment with asset code %s not found."),
    ASSIGNMENT_NOT_FOUND("Assignment with ID %s not found."),
    ASSIGNMENT_CREATED("Assignment created successfully!"),
    ASSIGNMENT_UPDATED("Assignment updated successfully!"),
    ASSIGN_DATE_IN_THE_PAST("The assign date is in the past!"),
    ASSIGN_DATE_INVALID("The assigned date being updated can not be before the current assigned date"),
    ASSIGNMENT_NON_EDITABLE("Only assignment in waiting for acceptance can be edited!"),
    ASSET_NOT_FOUND("Asset with id %s not found"),
    CATEGORY_NAME_EXISTED("Category name has existed"),
    CATEGORY_ID_EXISTED("Category id has existed"),
    CATEGORY_PREFIX_NULL("Category prefix is null"),
    CATEGORY_NOT_FOUND("Category with Id %s not found"),
    NOT_DELETE_CATEGORY("Can not delete category has product");

    private final String description;

    private CustomMessages(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
