package com.lepton.api.v1.actions;

import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

@UtilityClass
public class ActionLog {
	private static final Queue<CompletedAction> completedActions;
	private static final long magicCutoff = 255;
	private static long completedIdCount;

	static {
		completedIdCount = Instant.now().toEpochMilli();
		completedActions = new ArrayDeque<>();
	}

	public static void queue(final Action action) {
		final CompletedAction.CompletedActionBuilder builder = CompletedAction.builder();

		builder.id(completedIdCount++)
			.action(action)
			.submittedAt(Instant.now());

		try {
			builder.result(action.exec())
				.success(true);

		} catch (Exception e) {
			e.printStackTrace();
			builder.exception(e)
				.success(false);
		} finally {
			builder.completedAt(Instant.now());
			completedActions.add(builder.build());

			if (completedActions.size() > magicCutoff) {
				completedActions.remove();
			}
		}
	}

	public static Set<CompletedAction> getCompletedActions() {
		return new HashSet<>(completedActions);
	}

	public static boolean checkPermission(final Action action) {
		return false;
	}
}
