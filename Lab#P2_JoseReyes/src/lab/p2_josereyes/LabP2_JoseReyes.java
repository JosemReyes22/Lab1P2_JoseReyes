/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab.p2_josereyes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author josem
 */
public class LabP2_JoseReyes {

    /**
     * @param args the command line arguments
     */
    static Date fecha;
    static SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
    public static void main(String[] args) {
        // TODO code application logic her
        Scanner r=  new Scanner(System.in);
        int menu=1;
        
        while(menu==1){
            System.out.println("\n~~~~~~~MenuPrincipal~~~~~~~\n1.Calculadora de fechas\n2.Numero palindromo\n3.Salir");
            System.out.print("Elija su opcion: ");
            int opcion=r.nextInt();
            
            switch(opcion){
                case 1:{
                    Calendar FechActual =  new GregorianCalendar(2023,4,21);
                    fecha= FechActual.getTime();
                    System.out.println("Ingrese la fecha ejemplo(2021/04/21): ");
                    String Fechas=r.next();
                    boolean continuar=Validar(Fechas);
                    if(continuar){
                        System.out.println("Fecha Valida");
                    }else{
                        System.out.println("Fecha invalida");
                    }
                }break;
                case 2:{
                    String digito="";
                    System.out.print("Ingrese la cantidad de digitos del numero: ");
                    int digitos=r.nextInt();
                    while(digitos%2==0){
                        System.out.print("La cantidad de digitos debe ser impar\nIngrese la cantidad de digitos del numero: ");
                        digitos=r.nextInt();
                    }
                    int[]numero=new int[digitos];
                    for (int i = 0; i < digitos; i++) {
                        System.out.println("Ingrese un digito");
                        int num=r.nextInt();
                        numero[i]=num;
                    } 
                    System.out.print("El numero ingresado es: ");
                    for (int i = 0; i < digitos; i++) {
                        System.out.print(numero[i]);
                        }
                    boolean pal=Palindromo(numero, 0, digitos-1);
                    if(pal){
                        

                        System.out.println("\nEl numero es palindromo ");
                    }else{
                        System.out.println("\nEl numero no es palindromo");  
                    }
                }break;
                case 3:{
                    menu=0;
                    System.out.println("Programa terminado");
                }break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    } public static boolean Validar(String fe){
        String [] Final=fe.split("/");
        int anios=Integer.parseInt(Final[0]);
        int meses=Integer.parseInt(Final[1]);
        int dias=Integer.parseInt(Final[2]);
        
        if(meses<=12 && dias<=31){
            Diferencia(dias,meses,anios);
            return true;
        }
        return false;
    }
    
    public static void Diferencia(int uno,int dos,int tres){
        if(tres>=2023){
            int diasDiferencia =(tres* 365 + dos * 31 + uno)- (2023 * 365 + 4 * 31 + 21) ;
            int aniosDiferencia = diasDiferencia / 365;
            int mesesDiferencia = (diasDiferencia % 365) / 31;
            int diasRestantes = (diasDiferencia % 365) % 31;

            System.out.println("Fecha actual: "+formato.format(fecha));
            System.out.println("Fecha introducida por el usuario: " + uno + "/" + dos + "/" + tres);
            System.out.println("Diferencia: " + aniosDiferencia + " anios, " + mesesDiferencia + " meses y " + diasRestantes + " dias.");
        }else{
            int diasDiferencia = (2023 * 365 + 4 * 31 + 21) - (tres* 365 + dos * 31 + uno);
            int aniosDiferencia = diasDiferencia / 365;
            int mesesDiferencia = (diasDiferencia % 365) / 31;
            int diasRestantes = (diasDiferencia % 365) % 31;

            System.out.println("Fecha actual: "+formato.format(fecha));
            System.out.println("Fecha introducida por el usuario: " + uno + "/" + dos + "/" + tres);
            System.out.println("Diferencia: " + aniosDiferencia + " anios, " + mesesDiferencia + " meses y " + diasRestantes + " dias.");
        }
    }
      public static boolean Palindromo(int[] arr,int in,int out){   
        if (in >= out) {
            return true;
        }
        if (arr[in] == arr[out]) {
            return Palindromo(arr, in+1, out-1);
        } else {
            return false;
        }
    }
}
