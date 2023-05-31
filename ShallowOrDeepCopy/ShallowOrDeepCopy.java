package ShallowOrDeepCopy;

import java.lang.reflect.Method;

public class ShallowOrDeepCopy {
    public static Object verifyAndCopy(Object data) {
        if(data instanceof Cloneable) return deepCopy(data);
        else return data;
    }

    public static Object deepCopy(Object data) {
        try {
            Class<?> x = data.getClass();
            Method method = x.getMethod("clone");
            return (Object)method.invoke(data);
        } catch(Exception err) { return null; }
    }
    /*
    
        A diferença principal entre os dois métodos está nos tipos de retorno e na flexibilidade em relação ao tipo de objeto a ser clonado.

            Tipo de Retorno:
            O método deepCopy(Object data) tem um tipo de retorno Object. Isso significa que ele pode clonar qualquer objeto e retorná-lo como um objeto genérico. O tipo específico do objeto clonado não é mantido.
            O método meuCloneDeX(X x) tem um tipo de retorno X, que é o mesmo tipo do objeto fornecido como parâmetro. Isso significa que o método retorna um objeto clonado do mesmo tipo específico que foi passado.

            Flexibilidade em relação ao tipo de objeto:
            O método deepCopy(Object data) pode clonar qualquer objeto passado como parâmetro, uma vez que o tipo do objeto é genérico. No entanto, não há garantia de que o objeto seja realmente clonável (implemente a interface Cloneable) e de que o método clone() esteja disponível na classe do objeto. Essa verificação não é feita no método em si.
            O método meuCloneDeX(X x) é projetado para clonar objetos do tipo X, especificado como o tipo do parâmetro. Ele pode aproveitar as garantias fornecidas pelo tipo específico X, como a implementação correta da interface Cloneable e a disponibilidade do método clone() na classe X.
     */
}