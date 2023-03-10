package article.NPlusOneDemoArticle.service;

import article.NPlusOneDemoArticle.model.internal.order.OrderItem;
import article.NPlusOneDemoArticle.model.response.OrderResponse;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AggregationService {

  private final ReactExchangeMockService exchangeReactService;
  private final ExchangeMockService exchangeService;
  private final MapperService mapperService;

  public Mono<OrderResponse> getOrderResponse(int orderId) {

    return exchangeReactService
        .getOrder(orderId) // get order from the external service
        .flatMap(
            order ->
                Mono.zip(
                    Mono.just(order), //save an order info
                    Flux.fromIterable(order.getOrderItems())
                        .flatMapSequential(// saving order
                            orderItem ->
                                Mono.zip(
                                    Mono.just(orderItem), //save an item info
                                    exchangeReactService.getProduct(
                                        orderItem.getProductId())
                                    // get product from the external service
                                )
                        )
                        .collectList()
                )
        )
        .map(mapperService::map);//map tuples to OrderResponse
  }

  public OrderResponse getOrderResponseWrong(int orderId) {
    var order = exchangeService.getOrder(orderId); // get order from the external service

    var products = order.getOrderItems().stream()
        .map(OrderItem::getProductId)
        .map(exchangeService::getProduct)// get order from the external service
        .collect(Collectors.toList());

    return mapperService.map(order, products);//map to OrderResponse

  }
}
