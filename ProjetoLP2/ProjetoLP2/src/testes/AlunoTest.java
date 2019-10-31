package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Aluno;

public class AlunoTest {
	private Aluno aluno;
	
	@Before
	public void criaAluno() throws Exception {
		aluno = new Aluno("Gilmar", "123", 1, "", "gilmar@gmail");
	}
	@Test
	public void testaGetsAluno(){
		assertEquals("Nome errado", "Gilmar", aluno.getNome());
		assertEquals("Matricula errada", "123", aluno.getMatricula());
		assertEquals("Codigo de curso errado",  1, aluno.getCodCurso());
		assertEquals("Telefone errado", "", aluno.getTelefone());
		assertEquals("Email errado", "gilmar@gmail", aluno.getEmail());
	}
	@Test
	public void testaToString() {
		assertEquals("toString errado", "123 - Gilmar - 1 - gilmar@gmail", aluno.toString());
	}

}
