package com.lepton.api.v1.core;

public class Exceptions {


	public class AlreadyExists extends Exception {

		public AlreadyExists(String uri) {
			super("CREATE failed: Resource already exists [" + uri + "]");
		}

	}

	public class NotFound extends Exception {
		public NotFound(String uri) {
			super("GET failed: Resource not found [" + uri + "]");
		}
	}


	public class InsufficientPrivs extends Exception {
		public InsufficientPrivs(Verb verb, String uri) {
			super(verb.name() + " failed: Insufficient privileges [" + uri + "]");
		}
	}
}
