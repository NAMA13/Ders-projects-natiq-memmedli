package az.developia.springmvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = OurBestAnnotationConstraint.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OurBestAnnotation {
	
	public String value() default "dea";
	 
	public String message() default "email dea ile baslamalidir";
	 
	
	
	// bu iki setir sablondir, deyisilmir hec vaxt
	Class<?>[] groups() default {};
	 
	Class<? extends Payload>[] payload() default{};
}
