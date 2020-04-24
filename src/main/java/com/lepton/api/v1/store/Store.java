package com.lepton.api.v1.store;

import com.lepton.api.v1.core.Exceptions;
import com.lepton.api.v1.core.Resource;

import javax.validation.constraints.NotNull;
import java.io.Closeable;

public interface Store extends Closeable {
	boolean contains(final String uri);

	boolean contains(@NotNull final Resource resource);

	Resource get(@NotNull final String uri);

	Resource set(@NotNull final Resource resource);

	/**
	 * Store resource. Will throw exception if another resource with the same URI exists.
	 *
	 * @param resource Resource
	 * @return this
	 * @see #replace(Resource)
	 */
	Resource initialise(@NotNull final Resource resource) throws
		Exceptions.StoreException;

	/**
	 * Replace resource. Will throw exception if a resource with the same URI is not found.
	 *
	 * @param resource Resource
	 * @return Previous value
	 * @throws Exceptions.StoreException if the resource key is not found in the store
	 * @see #initialise(Resource)
	 */
	Resource replace(@NotNull final Resource resource) throws
		Exceptions.StoreException;

	/**
	 * Remove resource or throw exception. This guarantees that a subsequent call
	 * to {@link #get(String)} with the same URI string will return null. This
	 * method does not guarantee data deletion in any way whatsoever. It's up to
	 * the resource type and storage implementation to specify that if required.
	 *
	 * @param resource Resource to remove
	 * @return Previously stored value
	 * @throws Exceptions.StoreException if no resource is found
	 */
	Resource remove(@NotNull final Resource resource) throws
		Exceptions.StoreException;

	boolean isEmpty();
}
