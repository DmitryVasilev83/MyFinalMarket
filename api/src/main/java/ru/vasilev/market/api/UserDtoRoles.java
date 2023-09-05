package ru.vasilev.market.api;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserDtoRoles {
    private List<String> roles;
}
