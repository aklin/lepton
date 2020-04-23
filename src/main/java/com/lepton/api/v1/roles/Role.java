package com.lepton.api.v1.roles;

import com.lepton.api.v1.core.Const;
import com.lepton.api.v1.core.Directory;
import com.lepton.api.v1.core.Resource;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Named set of permissions.
 *
 * @see Permission
 */
@Data
@Builder(toBuilder = true)
public final class Role implements Resource {

	@Singular
	private final Set<Permission> permissions;

	private final long id;

	@NotEmpty
	private final String name;
	@NotNull
	private final String description;

	@Override
	public Directory getType() {
		return Const.ResourceTypes.ROLE;
	}
}
