package de.hamburml.RestClients;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

import java.net.URI;

public class QuarkusApiRestClientBuilder {

    RestClientBuilder quarkusRestApiBuilder;

    public QuarkusApiRestClientBuilder() {
        this.quarkusRestApiBuilder = RestClientBuilder.newBuilder();
    }

    public QuarkusApiRestClient build() {
        return quarkusRestApiBuilder.build(QuarkusApiRestClient.class);
    }

    public QuarkusApiRestClientBuilder withDefaults() {
        this.baseUri("https://stage.code.quarkus.io/api");
        return this;
    }

    public QuarkusApiRestClientBuilder baseUri(String uri) {
        this.quarkusRestApiBuilder.baseUri(URI.create(uri));
        return this;
    }

    public QuarkusApiRestClientBuilder registerProvider(Class<?> clazz) {
        this.quarkusRestApiBuilder.register(clazz);
        return this;
    }

}
