package com.lepton.api.v1.roles;


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
public class Permission {
	@Singular
	private final Set<ResourceType> resourceTypes;
	private final boolean canCreate;
	private final boolean canRead;
	private final boolean canUpdate;
	private final boolean canDelete;
}
