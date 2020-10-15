package objects;

import java.io.Serializable;

public class Servico implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//------------------------------------------------------//
	//Atributos
	
	private String nome;
	private String cliente;
	private String data;
	private String horario;
	//------------------------------------------------------//
	//Construtor
	
	public Servico(String servico, String cliente, String data, String horario) {
		this.nome = servico;
		this.cliente = cliente;
		this.data = data;
		this.horario = horario;
	}
	
	
	
	//------------------------------------------------------//
	//Getters e Setters
	
	@Override
	public String toString() {
		return "nome=" + nome + ", cliente=" + cliente + ", data=" + data + ", horario=" + horario +"\n";
	}

	public void printar() {
		System.out.println(this.nome);
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	
	
	/*
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	@SuppressWarnings("unchecked")
	public boolean addCliente(String alvo) throws IOException, ClassNotFoundException {
		
		FileInputStream input = new FileInputStream(pathClientes);
		ObjectInputStream leitor = new ObjectInputStream(input);
		ArrayList<Cliente> clientesSer = (ArrayList<Cliente>) leitor.readObject();
		leitor.close();
		
		String nomealvo = alvo.toLowerCase().trim();
		
		for(Cliente c : clientesSer) {
			
			String nomec = c.getNome().toLowerCase().trim();
			
			if (nomec.equals(nomealvo)) {
				this.clientes.add(c);
				return true;
			}
			
		}
		return false;
	}
	*/
	
}
