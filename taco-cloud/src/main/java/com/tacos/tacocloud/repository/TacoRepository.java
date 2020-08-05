package com.tacos.tacocloud.repository;

import com.tacos.tacocloud.model.Taco;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;

import java.util.Optional;

/**
 * @author Sophia Klocheva
 * on 7/16/2020
 */
public interface TacoRepository
{
    Taco saveTaco(Taco taco);

}
