package aplicacionWeb;

import com.helpers.ConstructorVistaHelper;

/**
 * Created by Jacobo on 17/02/2015.
 */
public class testHelper {

    public static void main(String args[]){
        int cantP;

        ConstructorVistaHelper cH= new ConstructorVistaHelper();

        cantP = cH.obtenerCantidadPaginas(37,10);
        System.out.println(cantP);

        cantP = cH.obtenerCantidadPaginas(50,10);
        System.out.println(cantP);

        cantP = cH.obtenerCantidadPaginas(1032,10);
        System.out.println(cantP);


    }
}
