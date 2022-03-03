package com.studies.jsonb.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import com.studies.jsonb.repositories.UserPropertiesBinaryTypeRepository;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(
		replace = AutoConfigureTestDatabase.Replace.NONE
)
@DataJpaTest

public class UserPropertiesJsonNodeTypeTest {
	@Autowired
	private UserPropertiesBinaryTypeRepository repository;

	@Test
	void shouldListAll() {
		var saved = repository.findAll();
		Assert.notNull(saved);
	}

}
