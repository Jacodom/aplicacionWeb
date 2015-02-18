package com.helpers;

/**
 * Created by Jacobo on 17/02/2015.
 */
public class ConstructorVistaHelper {

    public int obtenerCantidadPaginas(int cantItems,int itemsPagina){
        int cantP;
        int resto;
        int cociente;

        cociente=cantItems/itemsPagina;
        resto=cantItems%itemsPagina;

        if(resto>0){
            return cociente+1;
        }else
            return cociente;
    }
}
