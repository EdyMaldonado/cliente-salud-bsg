package demo.cliente;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import demo.dto.OrdenFarmaciaDto;
import demo.dto.RespuestaDto;

public class ClienteBsg {
	private Client cliente;

	public ClienteBsg() {
		cliente = ClientBuilder.newClient();
	}

	/**
	 * Metodo para consumir get con un solo parametro
	 * 
	 * @param cedula
	 * @return
	 */
	public String consultarMsp(String cedula) {
		String resultado = cliente.target(
				"http://localhost:8082/servicio-salud-bsg-msp-discapacidad-web/salud-msp/v1/api/msp/consulta-discapacidad")
				.path(cedula).request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.header("username", "1003449004").header("client_ip", "192.168.56.12").get(String.class);
		// .header(HttpHeaders.AUTHORIZATION, "Bearer " + "... encoded token ..."); // Cuando es con token de autorización
		JSONObject json = new JSONObject(resultado);
		String fechaNacimiento = json.getString("fechaNacimiento");
		String deficienciaPredomina = json.getString("deficienciaPredomina");
		String porcentajeDiscapacidad = json.getString("porcentajeDiscapacidad");
		return resultado + " ** " + fechaNacimiento + " ** " + deficienciaPredomina + " ** " + porcentajeDiscapacidad;
	}

	/**
	 * Metodo para consumir get con varios parametros Cuando el metodo GET contengan
	 * mas de 2 parametros de entrada emplear QueryParam tanto en WS como en el
	 * cliente, en postman o insomnia en la pestaña Query ingresar cada parametro
	 * 
	 * @param cedula
	 * @param fecha
	 * @return
	 */
	public String consultarIssfa(String cedula, String fecha) {
		String resultado = cliente.target(
				"http://localhost:8082/servicio-salud-bsg-issfa-asegurado-web/salud-issfa/v1/api/issfa/consulta-asegurado")
				.path(cedula).path(fecha).request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.header("username", "1003449004").header("client_ip", "192.168.56.12").get(String.class);
		// .header(HttpHeaders.AUTHORIZATION, "Bearer " + "... encoded token ..."); // Cuando es con token de autorización
		JSONObject json = new JSONObject(resultado);
		String mensaje = json.getString("mensaje");
		String nombres = json.getString("nombres");
		String porcentaje = json.getString("porcentaje");
		return resultado + " ** " + mensaje + " ** " + nombres + " ** " + porcentaje;
	}

	/**
	 * Metodo para consumir get con varios parametros empleando query params
	 * @param cedula
	 * @param fecha
	 * @return
	 */
	public String consultarConQuery(String cedula, String fecha) {
		String resultado = cliente.target(
				"http://localhost:8082/servicio-salud-bsg-issfa-asegurado-web/salud-issfa/v1/api/issfa/consulta-asegurado")
				.queryParam("cedula", cedula).queryParam("fecha" + fecha).request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.header("username", "1003449004").header("client_ip", "192.168.56.12").get(String.class);
		// .header(HttpHeaders.AUTHORIZATION, "Bearer " + "... encoded token ..."); // Cuando es con token de autorización
		JSONObject json = new JSONObject(resultado);
		String mensaje = json.getString("mensaje");
		String nombres = json.getString("nombres");
		String porcentaje = json.getString("porcentaje");
		return resultado + " ** " + mensaje + " ** " + nombres + " ** " + porcentaje;
	}
	
