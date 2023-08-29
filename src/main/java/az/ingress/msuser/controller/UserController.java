package az.ingress.msuser.controller;

import az.ingress.msuser.dto.request.SaveUserRequest;
import az.ingress.msuser.dto.response.UserResponse;
import az.ingress.msuser.model.request.SaveOrderRequest;
import az.ingress.msuser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    @ResponseStatus(OK)
    public UserResponse getUserByUsername(@RequestParam String username) {
        return userService.findUserByUsername(username);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void saveUser(@RequestBody SaveUserRequest request) {
        userService.saveUser(request);
    }

    @PostMapping("/order")
    public void createOrder(@RequestBody SaveOrderRequest request){
        userService.createOrder(request);
    }

}
