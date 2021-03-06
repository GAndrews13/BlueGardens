package com.netbuilder.customannotations;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;

@Target({ METHOD, CONSTRUCTOR })
@Documented
public @interface MethodAuthor {
	String name() default "Not Stated";

	String adjustedBy() default "No one yet";
}
