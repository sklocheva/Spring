package com.tacos.tacocloud.repository.jpa;

import com.tacos.tacocloud.model.Taco;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Sophia Klocheva
 * on 7/20/2020
 * Implementation auto generated by Spring when imported
 */
public interface TacoJpaRepository extends CrudRepository<Taco, Long>
{
    Slice<Taco> findAll(Pageable pageRequest);

    Taco findById(long id);
}
