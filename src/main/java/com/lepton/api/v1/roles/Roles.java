package com.lepton.api.v1.roles;

import com.lepton.api.v1.groups.Group;
import com.lepton.api.v1.store.MemoryStore;
import com.lepton.api.v1.store.Store;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Roles {
	public static void assignRoleToGroup(
		final Group group,
		final Role... roles
	) {
		final Store store = MemoryStore.getSingleton();
		final Group.GroupBuilder builder = group.toBuilder();

		for (final Role role : roles) {
			builder.role(role);
		}


	}

	public static void assignPermissionToRole(
		final Role role,
		final Permission... permissions
	) {

	}
}
