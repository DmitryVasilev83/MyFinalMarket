package ru.vasilev.market.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.vasilev.market.api.OrderDto;
import ru.vasilev.market.core.mappers.OrderMapper;
import ru.vasilev.market.core.services.OrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import ru.vasilev.market.api.ValueWrapper;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping
    public ValueWrapper<List<OrderDto>> getUserOrders(Principal principal) {
        return new ValueWrapper<>(
                orderService.findUserOrders(principal.getName())
                    .stream()
                    .map(orderMapper::mapOrderToOrderDto)
                    .collect(Collectors.toList()));
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @DeleteMapping("/my")
    public void clearUserOrders(Principal principal) {
        orderService.deleteOrders(principal.getName());
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewOrder(Principal principal) {
        orderService.createNewOrder(principal.getName(), principal.toString());
    }
}
