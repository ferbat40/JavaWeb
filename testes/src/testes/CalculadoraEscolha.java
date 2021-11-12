package testes;

import java.math.BigDecimal;

public enum CalculadoraEscolha {
     soma ("+" ,(BigDecimal num1, BigDecimal num2) -> num1.add(num2)),
     subtracao ("-", (BigDecimal num1, BigDecimal num2) -> num1.subtract(num2)),
     multiplicacao ("*",(BigDecimal num1, BigDecimal num2) -> num1.multiply(num2)),
	 divisao ("/", (BigDecimal num1, BigDecimal num2) -> num1.divide(num2)),
	 potenciacao ("**", new Calculadora() {
			
			@Override
			public BigDecimal calculo(BigDecimal num1, BigDecimal num2) {
				// TODO Auto-generated method stub
				return num1.pow(num2.intValue());
			}
		});

	 final private String operador;
	 final private Calculadora operacao;
	
	
	CalculadoraEscolha(String operador, Calculadora operacao) {
		this.operador=operador;
		this.operacao=operacao;
	}
	
	
	public String getOperador() {
		return operador;
	}


	public Calculadora getOperacao() {
		return operacao;
	}

	public static BigDecimal calculo(BigDecimal valor1, BigDecimal valor2, Calculadora calculadora) {
		return calculadora.calculo(valor1, valor2);
		
	}
	

	
	
}
