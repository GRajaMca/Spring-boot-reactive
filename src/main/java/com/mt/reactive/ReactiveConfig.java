package com.mt.reactive;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Component
public class ReactiveConfig {

	@Bean
	RouterFunction<?> routerFunction(RouterHandler routerHandler) {
		return RouterFunctions.route(RequestPredicates.GET("/getUsers"), routerHandler::getAllUser)
				.andRoute(RequestPredicates.GET("/dataLoad"), routerHandler::loadData);
	}

}
