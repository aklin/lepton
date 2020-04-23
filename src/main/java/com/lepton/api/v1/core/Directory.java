package com.lepton.api.v1.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@EqualsAndHashCode
public class Directory {
	private final Directory parent;

	@NotEmpty
	private final String name;

	@NotEmpty
	private final String path;

	private final boolean root;

	public Directory(final Directory parent, final String name) {
		this.root = parent == null;
		this.name = name;
		this.parent = parent;

		if (parent != null) {
			this.path = parent.getPath() + name + "/";
		} else {
			this.path = "/" + name + "/";
		}
	}
}
