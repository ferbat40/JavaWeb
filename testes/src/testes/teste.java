package testes;

import java.math.BigDecimal;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculadora adicao = (BigDecimal num1, BigDecimal num2) -> num1.add(num2);
	
	
				
      CalculadoraEscolha[] calcular = 
    	{
    	CalculadoraEscolha.soma,
    	CalculadoraEscolha.subtracao,
		CalculadoraEscolha.multiplicacao,
		CalculadoraEscolha.divisao,
        CalculadoraEscolha.potenciacao};
		
		for (int u = 0 ; u < calcular.length; u++)
		System.out.printf("%s  %.2f\n" ,calcular[u].getOperador(),
				CalculadoraEscolha.calculo(new BigDecimal(10),new BigDecimal(5),calcular[u].getOperacao()));
				
				
		
	}

}
