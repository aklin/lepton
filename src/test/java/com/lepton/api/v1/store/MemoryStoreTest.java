package com.lepton.api.v1.store;

import com.lepton.api.v1.core.Const;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryStoreTest {
	private Store test;

	@BeforeEach
	void clearStore() {
		this.test = new MemoryStore();
	}

	@Test
	void contains() {
		assertFalse(test.contains(Const.Users.GUEST));
		assertFalse(test.contains(Const.Users.GUEST.getURI()));

		test.set(Const.Users.GUEST);

		assertTrue(test.contains(Const.Users.GUEST));
		assertTrue(test.contains(Const.Users.GUEST.getURI()));
	}

	@Test
	void testGetAndSet() {
		assertFalse(test.contains(Const.Users.GUEST));
		test.set(Const.Users.GUEST);

		assertEquals(Const.Users.GUEST, test.get(Const.Users.GUEST.getURI()));
		assertTrue(test.contains(Const.Users.GUEST));
	}

	@Test
	void initialise() {
	}

	@Test
	void replace() {
	}

	@Test
	void remove() {
	}

	@Test
	void getSingleton() {
		final Store st1 = MemoryStore.getSingleton();
		final Store st2 = MemoryStore.getSingleton();

		assertEquals(st1, st2);
	}
}
