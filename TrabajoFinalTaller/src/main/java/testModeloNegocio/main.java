package testModeloNegocio;

import java.io.IOException;

import modeloNegocio.Agencia;

public class main {

	public static void main(String[] args) {
		Agencia agencia=Agencia.getInstance();
		try {
			System.out.println(agencia.guardarAgencia("C:\\Users\\ignac\\git\\repository\\TrabajoFinalTaller\\pepito.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
