package com.lepton.api.v1.core;

import com.lepton.api.v1.users.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Const {
	public static class ResourceTypes {
		public static final ResourceType USER = new ResourceType(null, "user");
		public static final ResourceType PERMISSION = new ResourceType(USER, "permission");
		public static final ResourceType ROLE = new ResourceType(USER, "role");
		public static final ResourceType GROUP = new ResourceType(USER, "group");

		public static final ResourceType ACTION = new ResourceType(USER, "action");
	}

	public static class Users {
		public static final User GUEST = new User(0, "guest", true);
		public static final User SYS = new User(100, "sys", true);
	}

	public static class Magic {
		public static final int STRUCT_INCREMENT = 32;
		public static final long INVALID_ID = -1;
	}
}
