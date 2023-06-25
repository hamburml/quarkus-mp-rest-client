package de.hamburml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.hamburml.RestClients.QuarkusApiRestClient;
import de.hamburml.service.SpecificQuarkusApiService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/quarkusapi")
@ApplicationScoped
public class QuarkusApiResource {

    @Inject
    ObjectMapper objectMapper;

    SpecificQuarkusApiService quarkusApiService;

    @Inject
    @RestClient
    QuarkusApiRestClient quarkusApiRestClient;


    @PostConstruct
    public void setup() {
        quarkusApiService = new SpecificQuarkusApiService();
    }

    @GET
    @Path("v1")
    @Produces(MediaType.TEXT_PLAIN)
    // this demonstrates the simple mp rest client usage
    public String v1() throws JsonProcessingException {
        var test = quarkusApiRestClient.getExtensionsById("io.quarkus:quarkus-rest-client");
        return "Hello RESTEasy" + objectMapper.writeValueAsString(test);
    }

    @GET
    @Path("v2")
    @Produces(MediaType.TEXT_PLAIN)
    // this demonstrates the mp rest client mapped inside a service
    public String v2() throws JsonProcessingException {
        var test = this.quarkusApiService
                    .getExtensionsById("io.quarkus:quarkus-rest-client");
        return "Hello RESTEasy" + objectMapper.writeValueAsString(test);
    }
}
