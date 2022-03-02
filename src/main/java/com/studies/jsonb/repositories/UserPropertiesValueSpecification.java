package com.studies.jsonb.repositories;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.studies.jsonb.entites.UserProperties;

public class UserPropertiesValueSpecification implements Specification<UserProperties> {
	private final String value;
	@Override public Predicate toPredicate(Root<UserProperties> root, CriteriaQuery<?> query,
			CriteriaBuilder criteriaBuilder) {
		return criteriaBuilder.equal(
				criteriaBuilder.function(
						"jsonb_extract_path_text",
						String.class,
						root.<String>get("properties"),
						criteriaBuilder.literal("value")),

				this.value);
	}

	public UserPropertiesValueSpecification(String value) {
		this.value = value;
	}
}
