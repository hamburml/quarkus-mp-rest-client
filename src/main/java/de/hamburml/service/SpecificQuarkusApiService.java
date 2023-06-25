package de.hamburml.service;

import de.hamburml.filter.RestFilter.RestFilter;

public class SpecificQuarkusApiService extends QuarkusApiService {

    public void registerProviders() {
        this.quarkusApiRestClientBuilder.registerProvider(RestFilter.class);
    }
}
