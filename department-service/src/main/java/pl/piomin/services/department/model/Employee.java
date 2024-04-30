package pl.piomin.services.department.model;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Serdeable
public class Employee {

	private Long id;
	private String name;
	private int age;
	private String position;
	
	public Employee(String name, int age, String position) {
		this.name = name;
		this.age = age;
		this.position = position;
	}

}
