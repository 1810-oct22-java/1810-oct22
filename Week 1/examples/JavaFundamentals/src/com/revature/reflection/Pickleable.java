package com.revature.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//Make your own annotation!
@Target({ElementType.METHOD, ElementType.TYPE}) //where can the annotation be applied
@Retention(RetentionPolicy.RUNTIME)
public @interface Pickleable {

}
