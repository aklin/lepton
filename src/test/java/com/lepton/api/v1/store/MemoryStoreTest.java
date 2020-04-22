package com.lepton.api.v1.store;

import com.lepton.api.v1.core.Const;
import com.lepton.api.v1.core.Exceptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryStoreTest {
	private Store test;

	@BeforeEach
	void clearStore() {
		this.test = new MemoryStore();
		assertTrue(test.isEmpty());
	}

	@Test
	void isEmpty() {
		assertTrue(test.isEmpty());
		test.set(Const.Users.GUEST);
		assertFalse(test.isEmpty());
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
		//set again
		test.set(Const.Users.GUEST);
		assertTrue(test.contains(Const.Users.GUEST));
	}

	@Test
	void initialise() {
		assertFalse(test.contains(Const.Users.GUEST));

		try {
			test.initialise(Const.Users.GUEST);
		} catch (Exceptions.AlreadyExists alreadyExists) {
			fail("initialise failed when it shouldn't");
		}
		assertTrue(test.contains(Const.Users.GUEST));
		try {
			test.initialise(Const.Users.GUEST);
		} catch (Exceptions.AlreadyExists e) {
			return;
		}

		fail("initialise did not fail when it should");
	}

	@Test
	void replace() {
		assertFalse(test.contains(Const.Users.GUEST));
		boolean failed = false;

		try {
			test.replace(Const.Users.GUEST);
		} catch (Exceptions.NotFound notFound) {
			failed = true;
		} finally {
			if (!failed) {
				fail();
			}
		}


		test.set(Const.Users.GUEST);

		try {
			test.replace(Const.Users.GUEST);
		} catch (Exceptions.NotFound notFound) {
			fail();
		}
	}

	@Test
	void remove() {
		assertFalse(test.contains(Const.Users.GUEST));
		boolean failed = false;

		try {
			test.remove(Const.Users.GUEST);
		} catch (Exceptions.NotFound notFound) {
			failed = true;
		} finally {
			if (!failed) {
				fail();
			}
		}


		test.set(Const.Users.GUEST);
		assertTrue(test.contains(Const.Users.GUEST));

		try {
			test.remove(Const.Users.GUEST);
		} catch (Exceptions.NotFound notFound) {
			fail();
		}

	}

	@Test
	void getSingleton() {
		final Store st1 = MemoryStore.getSingleton();
		final Store st2 = MemoryStore.getSingleton();

		assertEquals(st1, st2);
	}
}
