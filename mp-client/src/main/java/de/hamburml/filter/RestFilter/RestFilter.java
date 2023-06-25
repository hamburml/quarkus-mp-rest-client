package de.hamburml.filter.RestFilter;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import org.jboss.logging.Logger;

import java.io.IOException;

public class RestFilter implements ClientRequestFilter {

    private static final Logger LOG = Logger.getLogger(RestFilter.class);

    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        LOG.info("RestFilter says hello!");
    }
}
