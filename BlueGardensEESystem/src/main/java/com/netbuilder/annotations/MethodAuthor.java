package com.netbuilder.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.CONSTRUCTOR;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;  
@Target ({ METHOD, CONSTRUCTOR })
@Documented
public @interface MethodAuthor
{    
	String name() default "Not Stated";
	String adjustedBy() default "No one yet";
} 