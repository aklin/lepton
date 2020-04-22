package com.lepton.api.v1.roles;


import com.lepton.api.v1.core.Const;
import com.lepton.api.v1.core.Resource;
import com.lepton.api.v1.core.ResourceType;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Singular;

import java.util.Set;

/**
 * Grant the following verbs to the associated resources.
 */
@Getter
@Builder
@EqualsAndHashCode
public class Permission implements Resource {

	private final long id;

	@Singular
	private final Set<ResourceType> resourceTypes;
	private final boolean canCreate;
	private final boolean canRead;
	private final boolean canUpdate;
	private final boolean canDelete;

	@Override
	public ResourceType getType() {
		return Const.ResourceTypes.PERMISSION;
	}
}
