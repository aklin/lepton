package com.lepton.api.v1.groups;

import com.lepton.api.v1.core.Const;
import com.lepton.api.v1.core.Resource;
import com.lepton.api.v1.core.ResourceType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Group implements Resource {
	private final ResourceType type = Const.ResourceTypes.GROUP;

	private final long id;
	private final String name;
	private final String description;

	public Group(final String name) {
		this(Const.Magic.INVALID_ID, name, "");
	}

	public Group(final String name, final String description) {
		this(Const.Magic.INVALID_ID, name, description.trim());
	}
}
