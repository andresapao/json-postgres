package com.studies.jsonb.entities;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import com.studies.jsonb.entites.Properties;
import com.studies.jsonb.entites.UserProperties;
import com.studies.jsonb.repositories.UserPropertiesRepository;
import com.studies.jsonb.repositories.UserPropertiesValueSpecification;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(
		replace = AutoConfigureTestDatabase.Replace.NONE
)
@DataJpaTest
public class UserPropertiesTest {
	@Autowired
	private UserPropertiesRepository repository;

	@Test
	void shouldListAll() {
		var saved = repository.findAll();
		Assert.notNull(saved);
	}

	@Test
	void shouldCreateAndFindUsingNativeQuery() {
		var userProperties = UserProperties.builder().userId( UUID.randomUUID() )
				.properties( Properties.builder().description( "prop1" ).value( "value1" ).build() ).build();
		var saved = repository.save( userProperties );
		Assert.notNull(saved.getProperties());
		var ret = repository.findByPropertiesDescription("prop1");
		Assert.hasText( ret.get().getProperties().getValue(), "value1" );
	}

	@Test
	void shouldCreateAndFindUsingSpecification() {
		var userProperties = UserProperties.builder().userId( UUID.randomUUID() )
				.properties( Properties.builder().description( "prop1" ).value( "value2" ).build() ).build();
		var saved = repository.save( userProperties );
		Assert.notNull(saved.getProperties());
		var spec = new UserPropertiesValueSpecification("value2");
		var ret = repository.findAll( spec );
		Assert.hasText( ret.get(0).getProperties().getValue(), "value2" );
	}

}
