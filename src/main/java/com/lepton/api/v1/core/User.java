package com.lepton.api.v1.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class User implements Resource {
	private final ResourceType type = Const.ResourceTypes.USER;

	private final long id;
	private final String loginIdentifier;


	private final boolean systemUser;

	public User(long id, String loginIdentifier) {
		this(id, loginIdentifier, false);
	}


	User(long id, String loginIdentifier, boolean systemUser) {
		this.id = id;
		this.loginIdentifier = loginIdentifier;
		this.systemUser = systemUser;
	}
}
