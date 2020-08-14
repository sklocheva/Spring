package com.tacos.tacocloud.webflux;

import com.tacos.tacocloud.model.Taco;
import com.tacos.tacocloud.webflux.repo.TacoReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author Sophia Klocheva
 * on 8/11/2020
 */

@RestController
@RequestMapping(path = "webflux/tacos", produces = "application/json")
public class DesignTacoReactiveController
{
    private final TacoReactiveRepository repository;

    @Autowired
    public DesignTacoReactiveController(TacoReactiveRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/recent")
    public Flux<Taco> recentTacos()
    {
        return repository.findAll().take(12);
    }
}
