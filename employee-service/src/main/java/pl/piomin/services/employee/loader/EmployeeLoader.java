package pl.piomin.services.employee.loader;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.scheduling.annotation.Async;
import jakarta.inject.Singleton;
import net.datafaker.Faker;
import pl.piomin.services.employee.model.Employee;
import pl.piomin.services.employee.repository.EmployeeRepository;

@Singleton
public class EmployeeLoader {

    private final EmployeeRepository repository;

    public EmployeeLoader(EmployeeRepository repository) {
        this.repository = repository;
    }

    @EventListener
    @Async
    public void load(final StartupEvent event) {
        for (int i = 0; i < 10; i++) {
            repository.add(generateData());
        }
    }

    private Employee generateData() {
        Faker faker = new Faker();
        Employee employee = new Employee();
        employee.setPosition(faker.job().position());
        employee.setName(faker.name().fullName());
        employee.setAge(faker.number().numberBetween(25, 60));
        employee.setDepartmentId(faker.number().numberBetween(1L, 10L));
        employee.setOrganizationId(faker.number().numberBetween(1L, 4L));
        return employee;
    }
}
