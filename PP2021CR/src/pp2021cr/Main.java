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
        String senhaLogin1 = "@tesTe124";
        String nomeLogin2 = "fulano";
        String senhaLogin2 = "testando";
        String nomeLogin3 = "ciclano";
        String senhaLogin3 = "1TesTe";
        LoginChain login = new Login(nomeLogin1, senhaLogin1);
        login.setNext(new Login(nomeLogin2, senhaLogin2));
        login.setNext(new Login(nomeLogin3, senhaLogin3));

        try {
            boolean valido = LoginChain.valido(senhaLogin1);
            login.podeEfetuarLogin(valido);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

}
