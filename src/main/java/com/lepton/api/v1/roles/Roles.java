package com.lepton.api.v1.roles;

import com.lepton.api.v1.actions.Action;
import com.lepton.api.v1.core.Verb;
import com.lepton.api.v1.store.MemoryStore;
import com.lepton.api.v1.store.Store;
import com.lepton.api.v1.users.Users;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.Set;

@UtilityClass
public class Roles {


	public static Action grantPermission(
		@NonNull final Role role,
		@NonNull final Permission... permissions
	) {
		final Store store = MemoryStore.getSingleton();
		final Role.RoleBuilder builder = role.toBuilder();


		for (final Permission permission : permissions) {
			builder.permission(permission);
		}

		return Action.newAction(Verb.UPDATE,
			Users.getCurrent(),
			builder.build());
	}


	public static Action revokePermission(
		@NonNull final Role role,
		@NonNull final Permission... permissions
	) {
		final Role.RoleBuilder builder = role.toBuilder();
		final Set<Permission> existingPermissions = role.getPermissions();


		for (final Permission permission : permissions) {
			existingPermissions.remove(permission);
		}

		builder.permissions(existingPermissions);

		return Action.newAction(Verb.UPDATE,
			Users.getCurrent(),
			builder.build());
	}
}
