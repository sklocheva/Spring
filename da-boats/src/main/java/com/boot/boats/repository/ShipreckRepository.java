package com.boot.boats.repository;

import com.boot.boats.model.Shipwreck;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sophia Klocheva
 * on 2/18/2020
 */
public interface ShipreckRepository extends JpaRepository<Shipwreck, Long>
{
}
