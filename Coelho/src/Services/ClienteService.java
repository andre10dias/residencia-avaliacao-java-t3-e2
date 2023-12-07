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

	public static void addCliente(Cliente _Cliente) {
		if (clientes == null) {
			clientes = new ArrayList<>();
		}

		for (Cliente cliente : clientes) {
			if (_Cliente.getCpf() == cliente.getCpf()) {
				System.out.println("\n Já existe cliente cadastrado com esse CPF !\n\n");
			} else {
				clientes.add(_Cliente);
				System.out.println("\nCliente cadastrado  !!\n\n");

			}
		}

	}

	public static void removeCliente(Cliente _Cliente) {

		Cliente cliente = consultarCliente(clientes,_Cliente.getCpf());

		if(cliente == null){
			System.out.println("Não é possível remover um cliente que não está cadastrado");
		}else{
			clientes.remove(_Cliente);

		}
	}

	static Cliente consultarCliente(List<Cliente> _lista_clientes, String _cliente_cpf) {
		for (Cliente cliente : _lista_clientes) {
			if (cliente.getCpf() == _cliente_cpf) {
				return cliente;
			}
		}

		return null;
	}
}
