package org.malai.javafx.instrument;

import java.util.Arrays;
import java.util.List;

import javafx.scene.Node;

import org.malai.action.Action;
import org.malai.instrument.InteractorImpl;
import org.malai.javafx.interaction.JfxInteraction;

/**
 * Base of an interactor for JavaFX applications.<br>
 * <br>
 * This file is part of libMalai.<br>
 * Copyright (c) 2005-2015 Arnaud BLOUIN<br>
 * <br>
 * libMalan is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later version.<br>
 * <br>
 * libMalan is distributed without any warranty; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.<br>
 * @author Arnaud BLOUIN
 * @date 2014-09-19
 * @version 2.0
 */
public abstract class JfxInteractor<A extends Action, I extends JfxInteraction, N extends JfxInstrument> extends InteractorImpl<A, I, N> {
	/**
	 * Creates an interactor. This constructor must initialise the interaction. The interactor is (de-)activated if the given
	 * instrument is (de-)activated.
	 * @param ins The instrument that contains the interactor.
	 * @param exec Specifies if the action must be execute or update on each evolution of the interaction.
	 * @param clazzAction The type of the action that will be created. Used to instantiate the action by reflexivity.
	 * The class must be public and must have a constructor with no parameter.
	 * @param clazzInteraction The type of the interaction that will be created. Used to instantiate the interaction by reflexivity.
	 * The class must be public and must have a constructor with no parameter.
	 * @param widgets The widgets used by the interactor. Cannot be null.
	 * @throws IllegalAccessException If no free-parameter constructor is available.
	 * @throws InstantiationException If an error occurs during instantiation of the interaction/action.
	 * @throws IllegalArgumentException If the given interaction or instrument is null.
	 */
	public JfxInteractor(N ins, boolean exec, Class<A> clazzAction, Class<I> clazzInteraction, List<Node> widgets) throws InstantiationException, IllegalAccessException {
		super(ins, exec, clazzAction, clazzInteraction);
		interaction.registerToWidgets(widgets);
	}
	
	/**
	 * Creates an interactor. This constructor must initialise the interaction. The interactor is (de-)activated if the given
	 * instrument is (de-)activated.
	 * @param ins The instrument that contains the interactor.
	 * @param exec Specifies if the action must be execute or update on each evolution of the interaction.
	 * @param clazzAction The type of the action that will be created. Used to instantiate the action by reflexivity.
	 * The class must be public and must have a constructor with no parameter.
	 * @param clazzInteraction The type of the interaction that will be created. Used to instantiate the interaction by reflexivity.
	 * The class must be public and must have a constructor with no parameter.
	 * @param widgets The widgets used by the interactor. Cannot be null.
	 * @throws IllegalAccessException If no free-parameter constructor is available.
	 * @throws InstantiationException If an error occurs during instantiation of the interaction/action.
	 * @throws IllegalArgumentException If the given interaction or instrument is null.
	 */
	public JfxInteractor(N ins, boolean exec, Class<A> clazzAction, Class<I> clazzInteraction, Node... widgets) throws InstantiationException, IllegalAccessException {
		this(ins, exec, clazzAction, clazzInteraction, Arrays.asList(widgets));
	}


	@Override
	public boolean isConditionRespected() {
		return true;
	}
}