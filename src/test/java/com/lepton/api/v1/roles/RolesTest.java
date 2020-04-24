package com.lepton.api.v1.roles;

import com.lepton.api.v1.actions.Action;
import com.lepton.api.v1.core.Verb;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RolesTest {
	private static int roleCount = 0;
	private static int permCount = 0;

	private Permission testPermission() {
		return Permission.builder().id(permCount++).build();
	}

	private Role testRole() {
		return Role.builder().id(roleCount++).name("unit-test").build();
	}

	@Test
	void addPermissionToRole() {

		final Role role = testRole();
		final Permission permission1 = testPermission(), permission2 = testPermission(), permission3 = testPermission(), permission4 = testPermission();
		final Set<Permission> newPermissions = new HashSet<>();
		final Action result;
		final Role newRole;

		assertEquals(0, role.getPermissions().size());
		result = Roles.grantPermission(role,
			permission1,
			permission2,
			permission4,
			permission3);
		newRole = ((Role) result.getSubject());
		assertEquals(4, newRole.getPermissions().size());

		newPermissions.add(permission1);
		newPermissions.add(permission2);
		newPermissions.add(permission3);
		newPermissions.add(permission4);

		assertTrue(newRole.getPermissions().containsAll(newPermissions));


		assertEquals(Verb.UPDATE, result.getVerb());
	}

	@Test
	void removePermissionFromRole() {
		final Role role = testRole();
		final Permission permission = testPermission();
		final Action result;
		final Role newRole1, newRole2;

		assertEquals(0, role.getPermissions().size());
		newRole1 = ((Role) Roles.grantPermission(role, permission)
			.getSubject());

		assertTrue(newRole1.getPermissions().contains(permission));

		newRole2 = (Role) Roles.revokePermission(newRole1, permission)
			.getSubject();
		assertTrue(newRole2.getPermissions().isEmpty());

	}

}
