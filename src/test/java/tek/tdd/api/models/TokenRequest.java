package tek.tdd.api.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class TokenRequest {

    private String username;
    private String password;
}