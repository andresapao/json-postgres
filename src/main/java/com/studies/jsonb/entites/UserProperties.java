package com.studies.jsonb.entites;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.json.JsonType;

@TypeDefs({
@TypeDef(name = "json", typeClass = JsonType.class)
})
@Builder
@Getter
@Entity
public class UserProperties {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private UUID userId;
	@Type(type = "json")
	@Column(columnDefinition = "jsonb")
	private com.studies.jsonb.entites.Properties properties;
}
