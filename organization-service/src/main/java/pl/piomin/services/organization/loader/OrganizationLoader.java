package pl.piomin.services.organization.loader;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.scheduling.annotation.Async;
import jakarta.inject.Singleton;
import net.datafaker.Faker;
import pl.piomin.services.organization.model.Organization;
import pl.piomin.services.organization.repository.OrganizationRepository;

@Singleton
public class OrganizationLoader {


    private final OrganizationRepository repository;

    public OrganizationLoader(OrganizationRepository repository) {
        this.repository = repository;
    }

    @EventListener
    @Async
    public void load(final StartupEvent event) {
        for (int i = 0; i < 10; i++) {
            repository.add(generateData());
        }
    }

    private Organization generateData() {
        Faker faker = new Faker();
        Organization organization = new Organization();
        organization.setName(faker.company().name());
        organization.setAddress(faker.address().fullAddress());
        return organization;
    }
}
