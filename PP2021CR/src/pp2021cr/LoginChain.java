/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp2021cr;

/**
 *
 * @author eduar
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class LoginChain {

    protected LoginChain next;
    public String nome;
    public String senha;

    protected LoginChain(String nome, String senha) {
        this.next = null;
        this.nome = nome;
        this.senha = senha;
    }

    public void setNext(LoginChain proximo) {
        if (next == null) {
            next = proximo;
        } else {
            next.setNext(proximo);
        }
    }

    public abstract void efetuarLogin();

    private static final String senhaPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,16}$";

    private static final Pattern pattern = Pattern.compile(senhaPattern);

    public static boolean valido(final String senha) {
        Matcher matcher = pattern.matcher(senha);
        boolean resultado = matcher.matches();

        if (resultado == true) {
            return validarSequenciaConsecutiva(senha);
        }
        return false;
    }

    public void podeEfetuarLogin(boolean valido) throws Exception {
        if (valido == false) {
            throw new Exception("Favor informar uma senha válida que condiz com as condições de senha forte.");
        }
        efetuarLogin();
    }

    public static boolean validarSequenciaConsecutiva(String senha) {
        char senhaCaractereArray[] = senha.toCharArray(); //cada caractere separado
        int codigoAscii = 0;
        boolean sequenciaNaoConsecutiva = true;
        int codigoAsciiAnterior = 0;
        int countSequencia = 0;

        for (int i = 0; i < senhaCaractereArray.length; i++) {
            codigoAscii = senhaCaractereArray[i]; //tabela código ascii
            if ((codigoAsciiAnterior + 1) == codigoAscii) {
                countSequencia++;
                if (countSequencia >= 2) {
                    sequenciaNaoConsecutiva = false;
                    break;
                }
            } else {
                countSequencia = 0;
            }
            codigoAsciiAnterior = codigoAscii;
        }
        return sequenciaNaoConsecutiva;
    }
}
