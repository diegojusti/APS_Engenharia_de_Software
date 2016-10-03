/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author SERVMAQ
 */


public class ValidaCpfCnpj {
	private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
	private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

	private static int calcularDigito(String str, int[] peso) {
		int soma = 0;
		for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
			digito = Integer.parseInt(str.substring(indice,indice+1));
			soma += digito*peso[peso.length-str.length()+indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}

	public static boolean isValidCPF(String cpf) {
		if ((cpf==null) || (cpf.length()!=11)) return false;

            switch (cpf) {
                case "00000000000":
                    return false;
                case "11111111111":
                    return false;
                case "22222222222":
                    return false;
                case "33333333333":
                    return false;
                case "44444444444":
                    return false;
                case "55555555555":
                    return false;
                case "66666666666":
                    return false;
                case "77777777777":
                    return false;
                case "88888888888":
                    return false;
                case "99999999999":
                    return false;
                default:
                    break;
            }
              
            Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
            Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
            return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
	}

	public static boolean isValidCNPJ(String cnpj) {
		if ((cnpj==null)||(cnpj.length()!=14)) return false;

                
                switch (cnpj) {
                case "00000000000000":
                    return false;
                case "11111111111111":
                    return false;
                case "22222222222222":
                    return false;
                case "33333333333333":
                    return false;
                case "44444444444444":
                    return false;
                case "55555555555555":
                    return false;
                case "66666666666666":
                    return false;
                case "77777777777777":
                    return false;
                case "88888888888888":
                    return false;
                case "99999999999999":
                    return false;
                default:
                    break;
            }
                
            Integer digito1 = calcularDigito(cnpj.substring(0,12), pesoCNPJ);
            Integer digito2 = calcularDigito(cnpj.substring(0,12) + digito1, pesoCNPJ);
            return cnpj.equals(cnpj.substring(0,12) + digito1.toString() + digito2.toString());
	}


    public boolean isValidDocConverter(String valor) {
        
        StringBuilder doc = new StringBuilder();
        
            for(int i = 0;i<valor.length();i++){
            if(Character.isDigit(valor.charAt(i)))
                doc.append(valor.charAt(i));
            }
        
        //CPF
        if ( doc.length() == 11 ) {       
            return isValidCPF(doc.toString());
        } 
        //CNPJ
        else if ( doc.length() == 14 ) {
            return isValidCNPJ(doc.toString());            
        } 
        
        // formato incorreto
        return false;
    }        
}