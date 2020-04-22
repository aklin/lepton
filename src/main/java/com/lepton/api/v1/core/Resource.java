package com.lepton.api.v1.core;

public interface Resource {
	long getId();

	ResourceType getType();

	default String getURI() {
		return getType().getPath() + getId() + "/";
	}

}
