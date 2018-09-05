package com.alikarami.employees;

import com.alikarami.employees.model.Person;
import com.alikarami.employees.model.PersonDAO;
import com.alikarami.employees.model.simplePersonDAO;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {


//        /* first approach : returns a string response */
//        get("/person", (request, response) -> "name: ali");



//        /* second approach : returns a json response */
//        get("/person", (request, response) -> {
//            response.type("application/json");
//            return "{\"name\":\"ali\" , \"age\":\"36\"}";
//        });



//        /* third approach : uses a basic model and a view page */
//        get("/person", (request, response) -> {
//            Map<String, String> model = new HashMap<>();
//            model.put("name","ali");
//            model.put("age","36");
//            model.put("nin","ab123456c");
//            return new HandlebarsTemplateEngine().render(
//                    new ModelAndView(model, "index.hbs")
//            );
//        });



        /* fourth approach: uses a model prototype */
        staticFileLocation("/public");
        PersonDAO dao = new simplePersonDAO();

        get("/person", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("person", dao.findAll());
            return new HandlebarsTemplateEngine().render(
                    new ModelAndView(model, "people.hbs")
            );
        });

        post("/person", (request, response) -> {
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String nin = request.queryParams("nin");
            Person person = new Person(name, age, nin);
            dao.add(person);
            response.redirect("/person");
            return null;
        });

        get("/person/:id", (request, response) -> {
            try {
                int id = Integer.parseInt(request.params("id"));
                Person person = dao.get(id);
                if (person != null) {
                    return new HandlebarsTemplateEngine().render(
                            new ModelAndView(person, "person.hbs")
                    );
                }
            }
            catch (Exception e) {
                response.redirect("/person");
            }
            response.redirect("/person");
            return null;
        });


        Spark.redirect.get("/*", "/person");

    }
}
