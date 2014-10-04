package aplicacionWeb;

import java.util.List;

import com.dao.DaoUsuario;
import com.model.Usuario;


public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario user = new Usuario();
		Usuario usuario2= new Usuario();
		
		user.setIdUsuario("NoelC");
		user.setNombreUsuario("Noel Rafael Cantoia");
		user.setEmailUsuario("noec@asd.com");
		user.setClaveUsuario("12345");
		
		usuario2.setIdUsuario("jacobo");
		
		
		
		DaoUsuario daoUser = new DaoUsuario();
		
		List<Usuario> lista= daoUser.obtener();
		
		for(int x=0;x<lista.size();x++){
			System.out.println("Nombre: "+((Usuario) lista.get(x)).getNombreUsuario());
		}
		}

}