	/**
	 * Metodo post para autorizar recetas, envia un json y recibe como respuesta otro json
	 * @param entrada
	 * @return
	 */
	public String autorizar(OrdenFarmaciaDto entrada) {
		WebTarget target = cliente.target(
				"http://localhost:8082/servicio-salud-farmacia-externa-autorizacion-web/salud1/v1/api/autorizacion/").path("autorizar");
		Invocation.Builder invoc = target.request(MediaType.APPLICATION_JSON).header("X-JWT-Assertion",
				"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6Ik5UZG1aak00WkRrM05qWTBZemM1TW1abU9EZ3dNVEUzTVdZd05ERTVNV1JsWkRnNE56YzRaQT09In0=.eyJodHRwOlwvXC93c28yLm9yZ1wvY2xhaW1zXC91c2VybmFtZSI6IkZBUk1BQ0lBMDIiLCJodHRwOlwvXC93c28yLm9yZ1wvY2xhaW1zXC9yb2xlIjpbIkFwcGxpY2F0aW9uXC9mYXJtYWNpYWV4dGVybmFzIiwiSW50ZXJuYWxcL2V2ZXJ5b25lIl0sImh0dHA6XC9cL3dzbzIub3JnXC9jbGFpbXNcL2FwaW5hbWUiOiJJRVNTLUFQSS1SZXN0LU1lZGljYW1lbnRvMiIsImh0dHA6XC9cL3dzbzIub3JnXC9jbGFpbXNcL2FwcGxpY2F0aW9udGllciI6IlVubGltaXRlZCIsImh0dHA6XC9cL3dzbzIub3JnXC9jbGFpbXNcL2tleXR5cGUiOiJQUk9EVUNUSU9OIiwiaHR0cDpcL1wvd3NvMi5vcmdcL2NsYWltc1wvdmVyc2lvbiI6IjEuMC4wIiwiaXNzIjoid3NvMi5vcmdcL3Byb2R1Y3RzXC9hbSIsImh0dHA6XC9cL3dzbzIub3JnXC9jbGFpbXNcL2FwcGxpY2F0aW9ubmFtZSI6IkFwcEZhcm1hY2lhc0V4dGVybmFzIiwiaHR0cDpcL1wvd3NvMi5vcmdcL2NsYWltc1wvZW5kdXNlciI6IkZBUk1BQ0lBMDJAY2FyYm9uLnN1cGVyIiwiaHR0cDpcL1wvd3NvMi5vcmdcL2NsYWltc1wvZW5kdXNlclRlbmFudElkIjoiLTEyMzQiLCJodHRwOlwvXC93c28yLm9yZ1wvY2xhaW1zXC9hcHBsaWNhdGlvblVVSWQiOiI1NDIwNDcxYy05NDMwLTRjMmYtODFkYi1iYzJiN2NmMTliY2QiLCJodHRwOlwvXC93c28yLm9yZ1wvY2xhaW1zXC91c3VhcmlvIjoiRkFSTUFDSUEwMnwwMDF8MTc2MDAwNDY1MDAwMXwwLjAuMC4wIiwiaHR0cDpcL1wvd3NvMi5vcmdcL2NsYWltc1wvc3Vic2NyaWJlciI6ImFkbWluIiwiaHR0cDpcL1wvd3NvMi5vcmdcL2NsYWltc1wvdGllciI6IlVubGltaXRlZCIsImV4cCI6MTY0NzcwMjM0MiwiaHR0cDpcL1wvd3NvMi5vcmdcL2NsYWltc1wvYXBwbGljYXRpb25pZCI6IjIxIiwiaHR0cDpcL1wvd3NvMi5vcmdcL2NsYWltc1wvdXNlcnR5cGUiOiJBcHBsaWNhdGlvbl9Vc2VyIiwianRpIjoiNTg2ODIxMDUtNmFiOS00NjViLWE0MWQtNDdjODFhZDIxMDk5IiwiaHR0cDpcL1wvd3NvMi5vcmdcL2NsYWltc1wvYXBpY29udGV4dCI6IlwvbWVkaWNhbWVudG9zXC8xLjAuMCJ9.UboDg8onz12rw7ytRigphSBK3rjANSqru3dB35zz8Cgu4v9HDYiU0rKZPHxD39TN0N3PxfISP60aX-DLUrj4cW8CpwlhKaaTx8XZQ78sRyZwPalVapG-n4lrfl5medML9VOICCMOhI7-9a8B1sT2QahfRTERH9OhIiGwdpKP0Yxpq4-eWyNnPy0sHA0WfZgN-PI0a0ldOd7vLeUPNOurGgMyrQs6qhDXhQkbMUVGmrmzT9cBWGS2_l8zMId9C-5IfPi_-9RoutFqhJaNK9ai6FGrvUf4LcmTHDDL-jW1Ad5aFpwKXFtJwTmExIikZdpK2BdxC2F1ow5KT9ANR2zJzA==")
				.header("client_ip", "192.168.56.12");
		// .header(HttpHeaders.AUTHORIZATION, "Bearer " + "... encoded token ..."); // Cuando es con token de autorización
		RespuestaDto respuesta = invoc.post(Entity.json(entrada), RespuestaDto.class);
		Response res = invoc.post(Entity.json(entrada));
		//OrdenAutorizadaDto resultado = invoc.post(Entity.json(entrada), OrdenAutorizadaDto.class);
		
		
		//Response response = invoc.post(Entity.entity(entrada, MediaType.APPLICATION_JSON), OrdenFarmaciaDto.class);
		System.out.println(entrada.toString() + "response: " + res.getStatus() + "  " + respuesta.getError());
		return "";
	}
}
