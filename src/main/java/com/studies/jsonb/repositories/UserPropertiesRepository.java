package com.studies.jsonb.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.studies.jsonb.entites.UserProperties;
@Repository
public interface UserPropertiesRepository  extends JpaRepository<UserProperties, UUID>,
		JpaSpecificationExecutor<UserProperties> {
	@Query(value = "SELECT u.* FROM user_properties u WHERE u.properties->>'description' = :description", nativeQuery = true)
	Optional<UserProperties> findByPropertiesDescription(@Param("description") String description);

}
