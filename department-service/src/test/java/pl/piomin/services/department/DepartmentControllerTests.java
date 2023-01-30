package pl.piomin.services.department;

import io.micronaut.context.annotation.Property;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.instancio.Instancio;
import org.instancio.Select;
import org.junit.jupiter.api.Test;
import pl.piomin.services.department.model.Department;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
@Property(name = "micronaut.config-client.enabled", value = "false")
public class DepartmentControllerTests {

    @Inject
    EmbeddedServer server;

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void add() {
        Department department = Instancio.of(Department.class)
                .ignore(Select.field(Department::getId))
                .create();
        department = client.toBlocking()
                .retrieve(HttpRequest.POST("/departments", department), Department.class);
        assertNotNull(department);
        assertNotNull(department.getId());
    }

    @Test
    void findAll() {
        Department[] departments = client.toBlocking().retrieve("/departments", Department[].class);
        assertTrue(departments.length > 0);
    }

    @Test
    void findById() {
        Department department = client.toBlocking().retrieve("/departments/1", Department.class);
        assertNotNull(department);
        assertNotNull(department.getId());
    }

}
