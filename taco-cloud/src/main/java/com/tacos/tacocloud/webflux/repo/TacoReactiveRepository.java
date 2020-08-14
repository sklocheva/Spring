package com.tacos.tacocloud.webflux.repo;

import com.tacos.tacocloud.model.Taco;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sophia Klocheva
 * on 8/11/2020
 */
@EnableJpaRepositories
@Repository
public interface TacoReactiveRepository extends ReactiveCrudRepository<Taco, Long>
{
}
