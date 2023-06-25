package de.hamburml.service;

import de.hamburml.RestClients.QuarkusApiRestClient;
import de.hamburml.RestClients.QuarkusApiRestClientBuilder;

import java.util.Optional;
import java.util.Set;

public class QuarkusApiService {

    QuarkusApiRestClientBuilder quarkusApiRestClientBuilder;

    QuarkusApiRestClient quarkusApiRestClient;

    public QuarkusApiService() {
        this.quarkusApiRestClientBuilder = new QuarkusApiRestClientBuilder().withDefaults();
    }

    public void registerProviders() { }

    public Set<QuarkusApiRestClient.Extension> getExtensionsById(String s) {
        if (quarkusApiRestClient == null) {
            quarkusApiRestClient = buildClient();
        }
        return quarkusApiRestClient.getExtensionsById(s);
    }

    private QuarkusApiRestClient buildClient() {
        this.quarkusApiRestClientBuilder.withDefaults();
        this.registerProviders();
        return this.quarkusApiRestClientBuilder.build();
    }
}
