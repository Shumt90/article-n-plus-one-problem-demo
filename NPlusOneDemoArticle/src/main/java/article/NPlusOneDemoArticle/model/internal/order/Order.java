package article.NPlusOneDemoArticle.model.internal.order;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private int id;
    private List<OrderItem> orderItems;
}
