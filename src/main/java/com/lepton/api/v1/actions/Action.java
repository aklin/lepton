package com.lepton.api.v1.actions;

import com.lepton.api.v1.core.Resource;
import com.lepton.api.v1.core.Verb;
import com.lepton.api.v1.store.MemoryStore;
import com.lepton.api.v1.store.Store;
import com.lepton.api.v1.users.User;
import lombok.Data;

@Data
public class Action {
	private final Verb verb;
	private final User actor;
	private final Resource subject;

	protected void preExecHook() {

	}

	protected void onSuccessHook(Resource result) {

	}

	protected void onFailureHook(Exception exception) {

	}

	public final boolean hasPermissions() {
		return false;
	}


	public final Resource exec() {
		final Store store = MemoryStore.getSingleton();
		final Resource result;
		try {

			if (!hasPermissions()) {
				throw new RuntimeException();
			}

			preExecHook();

			switch (verb) {
				case CREATE:
					store.initialise(subject);
					result = subject;
					break;
				case READ:
					result = store.get(subject.getURI());
					break;
				case UPDATE:
					result = store.replace(subject);
					break;
				case DELETE:
					result = store.remove(subject);
					break;
				default:
					result = null;
			}

			onSuccessHook(result);
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			onFailureHook(e);
		}

		return null;
	}
}
