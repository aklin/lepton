package com.lepton.api.v1.core;

public interface Resource {
	long getId();

	Directory getType();

	default String getURI() {
		return getType().getPath() + getId() + "/";
	}

}
