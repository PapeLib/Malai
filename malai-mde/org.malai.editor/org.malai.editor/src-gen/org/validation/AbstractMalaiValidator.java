/*
 * generated by Xtext
 */
package org.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;

public class AbstractMalaiValidator extends org.eclipse.xtext.validation.AbstractDeclarativeValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://org.malai.interactiveSystem/1_0_0//org/malai/interactiveSystem"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://org.malai.widget/1_0_0//org/malai/widget"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://org.malai.interaction/1_0_0//org/malai/interaction"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://org.malai.instrument/1_0_0//org/malai/instrument"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://org.malai.action/1_0_0//org/malai/action"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://org.malai.event/1_0_0//org/malai/event"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/emf/2002/Ecore"));
		return result;
	}
}