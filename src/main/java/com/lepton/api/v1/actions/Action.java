package com.lepton.api.v1.actions;

import com.lepton.api.v1.core.Resource;
import com.lepton.api.v1.core.Verb;
import com.lepton.api.v1.store.MemoryStore;
import com.lepton.api.v1.store.Store;
import com.lepton.api.v1.users.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public abstract class Action {
	private final Verb verb;
	private final User actor;
	private final Resource subject;
	private transient boolean hasExecuted = false;

	public static Action newAction(
		Verb verb,
		User actor,
		Resource subject
	) {
		return new DefaultAction(verb, actor, subject);
	}

	protected abstract void preExecHook();

	protected abstract void onSuccessHook(Resource result);

	public final boolean hasPermissions() {
		return false;
	}


	final Resource exec() {
		final Store store = MemoryStore.getSingleton();
		final Resource result;

		if (hasExecuted) {
			throw new RuntimeException("Cannot execute the same action twice");
		}

		hasExecuted = true;

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

	protected abstract void onFailureHook(Exception exception);

	private static class DefaultAction extends Action {

		DefaultAction(
			Verb verb,
			User actor,
			Resource subject
		) {
			super(verb, actor, subject);
		}

		@Override
		protected void preExecHook() {

		}

		@Override
		protected void onSuccessHook(Resource result) {

		}

		@Override
		protected void onFailureHook(Exception exception) {

		}
	}
}
