package com.tacos.tacocloud.repository;

import com.tacos.tacocloud.model.Ingredient;
import com.tacos.tacocloud.model.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Sophia Klocheva
 * on 7/16/2020
 */
@Slf4j
@Repository
public class JdbcTacoRepository implements TacoRepository
{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTacoRepository(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Taco saveTaco(Taco taco)
    {
        log.info("in taco repo");
        long tacoId = saveTacoInfo(taco);
        log.info("log before ingr");
        taco.setId(tacoId);
        for (Ingredient ingredient : taco.getIngredients())
        {
            saveIngredientToTaco(ingredient, tacoId);
        }
        return taco;
    }

    private void saveIngredientToTaco(Ingredient ingredient, long tacoId)
    {
        jdbcTemplate.update(
                "insert into Taco_Ingredients (taco, ingredient) " +
                        "values (?, ?)",
                tacoId, ingredient.getId());
    }

    private long saveTacoInfo(Taco taco)
    {
        taco.setCreatedAt(new Date());
        PreparedStatementCreatorFactory creatorFactory = new PreparedStatementCreatorFactory(
                "insert into Taco (name, createdAt) values (?, ?)",
                Types.VARCHAR, Types.TIMESTAMP
        );
        // By default, returnGeneratedKeys = false
        creatorFactory.setReturnGeneratedKeys(true);

        PreparedStatementCreator statementCreator = creatorFactory
                .newPreparedStatementCreator(
                        Arrays.asList(
                                taco.getName(),
                                new Timestamp(taco.getCreatedAt().getTime())));
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int numRows = jdbcTemplate.update(statementCreator, keyHolder);
        log.info("num rows affected " + numRows);
        if (keyHolder.getKey() == null)
            log.warn("missing key");
        else
            log.info(keyHolder.getKey().toString());
        return keyHolder.getKey().longValue();
    }
}
