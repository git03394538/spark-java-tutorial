package com.ianchiu.sparkjavatutorial.controller;

import static com.ianchiu.sparkjavatutorial.utils.JsonUtil.json;
import static spark.Spark.get;

/**
 * Created by ian on 6/27/16.
 */
public class UserController {

    public UserController() {
        get("/users", (request, response) -> "test", json());
    }
}
