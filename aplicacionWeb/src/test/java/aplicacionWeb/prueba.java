package aplicacionWeb;

import java.util.List;

import com.dao.DaoUsuario;
import com.model.Grupo;
import com.model.Usuario;


public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario user = new Usuario();
		Grupo grupo = new Grupo();
		

		/*user.setIdUsuario("JacodomD");
		user.setNombreUsuario("jacobito");
		user.setEmailUsuario("noec@asd.com");
		user.setClaveUsuario("12345");
		
		grupo.setIdGrupo("ADM");
		grupo.setDescripcionGrupo("ADMINISTRADORES");
		
		grupo.addUsuario(user);*/
		
		DaoUsuario daoUsuario= new DaoUsuario();
		
		//daoUsuario.agregar(user);
		
		List<Usuario> lista= daoUsuario.obtener();
		
		user= lista.get(2);
		System.out.println("usuario: "+user.getNombreUsuario()+" grupo: "+user.getGrupos().get(0).getDescripcionGrupo());
		
		
		/*for(int x=0;x<lista.size();x++){
			user= (Usuario)lista.get(x);
			grupo= user.getGrupos().get(0);
			System.out.println("Usuario: "+user.getNombreUsuario()+" Grupo: "+grupo.getDescripcionGrupo());
		}*/
		
		
		
		
		}

}
