package ru.vasilev.market.core.integrations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.vasilev.market.api.CartDto;

@Component
@RequiredArgsConstructor
public class CartServiceIntegration {
    private final WebClient cartServiceWebClient;

    public CartDto getCurrentUserCart(String username, String tokenSecurity) {
        return cartServiceWebClient.get()
                .uri("/api/v1/cart/0")
                .header("username", username)
                .header("roles", getRolesStringFromTokenSecurity(tokenSecurity))
                .retrieve()
                .bodyToMono(CartDto.class)
                .block();
    }

    public void clearCart(String username, String tokenSecurity) {
        cartServiceWebClient.get()
                .uri("/api/v1/cart/0/clear")
                .header("username", username)
                .header("roles", getRolesStringFromTokenSecurity(tokenSecurity))
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    private String getRolesStringFromTokenSecurity(String tokenSecurity) {
        int start = tokenSecurity.indexOf("Granted Authorities");
        String str = tokenSecurity.substring(start);
        int end = str.indexOf("]") + 1;
        return str.substring(0, end).replace("Granted Authorities=", "");
    }
}
