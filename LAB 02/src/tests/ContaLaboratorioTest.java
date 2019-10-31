package tests;
import org.junit.Assert;
import org.junit.Test;
import lab2.ContaLaboratorio;

public class ContaLaboratorioTest {
	
	@Test
	public void testaConsomeLiberaEspacoTrue() {
		ContaLaboratorio lab1 = new ContaLaboratorio("LCC3");
		lab1.consomeEspaco(200);
		lab1.liberaEspaco(50);
		lab1.consomeEspaco(850);
		lab1.liberaEspaco(20);
		lab1.consomeEspaco(220);
		lab1.consomeEspaco(800);
		Assert.assertTrue("Retornou false qdo cota eh maior ou igual a 2000", lab1.atingiuCota());	
	}
	
	@Test
		public void testaConsomeLiberaEspacoFalse() {
		ContaLaboratorio lab1 = new ContaLaboratorio("LCC3");
		lab1.consomeEspaco(200);
		lab1.liberaEspaco(100);
		lab1.consomeEspaco(200);
		lab1.liberaEspaco(150);
		lab1.consomeEspaco(220);
		lab1.consomeEspaco(500);
		Assert.assertFalse("Retornou true qdo cota menor que 2000", lab1.atingiuCota());
	}

}
