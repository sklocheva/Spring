package com.tacos.tacoreactive.webflux;

import com.tacos.tacoreactive.model.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Sophia Klocheva
 * on 8/11/2020
 */

@RestController
@RequestMapping(path = "webflux/tacos", produces = "application/json")
@CrossOrigin(origins = "*")
@Slf4j
public class DesignTacoReactiveController
{
    private final TacoRepository repository;

    @Autowired
    public DesignTacoReactiveController(TacoRepository repository)
    {
        this.repository = repository;
    }


    /**
     * Return a collection of values.
     *
     * @return
     */
    @GetMapping("/recent")
    public Flux<Taco> recentTacos()
    {
        log.info("IN recent tacos");
        return repository.findAll().take(12);
    }

    /**
     * Returning one value.
     *
     * @param id
     * @return
     */
    @GetMapping
    public Mono<Taco> tacoById(@PathVariable("id") Long id)
    {
        return repository.findById(id);
    }

    /**
     * Reactive non-blocking input data.
     *
     * @param tacoMono
     * @return
     */
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Taco> postTaco(@RequestBody Mono<Taco> tacoMono)
    {
        return repository.saveAll(tacoMono).next();
    }
}
