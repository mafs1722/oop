package org.fpm.di.example;

import org.fpm.di.Binder;
import org.fpm.di.Container;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DummyContainer implements Container {
    DummyBinder binder;
    public DummyContainer(DummyBinder b) {this.binder = b;}
    @Override
    public <T> T getComponent(Class<T> clazz) {
        if (binder.implementations.containsKey(clazz)) {
            return getComponent((Class<T>) binder.implementations.get(clazz));
        }
        if (binder.instances.containsKey(clazz)) {
            return (T)binder.instances.get(clazz);
        }
        try{
            T component = null;
            for (Constructor<?> constructor : clazz.getConstructors()) {
                if(constructor.isAnnotationPresent(Inject.class)){
                    Object[] params = new Object[constructor.getParameters().length];
                    for (int i = 0; i < constructor.getParameters().length; i++) {
                        params[i] = getComponent(constructor.getParameters()[i].getType());
                    }
                    component = (T) constructor.newInstance(params);
                    break;
                }
            }
            if (component == null) {
                component = clazz.newInstance();
            }
            if (clazz.isAnnotationPresent(Singleton.class)){
                binder.bind(clazz, component);
            }
            return component;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
