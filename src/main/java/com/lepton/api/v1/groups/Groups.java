package com.lepton.api.v1.groups;

import com.lepton.api.v1.actions.Action;
import com.lepton.api.v1.core.Verb;
import com.lepton.api.v1.roles.Role;
import com.lepton.api.v1.store.MemoryStore;
import com.lepton.api.v1.store.Store;
import com.lepton.api.v1.users.User;
import com.lepton.api.v1.users.Users;
import lombok.experimental.UtilityClass;

import java.util.Set;

@UtilityClass
public class Groups {

	public static Action addUserToGroup(
		final Group group,
		final User... users
	) {
		return null;
	}

	public static Action removeUserFromGroup(
		final Group group,
		final User... users
	) {
		return null;
	}


	public static Action addRoleToGroup(
		final Group group,
		final Role... roles
	) {
		final Store store = MemoryStore.getSingleton();
		final Group.GroupBuilder builder = group.toBuilder();

		for (final Role role : roles) {
			builder.role(role);
		}

		return Action.newAction(Verb.UPDATE,
			Users.getCurrent(),
			builder.build());
	}


	public static Action removeRoleFromGroup(
		final Group group,
		final Role... roles
	) {
		final Group.GroupBuilder builder = group.toBuilder();
		final Set<Role> existingRoles = group.getRoles();

		for (final Role role : roles) {
			existingRoles.remove(role);
		}

		builder.roles(existingRoles);
		return Action.newAction(Verb.UPDATE,
			Users.getCurrent(),
			builder.build());
	}

}
