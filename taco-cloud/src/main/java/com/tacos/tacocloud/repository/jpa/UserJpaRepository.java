package com.tacos.tacocloud.repository.jpa;

import com.tacos.tacocloud.model.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Sophia Klocheva
 * on 7/20/2020
 */
public interface UserJpaRepository extends CrudRepository<Users, Long>
{
    Users findByUsername(String userName);
}
