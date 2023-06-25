package de.hamburml.RestClients;

import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import java.net.URI;
import java.util.Optional;

public class QuarkusApiRestClientBuilder {

    RestClientBuilder quarkusRestApiBuilder;

    // this is always null
    //@ConfigProperty(name = "quarkus.rest-client.quarkus-api-rest-client.url")
    //Optional<String> baseUri;

    public QuarkusApiRestClientBuilder() {
        this.quarkusRestApiBuilder = RestClientBuilder.newBuilder();
    }

    public QuarkusApiRestClient build() {
        return quarkusRestApiBuilder.build(QuarkusApiRestClient.class);
    }

    public QuarkusApiRestClientBuilder withDefaults() {
        this.baseUri(ConfigProvider.getConfig().getConfigValue("quarkus.rest-client.quarkus-api-rest-client.url").getRawValue());
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
