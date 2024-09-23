package tek.tdd.api.models;

import lombok.Getter;

@Getter
public enum EndPoints {
    TOKEN("/api/token"),
    GET_PRIMARY_ACCOUNT("/api/accounts/get-primary-account"),
    GET_ALL_PLAN_CODES("/api/plans/get-all-plan-code"),
    ADD_PRIMARY_ACCOUNT("/api/accounts/add-primary-account"),
    USER_PROFILE("/api/user/profile");

    private final String value;

    EndPoints(String value) {
        this.value = value;
    }
}