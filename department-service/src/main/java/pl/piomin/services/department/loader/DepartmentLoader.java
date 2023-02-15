package pl.piomin.services.department.loader;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.scheduling.annotation.Async;
import jakarta.inject.Singleton;
import net.datafaker.Faker;
import pl.piomin.services.department.model.Department;
import pl.piomin.services.department.repository.DepartmentRepository;

@Singleton
public class DepartmentLoader {

    private final DepartmentRepository repository;

    public DepartmentLoader(DepartmentRepository repository) {
        this.repository = repository;
    }

    @EventListener
    @Async
    public void load(final StartupEvent event) {
        for (int i = 0; i < 10; i++) {
            repository.add(generateData());
        }
    }

    private Department generateData() {
        Faker faker = new Faker();
        Department department = new Department();
        department.setName(faker.commerce().department());
        department.setOrganizationId(faker.number().numberBetween(1L, 4L));
        return department;
    }
}
