package com.lepton.kernel;

import com.lepton.api.v1.actions.Action;
import com.lepton.api.v1.actions.ActionLog;
import com.lepton.api.v1.core.*;

public class Bootstrap implements Runnable {

	@Override
	public void run() {

//		ActionLog.exec(create());


	}

	private static Action create(Resource resource) {
		return new Action(Verb.CREATE, Const.Users.SYS, resource);
	}
}
