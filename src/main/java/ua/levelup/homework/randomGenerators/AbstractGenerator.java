package ua.levelup.homework.randomGenerators;


import java.util.Random;

public abstract class AbstractGenerator<T extends Number> implements NumberGenerator<T> {
    protected Random random = new Random();
}
