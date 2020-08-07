package com.tacos.tacocloud.reactive;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.stream.Stream;

/**
 * @author Sophia Klocheva
 * on 8/7/2020
 */

@RunWith(SpringRunner.class)
public class ReactiveFluxCreationTest
{
    private Flux<String> fruitFlux;

    @Before
    public void createFlux()
    {
        //create Publisher
        fruitFlux = Flux
                .just("Apple", "Orange", "Grape", "Banana", "Strawberry");

        //from array
        String[] fruits = new String[]{
                "Apple", "Orange", "Grape", "Banana", "Strawberry"};
        fruitFlux.fromArray(fruits);

        //from stream
        Stream<String> fruitStream =
                Stream.of("Apple", "Orange", "Grape", "Banana", "Strawberry");
        fruitFlux.fromStream(fruitStream);
    }

    @Test
    public void testAddSubscriber()
    {
        //add subscriber
        fruitFlux.subscribe(
                f -> System.out.println("Here's some fruit: " + f)
        );
    }

    @Test
    public void testWithStepVerifier()
    {
        StepVerifier.create(fruitFlux)
                .expectNext("Apple")
                .expectNext("Orange")
                .expectNext("Grape")
                .expectNext("Banana")
                .expectNext("Strawberry")
                .verifyComplete();
    }

    @Test
    public void testFluxRange()
    {
        Flux<Integer> intervalFlux = Flux.range(1, 5);

        StepVerifier.create(intervalFlux)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(4)
                .expectNext(5)
                .verifyComplete();
    }

    @Test
    public void testFluxInterval()
    {
        Flux<Long> intervalFlux = Flux.interval(Duration.ofSeconds(1)).take(5);

        StepVerifier.create(intervalFlux)
                .expectNext(0L)
                .expectNext(1L)
                .expectNext(2L)
                .expectNext(3L)
                .expectNext(4L)
                .verifyComplete();
    }
}
