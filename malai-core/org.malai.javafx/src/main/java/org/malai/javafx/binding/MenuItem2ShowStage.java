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
package org.malai.javafx.binding;

import java.util.Collections;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import org.malai.javafx.action.ShowStage;
import org.malai.javafx.instrument.JfxInstrument;
import org.malai.javafx.interaction.library.MenuItemPressed;

/**
 * An widget binding that opens a URL using a menu item.
 * @author Arnaud BLOUIN
 */
public class MenuItem2ShowStage extends JfxMenuItemBinding<ShowStage, MenuItemPressed, JfxInstrument> {
	protected Stage stageToShow;

	protected boolean show;

	/**
	 * Creates the widget binding.
	 * @param ins The instrument that will contain the widget binding.
	 * @param menuItem he menu item that will be uses to create the action.
	 * @param stage The stage to show or hide
	 * @throws IllegalArgumentException If one of the given parameters is null.
	 * @throws IllegalAccessException If no free-parameter constructor is available.
	 * @throws InstantiationException If an error occurs during instantiation of the interaction/action.
	 * @since 2.0
	 */
	public MenuItem2ShowStage(final JfxInstrument ins, final MenuItem menuItem, final Stage stage, final boolean toshow) throws
		InstantiationException, IllegalAccessException {
		super(ins, false, ShowStage.class, MenuItemPressed.class, Collections.singletonList(menuItem));

		if(stage == null) throw new IllegalArgumentException();

		stageToShow = stage;
		show = toshow;
	}

	@Override
	public void initAction() {
		action.setWidget(stageToShow);
		action.setVisible(show);
	}
}
