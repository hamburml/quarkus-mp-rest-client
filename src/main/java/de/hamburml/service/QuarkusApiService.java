package de.hamburml.service;

import de.hamburml.QuarkusApiRestClient;
import de.hamburml.provider.RestClients.QuarkusApiRestClientBuilder;

import java.util.Set;

public class QuarkusApiService {

    QuarkusApiRestClientBuilder quarkusApiRestClientBuilder;

    public QuarkusApiService() {
        this.quarkusApiRestClientBuilder = new QuarkusApiRestClientBuilder().withDefaults();
    }

    public void registerProviders() {

    }

    public Set<QuarkusApiRestClient.Extension> getExtensionsById(String s) {
        return this.quarkusApiRestClientBuilder.withDefaults().build().getExtensionsById(s);
    }
}
