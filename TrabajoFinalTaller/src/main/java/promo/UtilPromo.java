package promo;

import java.util.HashMap;
import java.util.Iterator;

import modeloDatos.Cliente;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;

public class UtilPromo
{
	/**
	 * El metodo aplicaPromo se utiliza para seleccionar y beneficiar a un cliente
	 * especifico (ya sea un Empleador o un EmpleadoPretenso) Si
	 * promoPorListaDePostulantes es true, la promocion se basara en el tamano de
	 * las listas de postulantes de los Empleadores y EmpleadoPretenso. Si
	 * promoPorListaDePostulantes es false, se basara simplemente en la cantidad
	 * total de Empleadores y EmpleadoPretenso sin considerar las listas de
	 * postulantes
	 * 
	 * @param promoPorListaDePostulantes Este parametro es un booleano que controla
	 *                                   el tipo de promocion que se aplicara.
	 * @param empleados HashMap que contiene a los EmpleadoPretenso.
 	 * @param empleadores HashMap que contiene a los Empleadores.
	 * @return objeto Cliente beneficiado (ya sea un Empleador
	 *         o un EmpleadoPretenso) <br>
	 *         <b>Pre: </b> los parametros empleados y empledores son diferentes de null<br>
	 * 
	 */

	public Cliente aplicaPromo(boolean promoPorListaDePostulantes, 
			HashMap<String, EmpleadoPretenso> empleados, HashMap<String, Empleador> empleadores)
	{
		Iterator clientes = null;
		int contadorEmpleador = 0;
		int contadorEmpleadoPretenso = 0;
		Cliente clienteBeneficiado = null;

		if (promoPorListaDePostulantes)
		{
			Iterator<Empleador> itEmpleadores = empleadores.values().iterator();
			while (itEmpleadores.hasNext())
			{
				Empleador empleador = itEmpleadores.next();
				if (empleador.getListaDePostulantes() != null)
					contadorEmpleador += empleador.getListaDePostulantes().size();
			}
			Iterator<EmpleadoPretenso> itEmpleados = empleados.values().iterator();
			while (itEmpleados.hasNext())
			{
				EmpleadoPretenso empleadoPretenso = itEmpleados.next();
				if (empleadoPretenso.getListaDePostulantes() != null)
					contadorEmpleadoPretenso += empleadoPretenso.getListaDePostulantes().size();
			}
		} else
		{
			contadorEmpleador = empleadores.size();
			contadorEmpleadoPretenso = empleados.size();
		}

		if (contadorEmpleador > contadorEmpleadoPretenso)
			clientes = empleadores.values().iterator();
		else
			clientes = empleados.values().iterator();

		int puntajeMaximo = Integer.MIN_VALUE;
		while (clientes.hasNext())
		{
			Cliente cl = (Cliente) clientes.next();
			if (cl.getPuntaje() > puntajeMaximo)
			{
				puntajeMaximo = cl.getPuntaje();
				clienteBeneficiado = cl;
			}
		}
		return clienteBeneficiado;
	}

}