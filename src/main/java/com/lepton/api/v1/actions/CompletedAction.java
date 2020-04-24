package com.lepton.api.v1.actions;

import com.lepton.api.v1.core.Resource;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class CompletedAction {
	private final long id;
	private final Action action;
	private final Resource result;
	private final Exception exception;
	private final Instant submittedAt;
	private final Instant completedAt;
	private final boolean success;
}
