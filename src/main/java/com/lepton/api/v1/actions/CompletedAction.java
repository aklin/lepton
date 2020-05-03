package com.lepton.api.v1.actions;

import com.lepton.api.v1.core.Resource;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.Instant;

/**
 * Record of a completed action.
 */
@Getter
@Builder(access = AccessLevel.PACKAGE)
@EqualsAndHashCode
public class CompletedAction {
	/**
	 * Action identifier. Assigned after an action has completed.
	 */
	private final long id;

	/**
	 * Action object
	 */
	private final Action action;

	/**
	 * Result. May be null
	 */
	private final Resource result;

	/**
	 * Exception thrown during execution. May be null
	 */
	private final Exception exception;

	/**
	 * Time when action was added to the queue
	 */
	private final Instant submittedAt;

	/**
	 * Time when action finished executing
	 */
	private final Instant completedAt;

	/**
	 * Success. False if {@link #getException()} is not null
	 */
	private final boolean success;
}
