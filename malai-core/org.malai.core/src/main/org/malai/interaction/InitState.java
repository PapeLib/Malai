/*
 * This file is part of Malai.
 * Copyright (c) 2005-2017 Arnaud BLOUIN
 * Malai is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later version.
 * Malai is distributed without any warranty; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */
package org.malai.interaction;

import org.malai.stateMachine.MustAbortStateMachineException;
import org.malai.stateMachine.SourceableState;

/**
 * This state defines a initial state that starts the interaction.
 * @author Arnaud BLOUIN
 * @since 0.1
 */
public class InitState extends StateImpl implements SourceableState {
	/**
	 * Creates the initial state.
	 * @since 0.1
	 */
	public InitState() {
		super("Init"); //$NON-NLS-1$
	}


	@Override
	public void onOutgoing() throws MustAbortStateMachineException {
		stateMachine.onStarting();
	}
}
