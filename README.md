[![Build Status](https://ci.inria.fr/malai/job/malai_core/badge/icon)](https://ci.inria.fr/malai/job/malai_core/) [![Build Status](https://ci.inria.fr/malai/job/malai_javafx/badge/icon)](https://ci.inria.fr/malai/job/malai_javafx/)<br/>



# Malai and the Model-View-Instrument (MVI) pattern

Malai is an implementation of the **Model-View-Instrument** (**MVI**) pattern.<br/>
MVI complements traditional patterns (MVC, MVP, MVVM) by introducing the concepts of widget binding, action, and user interaction as first class concerns.

MVI is not another pattern to choose against MVP, MVC, etc.<br/> 
MVI complements the different patterns you choose for your applications:<br/>
with MVI, a user interface has **actions** and **user interactions** in addition to the traditional model, view, controller/presenter/viewModel/component/etc. (this last is called an instrument in MVI).  
MVI
MVI eases the development of highly interactive applications by:

- providing **widget binding**, a novel binding mechanism to transform user interactions into actions (instead of using the low level, error-prone, and not-scalable event handling system)
- providing a library of reusable standard and modern user interactions
- providing a support of undo/redo features


## Examples

The following Java code defines an undoable action that changes the unit system used in a drawing editor.

```java
public class SetUnit extends ActionImpl implements Undoable {
	private Unit unit;
	private Unit oldUnit;

	@Override
	public boolean canDo() { // Checks whether the action can be executed
		return unit != null;
	}
	
	@Override
	protected void doActionBody() { // Execution of the action.
		oldUnit = ScaleRuler.getUnit();
		redo();
	}
	
	@Override
	public void undo() { // Undoes the action
		ScaleRuler.setUnit(oldUnit);
	}

	@Override
	public void redo() { // Redoes the action
		ScaleRuler.setUnit(unit);
	}

	@Override
	public String getUndoName() { // Provides a short textual description of this undoable action.
		return "Changing the unit";
	}
    //...
}
```

This action can be then used in an instrument to be binded to a predefined user interaction and widgets.

```java
// An instrument is a controller/presenter/viewModel/component/etc: 
// it gather events produced by widgets as user interactions into actions that modify the system.
public class PreferencesSetter extends JfxInstrument implements Initializable {
    @FXML private ComboBox<String> unitChoice;
    //...

    @Override
    protected void configureBindings() throws IllegalAccessException, InstantiationException {
        //...
        // Defines an widget binding that binds a combobox to the action SetUnit
        bindComboBox(SetUnit.class,  // The type of the action to produce
            action -> action.setUnit(Unit.getUnit(unitChoice.getSelectionModel().getSelectedItem())), // The initialisation of the action
            unitChoice); // The source widget to listen
    }
}
```


# Implementations


Malai fully supports **Java Swing** and **JavaFX**. A **TypeScript/Javascript** version is in progress.

# How to use

As Maven libraries. In your POM file, adds the Malai repositories:

```xml
    <repositories>
        <repository>
            <id>mavenInriaSnapshot</id>
            <name>http://maven.inria.fr-snapshots</name>
            <url>http://maven.inria.fr/artifactory/malai-public-snapshot</url>
        </repository>
        <repository>
            <id>mavenInriaRelease</id>
            <name>http://maven.inria.fr-releases</name>
            <url>http://maven.inria.fr/artifactory/malai-public-release</url>
        </repository>
    </repositories>
```

And adds the dependencies:

```xml
        <dependency>
            <groupId>org.malai</groupId>
            <artifactId>malai.core</artifactId>
            <version>3.0-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>org.malai</groupId>
            <artifactId>malai.javafx</artifactId>
            <version>3.0-SNAPSHOT</version>
        </dependency>
```


# Who use Malai?


[Latexdraw](https://github.com/arnobl/latexdraw) is a vector drawing editors for LaTeX. It is developed on the top of Malai JavaFX.


# Papers


Research papers on Malai / MVI:

- Blouin A. and Beaudoux O. *Improving modularity and usability of interactive systems with Malai*, EICS'10: Proceedings of the 2nd ACM SIGCHI symposium on Engineering interactive computing systems http://hal.archives-ouvertes.fr/docs/00/47/76/27/PDF/BLOUIN10a.pdf

- Blouin A., Morin B., Beaudoux O., Nain G., Albers P., and Jézéquel J.-M. *Combining Aspect-Oriented Modeling with Property-Based Reasoning to Improve User Interface Adaptation*, EICS'11: Proceedings of the 3rd ACM SIGCHI symposium on Engineering interactive computing systems, 85-94 http://hal.inria.fr/inria-00590891/PDF/main.pdf

- Blouin A. *Un modèle pour l'ingénierie des systèmes interactifs dédiés à la manipulation de données*, Ph.D. thesis http://tel.archives-ouvertes.fr/docs/00/44/63/14/PDF/these.pdf


