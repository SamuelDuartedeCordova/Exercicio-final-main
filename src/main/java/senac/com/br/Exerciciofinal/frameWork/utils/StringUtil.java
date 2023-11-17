package senac.com.br.Exerciciofinal.frameWork.utils;

import java.time.LocalDateTime;
import java.util.Objects;

public class StringUtil {
    public static boolean validarString(String input) {
        return Objects.isNull(input) || input.equals("");
    }

    public static boolean validarLocalDateTime(LocalDateTime input) {
        return Objects.isNull(input);
    }
}