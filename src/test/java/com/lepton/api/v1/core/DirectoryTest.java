package com.lepton.api.v1.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectoryTest {

	@Test
	void getPath() {
		final Directory root = new Directory(null, "rootDir");

		final Directory sub1 = new Directory(root, "sub1");
		final Directory sub2 = new Directory(root, "sub2");

		final Directory sub3 = new Directory(sub2, "sub3");

		assertEquals("/rootDir/", root.getPath());
		assertEquals("/rootDir/sub1/", sub1.getPath());
		assertEquals("/rootDir/sub2/", sub2.getPath());
		assertEquals("/rootDir/sub2/sub3/", sub3.getPath());
	}
}
