package com.curso.java_aula36;

public class TesteContato {

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		contato.setNome("Tyrion");
		//contato.setEndereco("Rua dois");
		//contato.setTelefone("11-99999-9999");
		
		
		// Relacionamento tem um endereço
		//criar objeto endereco
		
		Endereco end = new Endereco();
		end.setNomeRua("Rua Game of Thromes");
		end.setNumero("n/a");
		end.setComplemento("_");
		end.setEstado("SP");
		end.setCidade("Osasco");
		end.setCep("00067-000");

		contato.setEndereco(end);
		
		// Relacionamento tem um telefone
		
		Telefone telefone = new Telefone();
		
		telefone.setDdd("Celular");
		telefone.setDdd("11");
		telefone.setNumero("99999-9999");
		
		Telefone telefone2 = new Telefone();
		
		telefone2.setDdd("Casa");
		telefone2.setDdd("11");
		telefone2.setNumero("12345-7890");
		
		Telefone[] telefones = new Telefone[2];
		telefones[0] = telefone;
		telefones[1] = telefone2;
		contato.setTelefones(telefones);
		
				
		
		//contato.setTelefone(telefone);
		
		// Teste saida console
		System.out.println(contato.getNome());		
		//System.out.println(contato.getTelefone());
			
			if (contato != null && contato.getEndereco() != null) {
		
		System.out.println(contato.getEndereco().getCidade());
			}
			
			/*if (contato != null && contato.getTelefone() != null) {
				 
		System.out.println(contato.getTelefone().getDdd() + " " + contato.getTelefone().getNumero());	
			}
	}	*/
			
			if(contato != null && contato.getTelefones() != null) {
				for (Telefone t: contato.getTelefones()) {
					System.out.println(t.getDdd() + " " +t.getNumero());		
					
				}
			}
			}
				
}
