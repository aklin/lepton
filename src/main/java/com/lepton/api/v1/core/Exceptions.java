package com.lepton.api.v1.core;

public interface Exceptions {


	class AlreadyExists extends Exception {

		public AlreadyExists(String uri) {
			super("CREATE failed: Resource already exists [" + uri + "]");
		}

	}

	class NotFound extends Exception {
		public NotFound(String uri) {
			super("GET failed: Resource not found [" + uri + "]");
		}
	}


	class InsufficientPrivileges extends Exception {
		public InsufficientPrivileges(Verb verb, String uri) {
			super(verb.name() + " failed: Insufficient privileges [" + uri + "]");
		}
	}
}
