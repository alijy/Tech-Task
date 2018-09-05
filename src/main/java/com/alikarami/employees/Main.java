package com.alikarami.employees;

import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.modelAndView;

public class Main {

    public static void main(String[] args) {

        get("/", (request, response) -> "Coming Soon!");


        /* first approach */
//        get("/person", (request, response) -> "name: ali");


        /* second approach */
//        get("/person", (request, response) -> {
//            response.type("application/json");
//            return "{\"name\":\"ali\" , \"age\":\"36\"}";
//        });

        /* third approach */
        get("/person", (request, response) -> {
            Map<String, String> model = new HashMap<>();
            model.put("name","ali");
            model.put("age","36");
            return new HandlebarsTemplateEngine().render(
                    new ModelAndView(model, "index.hbs")
            );
        });


        Spark.redirect.get("/*", "/person");

    }
}
