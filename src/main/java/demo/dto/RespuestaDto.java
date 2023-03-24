/**
 * Copyright 2021 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR 
 * Todos los derechos reservados
 */

package demo.dto;

/**
 * <b> Clase Dto para las respuestas de servicios web </b>
 *
 * @author PatricioPilco
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: PatricioPilco $, $Date: 12 ago. 2021 $]
 *          </p>
 */
public class RespuestaDto {

	private String error;
	private String mensaje;
	private String detalle;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

}
