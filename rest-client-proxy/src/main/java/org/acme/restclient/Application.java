package org.acme.restclient;

import java.net.URI;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public void onStart(@Observes StartupEvent event) {
        LOGGER.info("onStart");

        MyService api = RestClientBuilder.newBuilder()
            .baseUri(URI.create("http://www.my-service.com"))
            .register(new JacksonJaxbJsonProvider())
            .build(MyService.class);

        api.sendMessage("bla", new MyMessage());
    }
}
