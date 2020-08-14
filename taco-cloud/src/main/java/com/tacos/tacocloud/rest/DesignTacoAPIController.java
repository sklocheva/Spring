package com.tacos.tacocloud.rest;

import com.tacos.tacocloud.model.Taco;
import com.tacos.tacocloud.repository.jpa.TacoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author Sophia Klocheva
 * on 7/28/2020
 */
@RestController
// adds controller to Spring REST base path
//@RepositoryRestController
@RequestMapping(path = "api/design", produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoAPIController
{
    private final TacoJpaRepository tacoRepository;

    @Autowired
    public DesignTacoAPIController(TacoJpaRepository tacoRepository)
    {
        this.tacoRepository = tacoRepository;
    }

    @GetMapping(path = "/recent")
    public CollectionModel<EntityModel<Taco>> recentTacos()
    {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        List<Taco> tacos = tacoRepository.findAll(page).getContent();
        CollectionModel<EntityModel<Taco>> recentResources = CollectionModel.wrap(tacos);
//        recentResources.add(Link.of("http://localhost:8080/api/design/recent", "recents"));
        recentResources.add(
                WebMvcLinkBuilder.linkTo(methodOn(DesignTacoAPIController.class).recentTacos())
                        .withRel("recents"));
        return recentResources;
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Taco> getTacoById(@PathVariable("id") long id)
//    {
//        Taco taco = tacoRepository.findById(id);
//        if (taco != null)
//        {
//            return new ResponseEntity<>(taco, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//    }
//
//    @PostMapping(consumes = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Taco createTaco(@RequestBody Taco taco)
//    {
//        return tacoRepository.save(taco);
//    }
}
