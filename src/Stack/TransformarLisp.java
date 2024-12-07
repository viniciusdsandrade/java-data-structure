package Stack;

import java.util.ArrayList;
import java.util.List;

public class TransformarLisp {
    public static void main(String[] args) {
        // Exemplo de uso:
        // String input = "( begin ( display hello-world ) ( newline ) )";
        // String input = "((foo bar) baz 123)";
        // String input = "( ( foo ) bar ) )";

        String input = "( begin ( display hello-world ) ( newline ) )";
        String output = transformarLisp(input);
        System.out.println(output);
    }

    public static String transformarLisp(String entrada) {
        // Tokenizar a entrada
        List<String> tokens = tokenize(entrada);
        if (tokens == null) return "syntax error";

        // Parsea a expressão completa
        Parser parser = new Parser(tokens);
        try {
            String result = parser.parseSExpression();
            // Verificar se todos tokens foram consumidos
            if (parser.hasMoreTokens()) {
                return "syntax error";
            }
            return result;
        } catch (Exception e) {
            return "syntax error";
        }
    }

    private static List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();
        int i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);
            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }
            if (c == '(' || c == ')') {
                tokens.add(String.valueOf(c));
                i++;
            } else {
                // Ler um átomo até encontrar espaço ou parêntese
                int start = i;
                while (i < input.length()) {
                    char cc = input.charAt(i);
                    if (Character.isWhitespace(cc) || cc == '(' || cc == ')') {
                        break;
                    }
                    i++;
                }
                String atom = input.substring(start, i);
                tokens.add(atom);
            }
        }
        return tokens;
    }

    static class Parser {
        List<String> tokens;
        int pos = 0;

        Parser(List<String> tokens) {
            this.tokens = tokens;
        }

        boolean hasMoreTokens() {
            return pos < tokens.size();
        }

        String nextToken() throws Exception {
            if (!hasMoreTokens()) throw new Exception("Unexpected end of input");
            return tokens.get(pos++);
        }

        String peekToken() {
            if (!hasMoreTokens()) return null;
            return tokens.get(pos);
        }

        // parseSExpression tenta parsear uma S-Expression
        // Caso encontre '(' ... ')' gera uma chamada de função
        // Caso contrário é um átomo
        String parseSExpression() throws Exception {
            String tk = peekToken();
            if (tk == null) throw new Exception("Unexpected end of input");

            if (tk.equals("(")) {
                // Ler uma lista: ( ... )
                nextToken(); // consome '('
                // Ler elementos até ')'
                List<String> elements = new ArrayList<>();
                // Cada elemento pode ser outra S-expression ou um átomo
                while (true) {
                    String p = peekToken();
                    if (p == null) {
                        throw new Exception("Missing closing parenthesis");
                    }
                    if (p.equals(")")) {
                        // Fechou a lista
                        nextToken(); // consome ')'
                        break;
                    } else {
                        elements.add(parseSExpression());
                    }
                }

                return convertListToFunctionCall(elements);
            } else if (tk.equals(")")) {
                // Isso não deveria acontecer, ')' sem '(' antes
                throw new Exception("Unexpected )");
            } else {
                // Átomo
                return nextToken(); // retorna o átomo
            }
        }

        // Converte uma lista de elementos (primeiro elemento é a "função" ou expressão)
        // em uma chamada de função no estilo foo(arg1, arg2, ...)
        String convertListToFunctionCall(List<String> elements) {
            if (elements.isEmpty()) {
                // () não faz sentido, mas vamos retornar ()?
                // Pela lógica da questão, não há um exemplo desse caso.
                // Vamos retornar "()"
                return "()";
            }

            // O primeiro elemento indica a função ou expressão
            String first = elements.getFirst();

            // Precisamos verificar se o first já é uma chamada de função ou um átomo.
            // Heurística: se 'first' contém um parênteses '(', provavelmente já é algo do tipo function(...)
            // Caso contrário, é um átomo.
            boolean firstIsFunctionCall = first.contains("(");

            List<String> args = elements.subList(1, elements.size());

            if (!firstIsFunctionCall) {
                // first é um átomo, então é do tipo: foo
                // arguments: arg1, arg2, ...
                // Saída: foo(arg1, arg2, ...)
                return formatFunctionCall(first, args);
            } else {
                // first já é uma função do tipo foo(...)
                // Agora, se temos mais argumentos, isso significa foo(...)(arg1, arg2...)
                // Caso não haja args, apenas retornamos o first
                if (args.isEmpty()) {
                    return first;
                } else {
                    // Precisamos concatenar no formato foo(...)(arg1, arg2, ...)
                    return first + formatFunctionCall("", args);
                }
            }
        }

        // Auxiliar para formatar chamadas de função
        // Se functionName estiver vazio, só retorna (arg1, arg2...)
        // Caso contrário retorna functionName(arg1, arg2...)
        private String formatFunctionCall(String functionName, List<String> args) {
            StringBuilder sb = new StringBuilder();
            if (!functionName.isEmpty()) {
                sb.append(functionName);
            }
            sb.append("(");
            for (int i = 0; i < args.size(); i++) {
                sb.append(args.get(i));
                if (i < args.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append(")");
            return sb.toString();
        }
    }
}
