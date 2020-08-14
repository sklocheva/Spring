package com.tacos.tacocloud.reactive;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

import java.time.Duration;

/**
 * @author Sophia Klocheva
 * on 8/7/2020
 */
@RunWith(SpringRunner.class)
public class ReactiveFluxCombineTest
{
    private Flux<String> characterFlux;
    private Flux<String> foodFlux;

    @Before
    public void before()
    {
        characterFlux = Flux
                .just("Garfield", "Kojak", "Barbossa")
                .delayElements(Duration.ofMillis(500));
        foodFlux = Flux
                .just("Lasagna", "Lollipops", "Apples")
                .delaySubscription(Duration.ofMillis(250))
                .delayElements(Duration.ofMillis(500));
    }

    @Test
    public void testMerge()
    {
        Flux<String> mergedFlux = characterFlux.mergeWith(foodFlux);

        StepVerifier.create(mergedFlux)
                .expectNext("Garfield")
                .expectNext("Lasagna")
                .expectNext("Kojak")
                .expectNext("Lollipops")
                .expectNext("Barbossa")
                .expectNext("Apples")
                .verifyComplete();
    }

    @Test
    public void testZip()
    {
        Flux<Tuple2<String, String>> zipFlux = Flux.zip(characterFlux, foodFlux);
        System.out.println("Test***");
        zipFlux.subscribe(
                f -> System.out.println("Result: " + f)
        );

        StepVerifier.create(zipFlux)
                .expectNextMatches(p ->
                        p.getT1().equals("Garfield") &&
                                p.getT2().equals("Lasagna"))
                .expectNextMatches(p ->
                        p.getT1().equals("Kojak") &&
                                p.getT2().equals("Lollipops"))
                .expectNextMatches(p ->
                        p.getT1().equals("Barbossa") &&
                                p.getT2().equals("Apples"))
                .verifyComplete();
    }

    @Test
    public void testZipToObject()
    {
        Flux<String> zippedFlux =
                Flux.zip(characterFlux, foodFlux, (c, f) -> c + " eats " + f);
        zippedFlux.subscribe(
                f -> System.out.println("Result: " + f)
        );
        StepVerifier.create(zippedFlux)
                .expectNext("Garfield eats Lasagna")
                .expectNext("Kojak eats Lollipops")
                .expectNext("Barbossa eats Apples")
                .verifyComplete();

    }
    @Test
    public void firstFlux() {
        Flux<String> slowFlux = Flux.just("tortoise", "snail", "sloth")
                .delaySubscription(Duration.ofMillis(100));
        Flux<String> fastFlux = Flux.just("hare", "cheetah", "squirrel");
        Flux<String> firstFlux = Flux.first(slowFlux, fastFlux);
        StepVerifier.create(firstFlux)
                .expectNext("hare")
                .expectNext("cheetah")
                .expectNext("squirrel")
                .verifyComplete();
    }

}
