package com.studies.jsonb.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studies.jsonb.entites.UserPropertiesJsonNodeType;

public interface UserPropertiesBinaryTypeRepository extends JpaRepository<UserPropertiesJsonNodeType, UUID> {
}
