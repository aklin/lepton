package com.lepton.api.v1.roles;


import com.lepton.api.v1.core.ResourceType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@RequiredArgsConstructor
public class Permission {
	private final Set<ResourceType> resourceTypes;
	private final boolean canCreate;
	private final boolean canRead;
	private final boolean canUpdate;
	private final boolean canDelete;
}
