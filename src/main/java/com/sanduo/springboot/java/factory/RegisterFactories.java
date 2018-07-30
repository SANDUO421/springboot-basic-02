package com.sanduo.springboot.java.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * part 调用工厂
 * 
 * @author sanduo
 * @date 2018/07/13
 */

public class RegisterFactories {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }

}

class Part {

    /* 重写toString
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    // 静态工厂
    static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();

    static {
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new PowerStreeringBelt.Factory());
    }
    private static Random rand = new Random(47);

    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}

class Filter extends Part {}

class FuelFilter extends Filter {
    public static class Factory implements com.sanduo.springboot.java.factory.Factory<FuelFilter> {

        /* 创建FuelFilter
         * @see com.sanduo.springboot.java.factory.Factory#create()
         */
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }

    }
}

class AirFilter extends Filter {
    public static class Factory implements com.sanduo.springboot.java.factory.Factory<AirFilter> {

        /* 创建FuelFilter
         * @see com.sanduo.springboot.java.factory.Factory#create()
         */
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter {
    public static class Factory implements com.sanduo.springboot.java.factory.Factory<CabinAirFilter> {

        /* 创建FuelFilter
         * @see com.sanduo.springboot.java.factory.Factory#create()
         */
        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter {
    public static class Factory implements com.sanduo.springboot.java.factory.Factory<OilFilter> {

        /* 创建FuelFilter
         * @see com.sanduo.springboot.java.factory.Factory#create()
         */
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part {}

class FanBelt extends Belt {
    public static class Factory implements com.sanduo.springboot.java.factory.Factory<FanBelt> {

        /* 创建FuelFilter
         * @see com.sanduo.springboot.java.factory.Factory#create()
         */
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory implements com.sanduo.springboot.java.factory.Factory<GeneratorBelt> {

        /* 创建FuelFilter
         * @see com.sanduo.springboot.java.factory.Factory#create()
         */
        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerStreeringBelt extends Belt {
    public static class Factory implements com.sanduo.springboot.java.factory.Factory<PowerStreeringBelt> {

        /* 创建FuelFilter
         * @see com.sanduo.springboot.java.factory.Factory#create()
         */
        @Override
        public PowerStreeringBelt create() {
            return new PowerStreeringBelt();
        }
    }
}
