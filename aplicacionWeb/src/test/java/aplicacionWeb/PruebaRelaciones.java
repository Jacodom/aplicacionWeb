package aplicacionWeb;



import com.dao.DaoUsuario;
import com.model.Grupo;
import com.model.Usuario;

public class PruebaRelaciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Usuario user = new Usuario();
		Usuario user2= new Usuario();
		Grupo grupo1= new Grupo();
		Grupo grupo2= new Grupo();
		
//		user.setIdUsuario("jacodom");
//		user.setNombreUsuario("Jacobo Dominguez");
//		user.setEmailUsuario("dominguezjaco@gmail.com");
//		user.setClaveUsuario("12345");
//		
//		user2.setIdUsuario("jacodom");
//		user2.setNombreUsuario("Jacobo Dominguez");
//		user2.setEmailUsuario("dominguezjaco@gmail.com");
//		user2.setClaveUsuario("12345");
//		
		DaoUsuario daouser= new DaoUsuario();
//		
//		daouser.agregar(user);
		
		
		grupo1.setIdGrupo("ADM");
		grupo1.setDescripcionGrupo("Administradores");
		grupo1.setEstadoGrupo(true);
		
		grupo2.setIdGrupo("SEG");
		grupo2.setDescripcionGrupo("Seguridad");
		grupo2.setEstadoGrupo(true);
		
//		user.addGrupo(grupo1);
//		user.addGrupo(grupo2);
		
//		System.out.println("Usuario: "+user.getNombreUsuario());
//		System.out.println("Grupo+HashCode");
//		
//		for (Grupo grupo : user.getColeccionGrupos()) {
//			System.out.println(grupo.getDescripcionGrupo()+ "  " + grupo.hashCode());
//		}
//		
//		System.out.println("\n");
//		System.out.println("usuario 1: "+daouser.obtener().get(0).getNombreUsuario()+ "  "+"HashCode: "+daouser.obtener().get(0).hashCode());
//		System.out.println("usuario 2: "+user2.getNombreUsuario()+"  "+"Hashcode: "+user2.hashCode());
//		
//		
//		if(daouser.obtener().get(0).equals(user2))
//			System.out.println("\n\nson iguales!!");
		
		
		user=daouser.obtener().get(0);
		user.setNombreUsuario("jaco");
		user.setEmailUsuario("jaco@gmail.com");
		user.setClaveUsuario("22222");
		
		user.addGrupo(grupo1);
		user.addGrupo(grupo2);
		
		daouser.modificar(user);
		
	}

}
