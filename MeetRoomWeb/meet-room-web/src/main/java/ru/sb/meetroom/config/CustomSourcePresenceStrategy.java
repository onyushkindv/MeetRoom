package ru.sb.meetroom.config;

import org.mapstruct.ap.spi.DefaultAccessorNamingStrategy;
import org.mapstruct.ap.spi.util.IntrospectorUtils;

import javax.lang.model.element.ExecutableElement;


public class CustomSourcePresenceStrategy extends DefaultAccessorNamingStrategy {

    private static final String GETTER_PREFIX = "_mapstructGet";

    @Override
    public boolean isGetterMethod(ExecutableElement method) {
        String methodName = method.getSimpleName().toString();
        if(methodName.startsWith(GETTER_PREFIX)){
            return true;
        } else {
            return super.isGetterMethod(method);
        }
    }

    @Override
    public String getPropertyName(ExecutableElement getterOrSetterMethod) {
        String methodName = getterOrSetterMethod.getSimpleName().toString();
        if(methodName.startsWith(GETTER_PREFIX)){
            return IntrospectorUtils.decapitalize(methodName.substring(GETTER_PREFIX.length()));
        } else {
            return super.getPropertyName(getterOrSetterMethod);
        }
    }
}