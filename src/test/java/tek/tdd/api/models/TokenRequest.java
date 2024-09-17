package tek.tdd.api.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TokenRequest {

    private String username;
    private String password;

    public TokenRequest() {}

    public TokenRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}