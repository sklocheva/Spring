package com.globomantics.globomantics.employee;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@EqualsAndHashCode
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    // ApiModelProp overrides the @NotNull
    @NotNull
    @ApiModelProperty(value = "first and last name", required = true)
    public String name;
    public String title;
    @NotNull
    public String department;

    protected Employee()
    {
    }

    public Employee(String name, String title, String department)
    {
        this.name = name;
        this.title = title;
        this.department = department;
    }
}
