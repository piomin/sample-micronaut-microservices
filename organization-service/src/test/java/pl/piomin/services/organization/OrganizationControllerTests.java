package pl.piomin.services.organization;

import io.micronaut.context.annotation.Property;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.instancio.Instancio;
import org.instancio.Select;
import org.junit.jupiter.api.Test;
import pl.piomin.services.organization.model.Employee;
import pl.piomin.services.organization.model.Organization;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
@Property(name = "micronaut.config-client.enabled", value = "false")
public class OrganizationControllerTests {

    @Inject
    EmbeddedServer server;

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void add() {
        Organization organization = Instancio.of(Organization.class)
                .ignore(Select.field(Employee::getId))
                .create();
        organization = client.toBlocking()
                .retrieve(HttpRequest.POST("/organizations", organization), Organization.class);
        assertNotNull(organization);
        assertNotNull(organization.getId());
    }

    @Test
    void findAll() {
        Organization[] organizations = client.toBlocking().retrieve("/organizations", Organization[].class);
        assertTrue(organizations.length > 0);
    }

    @Test
    void findById() {
        Organization organization = client.toBlocking().retrieve("/organizations/1", Organization.class);
        assertNotNull(organization);
        assertNotNull(organization.getId());
    }
}
