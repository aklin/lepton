package com.lepton.api.v1.core;

public interface Exceptions {

	abstract class ActionException extends Exception {
		public ActionException(Verb verb, String uri) {
			super(verb.name() + " failed on [" + uri + "]");
		}
	}

	class StoreException extends Exception {

		public StoreException(String uri) {
			super("Storage exception on [" + uri + "]");
		}

	}

	class InsufficientPrivileges extends ActionException {
		public InsufficientPrivileges(Verb verb, String uri) {
			super(verb, uri);
		}
	}
}
