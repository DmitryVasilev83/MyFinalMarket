package ru.vasilev.market.core.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vasilev.market.api.OrderDto;
import ru.vasilev.market.core.entities.Order;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderMapper {
    private final OrderItemMapper orderItemMapper;

    public OrderDto mapOrderToOrderDto (Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.MEDIUM);
        String localDateTimeStr = order.getCreatedAt().format(formatter);
        return OrderDto.builder()
                .id(order.getId())
                .items(order.getItems()
                        .stream()
                        .map(orderItemMapper::mapOrderItemToOrderItemDto)
                        .collect(Collectors.toList()))
                .totalPrice(order.getTotalPrice())
                .createdAtStr(localDateTimeStr)
                .build();
    }

}
