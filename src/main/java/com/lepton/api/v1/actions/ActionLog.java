package com.lepton.api.v1.actions;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ActionLog {

	public static void queue(final Action action) {
		try {
			action.exec();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkPermission(final Action action) {
		return false;
	}
}
