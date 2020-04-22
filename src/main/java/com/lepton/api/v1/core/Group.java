package com.lepton.api.v1.core;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Set;


@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class Group implements Resource {
	private final ResourceType type = Const.ResourceTypes.GROUP;

	private final long id;
	private final String name;
	private final String description;
}
