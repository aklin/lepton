package com.lepton.api.v1.roles;

import com.lepton.api.v1.actions.Action;
import com.lepton.api.v1.core.Verb;
import com.lepton.api.v1.groups.Group;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RolesTest {
	private static int roleCount = 0;
	private static int groupCount = 0;

	private Group testGroup() {
		return Group.builder().name("unit-test-g-" + groupCount++).build();
	}

	private Role testRole() {
		return Role.builder().name("unit-test-r-" + roleCount++).build();
	}

	@Test
	void addRoleToGroup() {
		final Group group = testGroup();
		final Role role1 = testRole(), role2 = testRole(), role3 = testRole(), role4 = testRole();
		final Set<Role> newRoles = new HashSet<>();
		final Action result;
		final Group newGroup;

		assertEquals(0, group.getRoles().size());
		result = Roles.addRoleToGroup(group, role1, role2, role4, role3);
		newGroup = ((Group) result.getSubject());
		assertEquals(4, newGroup.getRoles().size());

		newRoles.add(role1);
		newRoles.add(role2);
		newRoles.add(role3);
		newRoles.add(role4);

		assertTrue(newGroup.getRoles().containsAll(newRoles));


		assertEquals(Verb.UPDATE, result.getVerb());
	}

	@Test
	void removeRoleFromGroup() {
		final Group group = testGroup();
		final Role role1 = testRole();
		final Action result;
		final Group newGroup1, newGroup2;

		assertEquals(0, group.getRoles().size());
		newGroup1 = ((Group) Roles.addRoleToGroup(group, role1).getSubject());

		assertTrue(newGroup1.getRoles().contains(role1));

		result = Roles.removeRoleFromGroup(group, role1);
		newGroup2 = ((Group) Roles.addRoleToGroup(group, role1).getSubject());
		assertTrue(newGroup2.getRoles().isEmpty());

		assertEquals(Verb.UPDATE, result.getVerb());
	}

	@Test
	void addPermissionToRole() {
	}

	@Test
	void removePermissionFromRole() {
	}

}
