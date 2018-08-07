package io.vertx.examples;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * This verticle uses the Maven Service Factory to deploy `my-verticle`.
 */
public class MyDeployingVerticle extends AbstractVerticle {

   public static void main(String[] args) {
		 Runner.runExample(MyDeployingVerticle.class);
   }
  @Override
  public void start(Future<Void> future) throws Exception {
    // The `my-verticle` is deployed using the following convention:
    // `maven:` + groupId + `:` + artifactId + `:` + version + `::` + verticle name
	System.out.println("Start...");
    vertx.deployVerticle("maven:io.vertx:maven-service-factory-verticle:3.5.3::my-verticle",
        ar -> {
          if (ar.succeeded()) 
          {
        	System.out.println("succeed");
            future.complete();
          } else {
            future.fail(ar.cause());
          }
        }
    );
  }
}
