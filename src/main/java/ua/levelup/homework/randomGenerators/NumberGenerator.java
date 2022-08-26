package ua.levelup.homework.randomGenerators;

public interface NumberGenerator<T extends Number>{
    T nextRand();
    Class<T> getType();
}
