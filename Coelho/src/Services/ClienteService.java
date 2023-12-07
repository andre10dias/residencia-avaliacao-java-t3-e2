package Services;

import java.util.ArrayList;
import java.util.List;

import Models.Cliente;

public class ClienteService {

	private static List<Cliente> clientes;
	
	public static List<Cliente> getClientes() {
		if (clientes == null) {
			clientes = new ArrayList<>();
		}
		
		return clientes;
	}
	
	public static void addCliente(Cliente c) {
		if (clientes == null) {
			clientes = new ArrayList<>();
		}
		
		clientes.add(c);
	}
	
	public static void removeCliente(Cliente c) {
		clientes.remove(c);
	}

	public static void alterarCliente(Cliente c) {
		clientes.set(clientes.indexOf(c), c);
	}

}
