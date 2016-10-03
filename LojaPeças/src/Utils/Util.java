/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import javax.swing.JOptionPane;


/**
 *
 * @author Diego Justi
 */
public class Util{
    
    public static final int OPERATION_NEW = 1;
    public static final int OPERATION_EDIT = 2;
    public static final int OPERATION_DELETE = 3;
    public static final int OPERATION_VIEW = 4;
    
    public static void showStatusMessage(int ret, String msgSuccessful, String msgDuplicateKey, String msgError){
        switch(ret){
            case 1:
                if(msgSuccessful == null)
                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
                else
                    JOptionPane.showMessageDialog(null, msgSuccessful);
                break;
            case 0:
                if(msgDuplicateKey == null)
                    JOptionPane.showMessageDialog(null, "Chave primária já cadastrada");
                else
                    JOptionPane.showMessageDialog(null, msgDuplicateKey);
                break;
            case -1:
                if(msgError == null)
                    JOptionPane.showMessageDialog(null, "Erro na operação");
                else
                    JOptionPane.showMessageDialog(null, msgError);
                break;
        }
    }
    
    
}
