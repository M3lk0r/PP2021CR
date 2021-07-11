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
public class Login extends LoginChain {

    protected Login(String nome, String senha) {
        super(nome, senha);
    }

    @Override
    public void efetuarLogin() {
        System.out.println("Pode efetuar login.");
    }

}
