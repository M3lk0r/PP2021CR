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
public class Main {

    public static void main(String[] args) {
        String nomeLogin1 = "eduardo";
        String senhaLogin1 = "@Senha1";
        String nomeLogin2 = "dayanne";
        String senhaLogin2 = "testando";
        String nomeLogin3 = "eunice";
        String senhaLogin3 = "1TesTe";
        LoginChain login = new Login(nomeLogin1, senhaLogin1);
        login.setNext(new Login(nomeLogin2, senhaLogin2));
        login.setNext(new Login(nomeLogin3, senhaLogin3));

        try {
            boolean contemMaiusculo = login.contemMaiusculo(senhaLogin1);
            boolean contemMinusculo = login.contemMinusculo(senhaLogin1);
            boolean contemNumero = login.contemNumero(senhaLogin1);
            boolean contemMinimoCaracter = login.contemMinimoCaracter(senhaLogin1.length());
            boolean contemMaximoCaracter = login.contemMaximoCaracter(senhaLogin1.length());
            boolean semConsecutivo = login.semConsecutivo(senhaLogin1);
            
            login.podeEfetuarLogin(contemMaiusculo, contemMinusculo, contemNumero, contemMinimoCaracter, contemMaximoCaracter, semConsecutivo);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

}
