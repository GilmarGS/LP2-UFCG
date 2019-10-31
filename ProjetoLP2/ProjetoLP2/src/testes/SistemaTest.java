package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import controller.ControllerAluno;



public class SistemaTest {
	
	private ControllerAluno alunoController;

	
	@Before
	public void iniciaSistema() throws Exception{
		alunoController = new ControllerAluno();
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testaEmailInvalido()throws Exception{
		alunoController.cadastrarAluno("Gilmar", "321", 1, "", "gilmar");
	}
	@Test
	public void testaNomeVazio()throws Exception{
		try {
		alunoController.cadastrarAluno("", "123", 1, "", "gilmar@gmail");
		fail("Esperava excecao para nome vazio");
		}catch (Exception e) {
			assertEquals("Mensagem errada", "Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo", e.getMessage());
		
		}
	}
}
