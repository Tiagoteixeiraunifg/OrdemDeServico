package ordemservico.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe responsavel por validacoes de CPF e CNPJ
 *
 * @author Tiago Teixeira
 */
public class Util {

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    //false CNPJ -- true CPF
    private static boolean tipoCpfCnpj;

    /**
     *  //false CNPJ -- true CPF
     * @return 
     */
    public  boolean isTipoCpfCnpj() {
        return tipoCpfCnpj;
    }
    
    //entra com uma string e valida se é valido ou nâo o CPF ou CNPJ
    public boolean isValid(String cpfCnpj) {
        return (isValidCPF(cpfCnpj) || isValidCNPJ(cpfCnpj));
    }
    
    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    private static String padLeft(String text, char character) {
        return String.format("%11s", text).replace(' ', character);
    }

    private static boolean isValidCPF(String cpf) {
        cpf = cpf.trim().replace(".", "").replace("-", "");
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }

        for (int j = 0; j < 10; j++) {
            if (padLeft(Integer.toString(j), Character.forDigit(j, 10)).equals(cpf)) {
                return false;
            }
        }

        Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
        tipoCpfCnpj = true;
        return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString()); 
    }

    private static boolean isValidCNPJ(String cnpj) {
        cnpj = cnpj.trim().replace(".", "").replace("-", "");
        if ((cnpj == null) || (cnpj.length() != 14)) {
            return false;
        }

        Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
        tipoCpfCnpj = false;
        return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
    }

    
    


    /**
     * entra uma string e retira os dados desejados em qualquer parte que esteja
     * @param dado
     * @return
     */
    public String replaceDado(String dado) {
        dado = dado.replaceAll("\\.", "");
        dado = dado.replaceAll("-", "");
        dado = dado.replaceAll("R", "");
        dado = dado.replaceAll("$", "");
        dado = dado.replaceAll("/", "");
        return dado;
    }
    

   

    /**
     * entra uma string no formato BR 01/05/2010 e retorna em formato US
     * @param dataEntrada
     * @return Retorna DATA formatada em formato US 2010-05-01
     */
    public String dataFormatoUS(String dataEntrada) {
        //10-10-2010
        String dia = dataEntrada.substring(0, 2);
        String mes = dataEntrada.substring(3, 5);
        String ano = dataEntrada.substring(6);
        String dataSaida = ano + "/" + mes + "/" + dia;
        return dataSaida;
    }
    
     /**
     * entra uma string no formato US 2010-05-01 e retorna em formato BR
     * @param dataEntrada
     * @return  string com data formatada em formato BR 01/05/2020
     */
    public String dataFormatoBR(String dataEntrada) {
        //2001-01-01 10-10-2010
        String ano = dataEntrada.substring(0, 4);
        String mes = dataEntrada.substring(5, 7);
        String dia = dataEntrada.substring(8,10);
        String dataSaida = dia + "/" + mes + "/" + ano;
        return dataSaida;
    }
    
    //entra uma string de data e retorna se e valida ou não (true ou false)
    public boolean validaDataFormatoBR(String data) {
      try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");            
            sdf.setLenient(false);            
            sdf.parse(data);            
            return true;
        } catch (ParseException ex) {            
            return false;
        }
    }

    public double formataMoeda(String arg) {
        double number = 0;
        //obtem um NumberFormat para o Locale default (BR)
        try {
            NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
            //converte um número com vírgulas ex: 2,56 para double/float a gosto de escolha
            
            nf.setMaximumFractionDigits(2);
            number = nf.parse(arg).doubleValue();
            // return number;
        } catch (ParseException e) {
        }
        return number;
    }
    

    
    /**
     * Recebe uma String de Email e valida retornando false para invalido e true para valido
     * @param email - formato email@dominio.com
     * @return - true Valido, false Invalido
     */
    /**
     * Valida o email caso seja valido retorna "true" caso seja invalido retorna "false"
     * @param email
     * @return 
     */
    public  boolean isValidEmailAddressRegex(String email) {
    boolean isEmailIdValid = false;
    if (email != null && email.length() > 0) {
        String expressao = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expressao, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            isEmailIdValid = true;
        }
    }
    return isEmailIdValid;
}
    
    public String recuperaData(){
        // data/hora atual
        LocalDateTime atual = LocalDateTime.now();

        // formatar a data
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        String dataFormatada = formatterData.format(atual);

      return dataFormatada;
    }
    
    public String recuperaHora(){
        // data/hora atual
        LocalDateTime atual = LocalDateTime.now();

        // formatar a hora
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormatada = formatterHora.format(atual);
      return horaFormatada;
    }
    
    public String recuperaDataHoraBR(String DataUs){

        //2021-06-01 22:42:55
        //2001-01-01 10-10-2010
        String ano = DataUs.substring(0, 4);
        String mes = DataUs.substring(5, 7);
        String dia = DataUs.substring(8,10);
        String hora = DataUs.substring(11);
        String dataHoraSaida = dia + "/" + mes + "/" + ano + " " + ""+hora+"";
        return dataHoraSaida;

    }
    
    public String recuperaDtHr(String DataFormatoBR){
     String dataUs = dataFormatoUS(DataFormatoBR);
     
     String saida = dataUs+" " +recuperaHora();
     return saida;
    }

}
