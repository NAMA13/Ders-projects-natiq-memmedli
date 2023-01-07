package az.developia.springmvc.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OurBestAnnotationConstraint implements ConstraintValidator<OurBestAnnotation, String> {

	private String s;
	@Override
	public void initialize(OurBestAnnotation o) {
		 s=o.value();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		 
		return value.startsWith(s);
	}

}
