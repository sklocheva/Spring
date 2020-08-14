package com.tacos.tacoreactive.webflux;

import com.tacos.tacoreactive.model.Taco;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author Sophia Klocheva
 * on 8/11/2020
 */
@Repository
public interface TacoRepository extends ReactiveCrudRepository<Taco, Long>
{
    Mono<Taco> save(Mono<Taco> taco);
}
