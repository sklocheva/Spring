package com.spel.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Sophia Klocheva
 * on 8/26/2020
 */
@Component("user")
public class User
{
    @Value("#{'John Doe'}")
    private String name;
    private String country;
    @Value("#{30}")
    private int age;
    private String language;
    private String timeZone;

//    public User(@Value("#{systemProperties['user.name']}") String name, @Value("#{systemProperties['user.country']}") String country)
//    {
//        this.name = name;
//        this.country = country;
//    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getTimeZone()
    {
        return timeZone;
    }

    @Value("#{systemProperties['user.timezone']}")
    public void setTimeZone(String timeZone)
    {
        this.timeZone = timeZone;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                ", language='" + language + '\'' +
                ", timeZone='" + timeZone + '\'' +
                '}';
    }
}
