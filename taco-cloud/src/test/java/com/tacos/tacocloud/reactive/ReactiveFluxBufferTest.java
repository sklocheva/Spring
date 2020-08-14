package com.tacos.tacocloud.reactive;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sophia Klocheva
 * on 8/10/2020
 */
@RunWith(SpringRunner.class)
public class ReactiveFluxBufferTest
{

    @Test
    public void buffer()
    {
        Flux<String> fruitFlux = Flux.just(
                "apple", "orange", "banana", "kiwi", "strawberry");
        Flux<List<String>> bufferedFlux = fruitFlux.buffer(3);

        StepVerifier
                .create(bufferedFlux)
                .expectNext(Arrays.asList("apple", "orange", "banana"))
                .expectNext(Arrays.asList("kiwi", "strawberry"))
                .verifyComplete();

        bufferedFlux.subscribe(
                f -> System.out.println("Here's some fruit: " + f)
        );
    }

    /**
     * FlatMap() takes each List buffer and creates a new Flux from its elements,
     * and then applies a map() operation on it. Each buffered List is further
     * processed in parallel in individual threads.
     */
    @Test
    public void bufferMap()
    {
        Flux.just(
                "apple", "orange", "banana", "kiwi", "strawberry")
                .buffer(3)
                .flatMap(x ->
                        Flux.fromIterable(x)
                                .map(y -> y.toUpperCase())
                                .subscribeOn(Schedulers.parallel())
                                .log()
                ).subscribe();
    }
}
