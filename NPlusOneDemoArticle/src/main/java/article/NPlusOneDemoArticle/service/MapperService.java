package article.NPlusOneDemoArticle.service;

import article.NPlusOneDemoArticle.model.internal.order.Order;
import article.NPlusOneDemoArticle.model.internal.order.OrderItem;
import article.NPlusOneDemoArticle.model.internal.product.Product;
import article.NPlusOneDemoArticle.model.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import reactor.util.function.Tuple2;

import java.util.List;

@RequiredArgsConstructor
public class MapperService {
    public OrderResponse map(Tuple2<Order, List<Tuple2<OrderItem, Product>>> response) {
        return null;//todo
    }

    public OrderResponse map(Order order, List<Product> products) {
        return null;
    }
}
