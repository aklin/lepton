package com.lepton.api.v1.actions;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ActionLog {

	public static boolean exec(final Action action) {
		try {
			action.exec();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean checkPermission(final Action action) {
		return false;
	}
}
