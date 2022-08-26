package ua.levelup.homework;

import ua.levelup.homework.properties.GeneratorProperty;
import ua.levelup.homework.properties.GeneratorTypes;
import ua.levelup.homework.properties.MatrixProperty;
import ua.levelup.homework.randomGenerators.TwoDArray;

public class Main implements MainInterface {

    @MatrixProperty(generator = @GeneratorProperty(GeneratorTypes.INTEGER), rows = 3, column = 3)
    @MatrixProperty(generator =@GeneratorProperty(GeneratorTypes.FLOAT), rows = 5, column = 5)
    public <T extends Number> void testMatrix(TwoDArray<T> matrix) {
        matrix.print();
    }

    public static void main(String[] args) {
        Visitor visitorUser = new VisitorImpl();
        MainInterface tui = new Main();
        tui.accept(visitorUser);
    }

    @Override
    public void accept(Visitor visitorUser) {
        visitorUser.visit(this);
    }
}
