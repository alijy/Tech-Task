package com.alikarami.employees;

import com.alikarami.employees.model.PersonDAO;
import com.alikarami.employees.model.simplePersonDAO;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.modelAndView;
import static spark.Spark.staticFileLocation;

public class Main {

    public static void main(String[] args) {

        get("/", (request, response) -> "Coming Soon!");


        /* first approach : returns a string response */
        /*
        get("/person", (request, response) -> "name: ali");
        */

        /* second approach : returns a json response */
        /*
        get("/person", (request, response) -> {
            response.type("application/json");
            return "{\"name\":\"ali\" , \"age\":\"36\"}";
        });
        */

        /* third approach : uses a basic model and a view page */
        get("/person", (request, response) -> {
            Map<String, String> model = new HashMap<>();
            model.put("name","ali");
            model.put("age","36");
            return new HandlebarsTemplateEngine().render(
                    new ModelAndView(model, "index.hbs")
            );
        });


        /* fourth approach: uses a model prototype */
        staticFileLocation("/public");
        PersonDAO dao = new simplePersonDAO();

        get("/person", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return null;
        });



        Spark.redirect.get("/*", "/person");

    }
}
