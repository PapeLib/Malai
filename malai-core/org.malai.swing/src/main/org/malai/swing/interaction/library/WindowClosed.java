package org.malai.swing.interaction.library;

import org.malai.interaction.TerminalState;
import org.malai.swing.interaction.SwingInteraction;
import org.malai.swing.interaction.WindowClosedTransition;

import java.awt.*;

/**
 * This interaction is performed when a window is closed by pressing the decorating close button.<br>
 * <br>
 * This file is part of Malai.<br>
 * Copyright (c) 2005-2014 Arnaud BLOUIN<br>
 * <br>
 * Malai is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later version.
 * <br>
 * Malai is distributed without any warranty; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.<br>
 * <br>
 * 05/31/2011<br>
 * @author Arnaud BLOUIN
 * @since 0.2
 */
public class WindowClosed extends SwingInteraction {
	/** The frame closed. */
	protected Window frame;


	/**
	 * Creates the interaction.
	 */
	public WindowClosed() {
		super();
		initStateMachine();
	}


	@Override
	public void reinit() {
		super.reinit();
		frame = null;
	}


	@SuppressWarnings("unused")
	@Override
	protected void initStateMachine() {
		final TerminalState closed = new TerminalState("closed"); //$NON-NLS-1$

		addState(closed);

		new WindowClosedTransition(initState, closed) {
			@Override
			public void action() {
				super.action();
				WindowClosed.this.frame = this.widget;
			}
		};
	}


	/**
	 * @return the frame closed.
	 * @since 0.2
	 */
	public Window getFrame() {
		return frame;
	}
}

