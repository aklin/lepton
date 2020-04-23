package com.lepton.api.v1.roles;


import com.lepton.api.v1.core.Const;
import com.lepton.api.v1.core.Directory;
import com.lepton.api.v1.core.Resource;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Singular;

import java.util.Set;

/**
 * Grant the following verbs to the associated resources.
 */
@Getter
@Builder(toBuilder = true)
@EqualsAndHashCode
public class Permission implements Resource {

	private final long id;

	@Singular
	private final Set<Directory> directories;
	private final boolean canCreate;
	private final boolean canRead;
	private final boolean canUpdate;
	private final boolean canDelete;

	@Override
	public Directory getType() {
		return Const.ResourceTypes.PERMISSION;
	}
}
