package com.tacos.tacoreactive.config;

import com.tacos.tacoreactive.model.ITaco;
import com.tacos.tacoreactive.model.Taco;
import com.tacos.tacoreactive.webflux.TacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static reactor.core.publisher.Mono.just;


/**
 * @author Sophia Klocheva
 * on 8/11/2020
 */
@Configuration
public class RouterFunctionConfig
{
    @Autowired
    private TacoRepository repository;

    public RouterFunction<?> routerFunction()
    {
        return route(GET("router/tacos/recent"), this::recentTaco)
                .andRoute(POST("router/tacos"), this::postTaco);
    }

    private Mono<ServerResponse> postTaco(ServerRequest serverRequest)
    {
        Mono<Taco> tacoMono = serverRequest.bodyToMono(Taco.class);
        Mono<Taco> savedTaco = repository.save(tacoMono);
        Taco tacoIdHolder = new Taco();
        savedTaco.map(taco ->  taco.getId()).subscribe(f -> tacoIdHolder.setId(f));
        return ServerResponse
                .created(URI.create(
                        "http://localhost:8080/design/taco/" + tacoIdHolder.getId()
                ))
                .body(savedTaco, Taco.class);
    }

    private Mono<ServerResponse> recentTaco(ServerRequest serverRequest)
    {
        return ServerResponse.ok().body(repository.findAll().take(12), Taco.class);
    }

    /**
     * RouterFunction declares mappings between one or more RequestPredicate objects
     * and the functions that will handle the matching request(s).
     * The handler lambda accepts a ServerRequest as a parameter.
     * It returns a ServerResponse using ok().
     *
     * @return
     */
    @Bean
    public RouterFunction<?> helloRouterFunction()
    {
        return route(GET("/hello"),
                request -> ok().body(just("Hello World!"), String.class))
                .andRoute(GET("/bye"),
                        request -> ok().body(just("See ya!"), String.class));
    }
}
