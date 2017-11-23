package fr.pizzeria.model;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME) // Utilisable pendant l'execution du programme
@Target(FIELD) // Ne peut s'appliquer qu'a un attribut d'une classe
public @interface ToString {

	boolean uppercase() default false;
	
}
