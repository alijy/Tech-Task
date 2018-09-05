package com.alikarami.employees;

import spark.Spark;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.modelAndView;

public class Main {

    public static void main(String[] args) {


//        get("/person", (request, response) -> {
//            Map<String, String> model = new HashMap<>();
//            modelAndView(model, "/person");
//            return "Another Person";
//        });

        get("/person", (request, response) -> {
            response.type("application/json");
            return "{\"name\":\"ali\" , \"gender\":\"male\"}";
        });


        Spark.redirect.get("/*", "/person");

    }
}
