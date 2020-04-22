package com.lepton.api.v1.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceTypeTest {

	@Test
	void getPath() {
		final ResourceType root = new ResourceType(null, "rootDir");

		final ResourceType sub1 = new ResourceType(root, "sub1");
		final ResourceType sub2 = new ResourceType(root, "sub2");

		final ResourceType sub3 = new ResourceType(sub2, "sub3");

		assertEquals("/rootDir/", root.getPath());
		assertEquals("/rootDir/sub1/", sub1.getPath());
		assertEquals("/rootDir/sub2/", sub2.getPath());
		assertEquals("/rootDir/sub2/sub3/", sub3.getPath());
	}
}
