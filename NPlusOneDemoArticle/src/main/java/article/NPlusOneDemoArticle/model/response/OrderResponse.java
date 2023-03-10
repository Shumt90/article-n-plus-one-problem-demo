package article.NPlusOneDemoArticle.model.response;

import article.NPlusOneDemoArticle.model.internal.order.OrderItem;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class OrderResponse {
    private int id;
    private List<OrderItem> orderItems;
}
