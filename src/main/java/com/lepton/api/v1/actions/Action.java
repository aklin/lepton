package com.lepton.api.v1.actions;

import com.lepton.api.v1.core.Exceptions;
import com.lepton.api.v1.core.Resource;
import com.lepton.api.v1.core.User;
import com.lepton.api.v1.core.Verb;
import com.lepton.api.v1.store.MemoryStore;
import com.lepton.api.v1.store.Store;
import lombok.Data;

@Data
public class Action {
	private final Verb verb;
	private final User actor;
	private final Resource subject;

	public void beforeExec() {

	}

	public void postExec(Resource result) {

	}

	public final boolean hasPermissions() {
		return false;
	}


	public final Resource exec() {
		final Store store = MemoryStore.getSingleton();

		try {

			if (!hasPermissions()) {
				throw new Exceptions();
			}

			beforeExec();

			final Resource result;
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

			postExec(result);

			return result;

		} catch (Exceptions e) {
			e.printStackTrace();
		}

		return null;
	}
}
