package tek.tdd.api.models;

import lombok.Getter;

@Getter
public enum EndPoints {
    TOKEN("/api/token"),
    GET_ACCOUNT("/api/accounts/get-account");

    private final String value;

    EndPoints(String value) {
        this.value = value;
    }
}