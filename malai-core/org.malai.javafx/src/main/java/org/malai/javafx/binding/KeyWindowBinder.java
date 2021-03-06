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

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import javafx.scene.input.KeyCode;
import javafx.stage.Window;
import org.malai.action.ActionImpl;
import org.malai.javafx.instrument.JfxInstrument;
import org.malai.javafx.interaction.library.KeysPressure;

/**
 * The binding builder to create bindings between a key interaction (eg shorcuts) on a window and a given action.
 * @param <A> The type of the action to produce.
 * @author Arnaud Blouin
 */
public class KeyWindowBinder<A extends ActionImpl> extends KeyBinder<Window, A> {
	public KeyWindowBinder(final Class<A> action, final JfxInstrument instrument) {
		super(action, instrument);
	}

	@Override
	public void bind() throws IllegalAccessException, InstantiationException {
		instrument.addBinding(new JFxAnonNodeBinding<>(instrument, false, actionClass, KeysPressure.class, widgets, initAction, null,
			checkCode, onEnd, null, null, async));
	}

	@Override
	public KeyWindowBinder<A> with(final KeyCode... code) {
		super.with(code);
		return this;
	}

	@Override
	public KeyWindowBinder<A> on(final Window... widget) {
		super.on(widget);
		return this;
	}

	@Override
	public KeyWindowBinder<A> init(final Consumer<A> initActionFct) {
		super.init(initActionFct);
		return this;
	}

	@Override
	public KeyBinder<Window, A> init(final BiConsumer<A, KeysPressure> initActionFct) {
		super.init(initActionFct);
		return this;
	}

	@Override
	public KeyWindowBinder<A> when(final Predicate<KeysPressure> checkAction) {
		super.when(checkAction);
		return this;
	}

	@Override
	public KeyWindowBinder<A> onEnd(final BiConsumer<A, KeysPressure> onEndFct) {
		super.onEnd(onEndFct);
		return this;
	}

	@Override
	public KeyWindowBinder<A> async() {
		super.async();
		return this;
	}
}
