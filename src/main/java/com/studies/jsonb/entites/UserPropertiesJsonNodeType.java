package com.studies.jsonb.entites;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_properties")
@TypeDefs({
		@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
})
public class UserPropertiesJsonNodeType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private UUID userId;
	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb")
	private JsonNode properties;

}
