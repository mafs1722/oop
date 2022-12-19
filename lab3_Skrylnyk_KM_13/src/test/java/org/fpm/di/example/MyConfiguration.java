package org.fpm.di.example;

import org.fpm.di.Binder;
import org.fpm.di.Configuration;
import org.fpm.di.example.MyComponents.*;

public class MyConfiguration implements Configuration {
    @Override
    public void configure(Binder binder) {
        binder.bind(MySingleton.class);
        binder.bind(MyPrototype.class);

        binder.bind(UseA.class);

        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());

        /////*******************************
        binder.bind(Building.class);
        binder.bind(MyFlat.class);
        binder.bind(NeighbourFlat.class);
        binder.bind(BathRoom.class, Shower.class);
        //Singleton
        binder.bind(CommonCoridor.class, new CommonCoridor());
    }
}
