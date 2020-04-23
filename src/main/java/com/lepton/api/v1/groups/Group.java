package com.lepton.api.v1.groups;

import com.lepton.api.v1.core.Const;
import com.lepton.api.v1.core.Directory;
import com.lepton.api.v1.core.Resource;
import com.lepton.api.v1.roles.Role;
import lombok.*;

import java.util.Set;


/**
 * Set of users and Roles.
 *
 * @see com.lepton.api.v1.users.User
 * @see com.lepton.api.v1.roles.Role
 */
@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
@Builder(toBuilder = true)
public class Group implements Resource {
	private final Directory type = Const.ResourceTypes.GROUP;

	private final long id;
	private final String name;
	private final String description;

	@Singular
	private final Set<Role> roles;

	@Singular
	private final Set<Role> users;

}
