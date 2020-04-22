package com.lepton.api.v1.utils;

import com.lepton.api.v1.groups.Group;
import com.lepton.api.v1.roles.Permission;
import com.lepton.api.v1.users.User;
import lombok.experimental.UtilityClass;

import java.util.Set;

@UtilityClass
public class UserUtil {
	public static Set<Permission> getPermissionsFor(final User user) {
		return null;
	}

	public static Set<User> getUsersWith(final Permission permission) {
		return null;
	}

	public static Set<User> getUsersIn(final Group group) {
		return null;
	}

}
