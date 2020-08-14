package com.tacos.tacocloud.rest;

import com.tacos.tacocloud.model.Taco;
import com.tacos.tacocloud.repository.jpa.TacoJpaRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Sophia Klocheva
 * on 7/31/2020
 * <p>
 * RepositoryRestController that adds custom to the deffault Spring Data REST path.
 */
@RepositoryRestController
public class DesignTacoSpringApi
{
    private final TacoJpaRepository tacoRepository;

    public DesignTacoSpringApi(TacoJpaRepository tacoRepository)
    {
        this.tacoRepository = tacoRepository;
    }

    @RequestMapping(path = "/repositoryRestControllerTest", method = RequestMethod.GET)
    @ResponseBody
    public List<Taco> recentTacos()
    {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        List<Taco> tacos = tacoRepository.findAll(page).getContent();
        return tacos;
    }
}
