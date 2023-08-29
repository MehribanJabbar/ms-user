package az.ingress.msuser.model.request;

import az.ingress.msuser.model.enums.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveOrderRequest {
    Long userId;
    String orderDetails;
    CardType cardType;
}
