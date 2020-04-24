package com.lepton.api.v1.roles;

import com.lepton.api.v1.core.Const;
import com.lepton.api.v1.core.Directory;
import com.lepton.api.v1.core.Resource;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Singular;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Named set of permissions.
 *
 * @see Permission
 */
@Getter
@EqualsAndHashCode

public final class Role implements Resource {


	private Set<Permission> permissions;

	private final long id;

	@NotEmpty
	private final String name;
	@NotNull
	private final String description;

	@Override
	public Directory getType() {
		return Const.ResourceTypes.ROLE;
	}

	@Builder(toBuilder = true)
	public Role(
		@Singular
			Set<Permission> permissions,
		long id,
		String name,
		String description
	) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.permissions = new HashSet<>(permissions);
	}
}
