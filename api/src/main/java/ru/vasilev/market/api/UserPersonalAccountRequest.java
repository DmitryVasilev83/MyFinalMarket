package ru.vasilev.market.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPersonalAccountRequest {
    private String password;
    private String confirmPassword;
    private String email;
    private String fullName;
}
