package exceptions;

public interface IMassages {
    String messageOfInputValueError = "Введенное значение не входит допутимый диапазон!"
            + System.lineSeparator()
            + "Повторите ввод!" + System.lineSeparator();
    String messageOfInputFormatError = "Данные введены некорректно!" + System.lineSeparator()
            + "Повторите ввод!" + System.lineSeparator();
    String messageOfEmptyFormatError = "Данные не были введены" + System.lineSeparator()
            + "Повторите ввод!"+ System.lineSeparator();
}
