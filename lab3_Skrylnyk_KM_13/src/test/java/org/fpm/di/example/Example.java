package org.fpm.di.example;

import org.fpm.di.Container;
import org.fpm.di.Environment;
import org.fpm.di.example.MyComponents.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

public class Example {

    private Container container;

    @Before
    public void setUp() {
        Environment env = new DummyEnvironment();
        container = env.configure(new MyConfiguration());
    }

    @Test
    public void shouldInjectSingleton() {
        assertSame(container.getComponent(MySingleton.class), container.getComponent(MySingleton.class));
    }

    @Test
    public void shouldInjectPrototype() {
        assertNotSame(container.getComponent(MyPrototype.class), container.getComponent(MyPrototype.class));
    }

    @Test
    public void shouldBuildInjectionGraph() {
        /*
        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
        */
        final B bAsSingleton = container.getComponent(B.class);
//        assertSame(container.getComponent(A.class), bAsSingleton);
        assertSame(container.getComponent(B.class), bAsSingleton);
    }

    @Test
    public void shouldBuildInjectDependencies() {
        final UseA hasADependency = container.getComponent(UseA.class);
        assertSame(hasADependency.getDependency(), container.getComponent(B.class));
    }
    ///******************************** Tests For My Flats Hierarchy ********************************:

    @Test
    public void shouldBuildInjectDependenciesMyFlatsHierarchy() {
        final Building building = container.getComponent(Building.class);
        assertNotNull(building.getMyFlat().getBedRoom());
        assertNotNull(building.getMyFlat().getKitchen());
        assertNotNull(building.getMyFlat().getDiningRoom());
        assertNotNull(building.getMyFlat().getBathRoom());
        assertNotNull(building.getMyFlat().getCommonCoridor());

        assertNotNull(building.getNeighbourFlat().getBedRoom());
        assertNotNull(building.getNeighbourFlat().getKitchen());
        assertNotNull(building.getNeighbourFlat().getDiningRoom());
        assertNotNull(building.getNeighbourFlat().getBathRoom());
        assertNotNull(building.getNeighbourFlat().getCommonCoridor());
    }


    @Test
    public void shouldInjectSingletonMyFlatsHierarchy() {
        final MyFlat myFlat = container.getComponent(MyFlat.class);
        final NeighbourFlat neighbourFlat = container.getComponent(NeighbourFlat.class);
        assertSame(container.getComponent(CommonCoridor.class), container.getComponent(CommonCoridor.class));
        assertSame(myFlat.getCommonCoridor(), container.getComponent(CommonCoridor.class));
        assertSame(neighbourFlat.getCommonCoridor(), container.getComponent(CommonCoridor.class));
        assertSame(myFlat.getCommonCoridor(), neighbourFlat.getCommonCoridor());
    }

    @Test
    public void shouldInjectPrototypeMyFlatsHierarchy() {
        final MyFlat myFlat = container.getComponent(MyFlat.class);
        final NeighbourFlat neighbourFlat = container.getComponent(NeighbourFlat.class);

        assertNotSame(container.getComponent(DiningRoom.class), container.getComponent(DiningRoom.class));
        assertNotSame(myFlat.getDiningRoom(), neighbourFlat.getDiningRoom());
        assertNotSame(myFlat.getBedRoom(), neighbourFlat.getBedRoom());
        assertNotSame(myFlat.getKitchen(), neighbourFlat.getKitchen());
        assertNotSame(myFlat.getBathRoom(), neighbourFlat.getBathRoom());
    }

    @Test
    public void shouldBuildInjectionGraphMyFlatsHierarchy() {
        final MyFlat myFlat = container.getComponent(MyFlat.class);
        final NeighbourFlat neighbourFlat = container.getComponent(NeighbourFlat.class);
        assertSame(container.getComponent(BathRoom.class).getClass(), Shower.class);
        assertSame(myFlat.getBathRoom().getClass(), Shower.class);
        assertSame(neighbourFlat.getBathRoom().getClass(), Shower.class);
    }
}
