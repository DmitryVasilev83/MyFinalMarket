package ru.vasilev.market.email.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.vasilev.market.api.StringResponse;
import ru.vasilev.market.email.services.EmailService;
import java.security.Principal;

@RestController
@RequestMapping("/api/v1/subscription")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("/my")
    @ResponseStatus(HttpStatus.CREATED)
    public void subscribeToBackToStock(@RequestParam(name = "productId")int productId, Principal principal){
        emailService.subscribeToBackToStock(productId, principal.getName(), principal.toString());
    }
    @PreAuthorize("hasAuthority('ROLE_MANAGER')")
    @DeleteMapping("/{product-id}")
    public StringResponse sendEmailBackToStock(@PathVariable(name="product-id") int productId){
       return emailService.sendBackToStock(productId);
    }
}
