package article.NPlusOneDemoArticle.model.response;

import lombok.Data;

@Data
public class OrderItemResponse {
    private ProductResponse product;
    private int count;
}
