package com.lepton.api.v1.core;

import com.lepton.api.v1.users.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Const {
	public static class ResourceTypes {
		public static final Directory USER = new Directory(null, "user");
		public static final Directory PERMISSION = new Directory(USER,
			"permission");
		public static final Directory ROLE = new Directory(USER, "role");
		public static final Directory GROUP = new Directory(USER, "group");

		public static final Directory ACTION = new Directory(USER, "action");
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
