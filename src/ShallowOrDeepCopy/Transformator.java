package ShallowOrDeepCopy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * Classe responsável por transformar uma instância de uma classe em outra,
 * presumindo que ambas as classes tenham campos com os mesmos nomes e tipos.
 */
public class Transformator {

    /**
     * Transforma uma instância de uma classe em outra, baseada no nome da classe de origem.
     *
     * @param <I> Tipo de entrada genérico.
     * @param <O> Tipo de saída genérico.
     * @param input Instância da classe de entrada.
     * @return Uma nova instância da classe de saída.
     * @throws ClassNotFoundException Se a classe de destino não for encontrada.
     * @throws NoSuchMethodException Se o construtor padrão não for encontrado.
     * @throws InvocationTargetException Se a invocação do construtor lançar uma exceção.
     * @throws InstantiationException Se a classe de destino representar uma classe abstrata.
     * @throws IllegalAccessException Se o objeto Class não tiver acesso ao construtor.
     */
    @SuppressWarnings("unchecked")
    public <I, O> O transform(I input) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> source = input.getClass(); // Obtém a classe de origem.
        Class<?> target = Class.forName(source.getName() + "DTO"); // Nome da classe de destino é o mesmo da classe de origem com 'DTO' anexado.
        O targetClass = (O) target.getDeclaredConstructor().newInstance(); // Cria uma instância da classe de destino.

        // Obtém os campos da classe de origem e destino.
        Field[] sourceFields = source.getDeclaredFields();
        Field[] targetFields = target.getDeclaredFields();

        // Para cada campo de origem, tenta encontrar e definir o valor correspondente no destino.
        Arrays.stream(sourceFields).forEach(sourceField ->
                Arrays.stream(targetFields).forEach(targetField -> {
                    validate(sourceField, targetField);
                    try {
                        targetField.set(targetClass, sourceField.get(input));
                    } catch (IllegalAccessException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                }));

        return targetClass;
    }

    /**
     * Valida se o campo de origem e destino são equivalentes.
     *
     * @param sourceField Campo da classe de origem.
     * @param targetField Campo da classe de destino.
     */
    private void validate(Field sourceField, Field targetField) {
        // Verifica se os nomes e tipos dos campos são iguais.
        if (sourceField.getName().equals(targetField.getName())
                && sourceField.getType().equals(targetField.getType())) {
            // Torna os campos acessíveis.
            sourceField.setAccessible(true);
            targetField.setAccessible(true);
        }
    }
}
