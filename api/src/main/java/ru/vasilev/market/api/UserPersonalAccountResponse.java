package ru.vasilev.market.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPersonalAccountResponse {
    private String username;
    private String email;
    private String fullName;
}
