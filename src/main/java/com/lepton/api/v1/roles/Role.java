package com.lepton.api.v1.roles;

import com.lepton.api.v1.core.Const;
import com.lepton.api.v1.core.Resource;
import com.lepton.api.v1.core.ResourceType;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Named set of permissions.
 *
 * @see Permission
 */
@Data
public final class Role implements Resource {

	private final Set<Permission> permissions;

	private final long id;

	@NotEmpty
	private final String name;
	@NotNull
	private final String description;

	@Override
	public ResourceType getType() {
		return Const.ResourceTypes.ROLE;
	}
}
