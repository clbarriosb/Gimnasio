
package taller2estructuras;

import java.util.*;


public class Gimnasio {

    int cedula;

    public static int tamano(int[] h) {
        System.out.println(Arrays.toString(h));
        int size = 0;
        for (int value : h) {
            if (value != 0) {
                size++;
            }
        }
        System.out.println("size "+size);
        return size;
    }

    public static int min(int[] t) {
        int Mnum = t[0];
        int pos = 0;
        System.out.println("hola, si entro");
        for (int x = 1; x < t.length; x++) {
            System.out.println("t length " + t.length);
            System.out.println("t[x] " + t[x] + " x " + x + " mnum " + Mnum); 
            if (t[x] > Mnum) {
                Mnum = t[x];
                pos = x;
                System.out.println("mnum " + Mnum + " pos " + pos);
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        HashMap<Integer, String> registro = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        int caso =1;
        while (testCases > 0) {
            System.out.println("Caso #" + caso +":");
            System.out.println(testCases + " test cases");
            testCases--;
            System.out.println(testCases + " test cases");
            int numeroCasilleros = scan.nextInt();
            System.out.println("numero casilleros " + numeroCasilleros);
            list lista = new list();
            for (int i = 0; i < numeroCasilleros; i++) {
                System.out.println("n ");
                int n = scan.nextInt();
                int[] cubiculo = new int[n];
                lista.fill(cubiculo);
            }
            int it=scan.nextInt();
            System.out.println("it " + it);
            for(int y=0;y<it;y++){
                System.out.println("y " + y + " it " + it);
                String option = scan.next();
                if (option.equals("ingresar")) {
                    String name = scan.next();
                    String surname = scan.next();
                    int cedula = scan.nextInt();
                    while (registro.containsKey(cedula) == true) {
                        name = scan.next();
                        surname = scan.next();
                        cedula = scan.nextInt();
                    }
                    registro.put(cedula, name);
                    int[] mat = new int[lista.size()];
                    System.out.println(lista.size());
                    node temp = lista.start;
                    for (int u = 0; u < lista.size(); u++) {
                        mat[u] = tamano(temp.casillero) / temp.casillero.length;
                        System.out.println("mat " + mat[u] + " tamaño " + 
                                tamano(temp.casillero) + " length " + 
                                temp.casillero.length);
                        temp = temp.next;
                    }
                    int ps = min(mat) +1;
                    System.out.println("ps " + ps);
                    node act = lista.start;
                    for (int r = 0; r <= ps; r++) {
                        act = act.next;
                    }
                    for (int a = 0; a < act.casillero.length; a++) {
                        System.out.println(act.casillero.length);
                        if (act.casillero[a] == 0) {
                            act.casillero[a] = cedula;
                            System.out.println(ps + " " + (a+1));
                            break;
                        }
                    }
                } else if (option.equals("salir")) {
                    int cedula = scan.nextInt();
                    node yedi= lista.start;
                    for(int i=0;i<lista.size();i++){
                        for(int j=0;j<yedi.casillero.length;j++){
                            if(yedi.casillero[j]== cedula ){
                                yedi.casillero[j]=0;
                                i = lista.size();
                                break;
                            }

                        }
                        yedi=yedi.next;
                    }
                    System.out.println(registro.get(cedula));
                    registro.remove(cedula);
                }
            }

        }

    }

}
