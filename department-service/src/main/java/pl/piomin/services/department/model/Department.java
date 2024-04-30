package pl.piomin.services.department.model;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Serdeable
public class Department {

	private Long id;
	private Long organizationId;
	private String name;
	private List<Employee> employees = new ArrayList<>();

	public Department(Long organizationId, String name) {
		super();
		this.organizationId = organizationId;
		this.name = name;
	}

}
