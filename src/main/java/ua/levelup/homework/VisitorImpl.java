package ua.levelup.homework;

import ua.levelup.homework.properties.MatrixProperties;
import ua.levelup.homework.properties.MatrixProperty;
import ua.levelup.homework.randomGenerators.NumberGenerator;
import ua.levelup.homework.randomGenerators.TwoDArray;

import java.lang.reflect.Method;

public class VisitorImpl implements Visitor {
    @Override
    public void visit(Main matrixVisitor) {
        Method[] declaredMethods = matrixVisitor.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            MatrixProperties matrixProperties = method.getAnnotation(MatrixProperties.class);
            if (matrixProperties == null) {
                continue;
            }

            for (MatrixProperty matrixProperty : matrixProperties.value()) {
                try {
                    NumberGenerator<?> generator = matrixProperty.generator().value().getGenerator();
                    method.invoke(matrixVisitor, new TwoDArray<>(generator, matrixProperty.rows(), matrixProperty.column()));
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}
