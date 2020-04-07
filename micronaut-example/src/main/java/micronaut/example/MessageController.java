package micronaut.example;


import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @Get(value = "/hello/{name}", produces = MediaType.TEXT_PLAIN)
    String hello(String name) {
        return messageService.sayHello(name);
    }
}
