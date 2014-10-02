package aplicacionWeb;

import dao.daoUsuario;
import model.Usuario;
import hibernate.hibernateUtil;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario user = new Usuario();
		user.setIdUsuario("jacobo");
		user.setNombreUsuario("ja");
		user.setEmailUsuario("asd@asd.com");
		user.setClaveUsuario("1234");
		
		daoUsuario daoUser = new daoUsuario();
		
		boolean transaccion =  daoUser.guardarDatos(user);
	}

}
