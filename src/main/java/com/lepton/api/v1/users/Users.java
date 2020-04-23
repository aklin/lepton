package com.lepton.api.v1.users;

import com.lepton.api.v1.core.Const;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Users {

	/**
	 * Get current user.
	 *
	 * @return Current user. Never null.
	 */
	public static User getCurrent() {
		return Const.Users.GUEST;
	}
}
