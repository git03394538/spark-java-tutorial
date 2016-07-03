package com.ianchiu.sparkjavatutorial;

import com.ianchiu.sparkjavatutorial.controller.UserController;

import static spark.Spark.*;
import static spark.SparkBase.port;

/**
 * Created by ian on 6/27/16.
 */
public class Main {
    public static void main(String args[]) {
        if (args.length == 0) {
            port(8080);
        } else {
            port(Integer.parseInt(args[0]));
        }

        options("/*", (req, res) -> {
            String accessControlRequestHeaders = req.headers("Access-Control-Request-Headers");
            if (null != accessControlRequestHeaders) {
                res.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = req.headers("Access-Control-Request-Method");
            if (null != accessControlRequestMethod) {
                res.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });

        before((req, res) -> res.header("Access-Control-Allow-Origin", "*"));
        after((req, res) -> res.type("application/json"));

        new UserController();
    }
}
