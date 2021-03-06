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
package org.malai.presentation;

import org.malai.properties.Modifiable;
import org.malai.properties.Reinitialisable;

/**
 * A presentation contains an abstract presentation and a concrete presentation. The goal of a presentation is to provide users with
 * data (the abstract presentation) transformed to be displayable (the concrete presentation).
 * @param <A> The type of the abstract presentation.
 * @param <C> The type of the concrecte presentation.
 * @author Arnaud BLOUIN
 * @since 0.1
 */
public class Presentation<A extends AbstractPresentation, C extends ConcretePresentation> implements Modifiable, Reinitialisable {
	/** The abstract presentation, i.e. the manipulated data model. */
	protected final A abstractPresentation;

	/** The concrete presentation, i.e. the representation of the abstract presentation. */
	protected final C concretePresentation;


	/**
	 * Creates a presentation.
	 * @param absPres The abstract presentation, i.e. the manipulated data model.
	 * @param concPres The concrete presentation, i.e. the representation of the abstract presentation.
	 * @throws IllegalArgumentException If one of the given arguments is null.
	 * @since 0.1
	 */
	public Presentation(final A absPres, final C concPres) {
		if(absPres == null || concPres == null) throw new IllegalArgumentException();

		abstractPresentation = absPres;
		concretePresentation = concPres;
	}


	@Override
	public void setModified(final boolean modified) {
		abstractPresentation.setModified(modified);
		concretePresentation.setModified(modified);
	}


	@Override
	public boolean isModified() {
		return abstractPresentation.isModified() || concretePresentation.isModified();
	}


	/**
	 * @return The abstract presentation, i.e. the manipulated data model.
	 * @since 0.1
	 */
	public A getAbstractPresentation() {
		return abstractPresentation;
	}


	/**
	 * @return The concrete presentation, i.e. the representation of the abstract presentation.
	 * @since 0.1
	 */
	public C getConcretePresentation() {
		return concretePresentation;
	}


	/**
	 * Updates the presentation.
	 * @since 0.2
	 */
	public void update() {
		concretePresentation.update();
	}


	/**
	 * Reinitialises the presentation (its concrete and abstract presentations).
	 * @since 0.2
	 */
	@Override
	public void reinit() {
		abstractPresentation.reinit();
		concretePresentation.reinit();
	}
}
