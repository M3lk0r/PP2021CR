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
        String senhaLogin1 = "tesTe123";
        String nomeLogin2 = "dayanne";
        String senhaLogin2 = "testando";
        String nomeLogin3 = "eunice";
        String senhaLogin3 = "1TesTe";
        LoginChain login = new Login(nomeLogin1, senhaLogin1);
        login.setNext(new Login(nomeLogin2, senhaLogin2));
        login.setNext(new Login(nomeLogin3, senhaLogin3));

        try {
            login.contemMaiusculo(senhaLogin1);
            login.contemMinusculo(senhaLogin1);
            login.contemNumero(senhaLogin1);
            login.contemMinimoCaracter(senhaLogin1.length());
            login.contemMaximoCaracter(senhaLogin1.length());
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

}
