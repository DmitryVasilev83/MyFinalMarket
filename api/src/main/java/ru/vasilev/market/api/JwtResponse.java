package ru.vasilev.market.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class JwtResponse {
    private String token;
    private boolean visibleAdministrationButton;
    private boolean visibleProductPanelButton;
    private boolean visibleUserPanelButton;
    private boolean visibleEditRoleButton;
}
