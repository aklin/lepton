package com.lepton.api.v1.store;

import com.lepton.api.v1.core.Resource;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
public class MemoryStore implements Store {
	private static final Store singleton;

	static {
		singleton = new MemoryStore();
	}

	private final Map<String, Resource> store;

	MemoryStore() {
		store = new HashMap<>(128);
	}

	@Override
	public boolean contains(final String uri) {
		return store.containsKey(uri);
	}

	@Override
	public boolean contains(Resource resource) {
		return contains(resource.getURI());
	}

	@Override
	public Resource get(String uri) {
		return store.get(uri);
	}

	@Override
	public Store set(Resource resource) {
		store.put(resource.getURI().intern(), resource);
		return this;
	}

	@Override
	public Store initialise(Resource resource) {
		if (store.containsKey(resource.getURI())) {
			throw new RuntimeException();
		}

		return set(resource);
	}

	@Override
	public Resource replace(Resource resource) {
		if (!store.containsKey(resource.getURI())) {
			throw new RuntimeException();
		}

		return store.put(resource.getURI().intern(), resource);

	}

	@Override
	public Resource remove(Resource resource) throws RuntimeException {
		if (!store.containsKey(resource.getURI())) {
			throw new RuntimeException();
		}

		return store.remove(resource.getURI());
	}

	public static Store getSingleton() {
		return singleton;
	}
}
