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

    protected abstract void efetuarLogin();

    public boolean contemMinusculo(String senha) {
        return contem(senha, i -> Character.isLetter(i) && Character.isLowerCase(i));
    }

    public boolean contemMaiusculo(String senha) {
        return contem(senha, i -> Character.isLetter(i) && Character.isUpperCase(i));
    }

    public boolean contemNumero(String senha) {
        return contem(senha, Character::isDigit);
    }

    public boolean contem(String senha, IntPredicate predicate) {
        return senha.chars().anyMatch(predicate);
    }

    public boolean contemMinimoCaracter(int quantidade) {
        return quantidade >= 8 ? true : false;
    }

    public boolean contemMaximoCaracter(int quantidade) {
        return quantidade <= 16 ? true : false;
    }
    
    /*
    public boolean semConsecutivo(String senha)
    {
        int start;
        int result = -99;

        int length = senha.length();

        // find the number till half of the String
        for (int i = 0; i < length / 2; i++) 
        {
            // new String containing the starting
            // substring of input String
            String new_str = senha.substring(0, i + 1);

            // converting starting substring into number
            int num = Integer.parseInt(new_str);

            // backing up the starting number in start
            start = num;

            // while loop until the new_String is 
            // smaller than input String
            while (new_str.length() < length) 
            {

                // next number
                num++;

                // concatenate the next number
                new_str = new_str + String.valueOf(num);
            }

            // check if new String becomes equal to
            // input String
            if (new_str.equals(senha)){
                result = start;
                return false;
            }
            
        }

        // if String doesn't contains consecutive numbers
        return true;
  
    }*/
    public boolean semConsecutivo(String senha){
        //String pattern = "^((?=.*[@#$%^&+=]).*)";
        //return senha.matches(pattern);
        
        String PASSWORD_PATTERN = "^(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])";

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(senha);
        return matcher.matches();
    }
    
    
    public void podeEfetuarLogin(boolean contemMaiusculo, boolean contemMinusculo, boolean contemNumero, boolean contemMinimoCaracter, boolean contemMaximoCaracter, boolean semConsecutivo) throws Exception {
        if (contemMaiusculo == false|| contemMinusculo == false || contemNumero == false || contemMinimoCaracter == false || contemMaximoCaracter == false || semConsecutivo == false){
            throw new Exception("Favor informar uma senha válida que condiz com as condições de senha forte.");
        }
        else {
            efetuarLogin();
        }
    }
}
