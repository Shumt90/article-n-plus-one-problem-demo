package article.NPlusOneDemoArticle.service;

import article.NPlusOneDemoArticle.model.internal.order.Order;
import article.NPlusOneDemoArticle.model.internal.product.Product;
import lombok.Data;
import reactor.core.publisher.Mono;

@Data
public class ReactExchangeMockService {

    Mono<Product> getProduct(int productId){
        return Mono.empty();//todo
    }

    Mono<Order> getOrder(int orderId){
        return Mono.empty();//todo
    }


}
