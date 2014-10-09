package aplicacionWeb;



import com.dao.DaoUsuario;
import com.model.Usuario;


public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario user = new Usuario();

		

		user.setIdUsuario("Pablo");
		user.setNombreUsuario("Pablo cordoba");
		user.setEmailUsuario("pablo@asd.com");
		user.setClaveUsuario("12345");
		
		DaoUsuario daouser = new DaoUsuario();
		
		boolean add=  daouser.agregar(user);
		
		if(add==true)
			System.out.println("agregó!!");
		
		}

}
