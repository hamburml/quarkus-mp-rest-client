package de.hamburml.service;

import de.hamburml.RestClients.QuarkusApiRestClient;
import de.hamburml.RestClients.QuarkusApiRestClientBuilder;

import java.util.Set;

public class QuarkusApiService {

    QuarkusApiRestClientBuilder quarkusApiRestClientBuilder;

    public QuarkusApiService() {
        this.quarkusApiRestClientBuilder = new QuarkusApiRestClientBuilder().withDefaults();
    }

    public void registerProviders() { }

    public Set<QuarkusApiRestClient.Extension> getExtensionsById(String s) {
        this.quarkusApiRestClientBuilder.withDefaults();
        this.registerProviders();
        return this.quarkusApiRestClientBuilder.build().getExtensionsById(s);
    }
}
