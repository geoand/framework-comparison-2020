package org.acme;

import javax.inject.Singleton;

import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RoutingExchange;
import io.vertx.core.http.HttpMethod;

@Singleton
public class VertxRoute {

	final MessageService messageService;

	public VertxRoute(MessageService messageService) {
		this.messageService = messageService;
	}

	@Route(path = "/hello/:name", methods = HttpMethod.GET)
	void greetings(RoutingExchange ex) {
		ex.ok(messageService.sayHello(ex.getParam("name").orElse("world")));
	}
}
