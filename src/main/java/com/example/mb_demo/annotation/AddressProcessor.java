package com.example.mb_demo.annotation;


import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes(value = {"com.example.mb_demo.annotation.Value"})
@SupportedSourceVersion(value = SourceVersion.RELEASE_8)
public class AddressProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Messager messager = processingEnv.getMessager();
        messager.printMessage(Diagnostic.Kind.NOTE, "进入到InterfaceProcessor中了~~~");
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Value.class);
        elements.forEach(element -> {

        });
        return false;
    }
}
