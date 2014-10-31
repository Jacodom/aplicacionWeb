package aplicacionWeb;



import com.dao.DaoUsuario;
import com.dao.DaoGrupo;
import com.model.Grupo;
import com.model.Usuario;


public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		DaoUsuario daouser = new DaoUsuario();
        String nombre;
        for(Usuario user : daouser.obtener())
        {
                nombre=user.getIdUsuario();
            if(nombre.equals("jacodom"))
                System.out.println("son iguales");
        }
    }


}
