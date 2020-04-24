package com.lepton.api.v1.roles;

import com.lepton.api.v1.actions.Action;
import com.lepton.api.v1.core.Verb;
import com.lepton.api.v1.store.MemoryStore;
import com.lepton.api.v1.store.Store;
import com.lepton.api.v1.users.Users;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
		final Role.RoleBuilder builder = role.toBuilder()
			.permissions(new HashSet<>());
		final Set<Permission> existing = new HashSet<>(role.getPermissions());

		builder.clearPermissions();

		existing.removeAll(Arrays.stream(permissions)
			.collect(Collectors.toCollection(
				HashSet::new
			)));

		builder.permissions(existing);

		return Action.newAction(Verb.UPDATE,
			Users.getCurrent(),
			builder.build());
	}
}
