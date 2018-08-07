package io.vertx.examples;

import io.vertx.core.AbstractVerticle;

public class MyVerticle extends AbstractVerticle {

  @Override
  public void start() {
	  System.out.println("Use maven to control version!");
	  vertx.createHttpServer()
        .requestHandler(req -> req.response().end("Hello World!"))
        .listen(8080);
  }
}
