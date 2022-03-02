package com.studies.jsonb.entites;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Properties implements Serializable {
	private String description;
	private String value;
}
