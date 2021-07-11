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
import java.util.function.IntPredicate;

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

    public boolean contemMinusculo(String value) {
        return contem(value, i -> Character.isLetter(i) && Character.isLowerCase(i));
    }

    public boolean contemMaiusculo(String value) {
        return contem(value, i -> Character.isLetter(i) && Character.isUpperCase(i));
    }

    public boolean contemNumero(String value) {
        return contem(value, Character::isDigit);
    }

    public boolean contem(String value, IntPredicate predicate) {
        return value.chars().anyMatch(predicate);
    }

    public boolean contemMinimoCaracter(int quantidade) {
        return quantidade >= 8 ? true : false;
    }

    public boolean contemMaximoCaracter(int quantidade) {
        return quantidade <= 16 ? true : false;
    }
}
