package az.ingress.msuser.client;

import az.ingress.msuser.model.request.SaveOrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Profile(value = "default")
@FeignClient(name = "ms-orders",
        url = "http://localhost:8082")
public interface OrderClient {

    @PostMapping("/v1/orders")
    void saveOrder(@RequestBody SaveOrderRequest request);
}
