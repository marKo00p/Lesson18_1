package ua.levelup.homework.properties;

import ua.levelup.homework.randomGenerators.FloatGenerator;
import ua.levelup.homework.randomGenerators.IntegerGenerator;
import ua.levelup.homework.randomGenerators.NumberGenerator;

public enum GeneratorTypes {
    INTEGER{
        @Override
        public NumberGenerator<? extends Number> getGenerator() {
            return new IntegerGenerator();
        }
    },
    FLOAT {
        @Override
        public NumberGenerator<? extends Number> getGenerator() {
            return new FloatGenerator();
        }
    };


    public abstract NumberGenerator<? extends Number> getGenerator();
}
