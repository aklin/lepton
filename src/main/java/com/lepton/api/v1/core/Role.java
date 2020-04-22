package com.lepton.api.v1.core;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class Role {
	private final Set<Permission> permissions;

	@NotEmpty
	private final String name;
	@NotNull
	private final String description;
}
