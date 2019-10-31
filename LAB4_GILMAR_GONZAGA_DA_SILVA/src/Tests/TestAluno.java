package Tests;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import lab04.Aluno;

public class TestAluno {
	private Aluno aluno2;

	@Before
	public void criaAluno() {
		aluno2 = new Aluno("250", "gilmar", "computacao");
	}
	@Test
	public void testaGetsDeAluno() {
		assertEquals("Matricula errada", "250", aluno2.getMatricula());
		assertEquals("Nome errado", "gilmar", aluno2.getNome());
		assertEquals("Curso errado", "computacao", aluno2.getCurso());
	}
	@Test
	public void testaToString() {
		assertEquals("toString errado", "250 - gilmar - computacao", aluno2.toString());
	}

}
