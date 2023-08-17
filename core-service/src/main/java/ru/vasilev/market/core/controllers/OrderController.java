package ru.vasilev.market.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.vasilev.market.api.OrderDto;
import ru.vasilev.market.core.mappers.OrderMapper;
import ru.vasilev.market.core.services.OrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping
    public List<OrderDto> getUserOrders(@RequestHeader String username) {
        return orderService.findUserOrders(username)
                .stream()
                .map(orderMapper::mapOrderToOrderDto)
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/clear")
    public void clearUserOrders(@RequestHeader String username) {
        orderService.deleteOrders(username);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewOrder(@RequestHeader String username) {
        orderService.createNewOrder(username);
    }
}
