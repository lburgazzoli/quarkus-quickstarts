package org.acme.restclient;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.StartupEvent;
import org.jboss.resteasy.client.jaxrs.ProxyBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

@ApplicationScoped
public class Application {
    public void onStart(@Observes StartupEvent event) {
        ResteasyClient client = (ResteasyClient) ResteasyClientBuilder.newBuilder().build();
        ResteasyWebTarget target = client.target("http://www.my-service.com");
        target.setChunked(false);

        MyService api = ProxyBuilder.builder(MyService.class, target).build();
        api.sendMessage("bla", new MyMessage());
    }
}
