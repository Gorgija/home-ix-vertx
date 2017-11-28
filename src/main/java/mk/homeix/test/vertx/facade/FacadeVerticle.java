package mk.homeix.test.vertx.facade;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

/**
 *
 * @author georgy
 */
public class FacadeVerticle extends AbstractVerticle {

    @Override
    public void stop() throws Exception {
        
    }

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);
        
        router.get("/").handler(this::rootHandler);
        
        
        vertx.createHttpServer().requestHandler(router::accept).listen(8080, hndlr -> {
            if(hndlr.succeeded()) {
                System.out.println("Server is listening at port 8080  -> Result: " + hndlr.result());
                
            } else {
                System.out.println("Error happened: " + hndlr.cause());
//                hndlr.cause();
            }
        });
        
    }
    
    
    
    private void rootHandler(RoutingContext rc) {
        rc.response().end(System.currentTimeMillis()+"");
    }
    
}
