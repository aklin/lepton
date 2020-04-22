package com.lepton.api.v1.store;

import com.lepton.api.v1.core.Exceptions;
import com.lepton.api.v1.core.Resource;

public interface Store {
	boolean contains(final String uri);

	Resource get(final String uri);

	Store set(final Resource resource);

	/**
	 * Store resource. Will throw exception if another resource with the same URI exists.
	 *
	 * @param resource Resource
	 * @return this
	 * @see #replace(Resource)
	 */
	Store initialise(final Resource resource) throws RuntimeException;

	/**
	 * Replace resource. Will throw exception if a resource with the same URI is not found.
	 *
	 * @param resource Resource
	 * @return Previous value
	 * @throws Exceptions if the resource key is not found in the store
	 * @see #initialise(Resource)
	 */
	Resource replace(final Resource resource) throws RuntimeException;

	/**
	 * Remove resource or throw exception. This guarantees that a subsequent call
	 * to {@link #get(String)} with the same URI string will return null. This
	 * method does not guarantee data deletion in any way whatsoever. It's up to
	 * the resource type and storage implementation to specify that if required.
	 *
	 * @param resource Resource to remove
	 * @return Previously stored value
	 * @throws Exceptions if no resource is found
	 */
	Resource remove(final Resource resource) throws RuntimeException;
}
