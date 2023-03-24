/**
 * Copyright 2022 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */

package demo.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * <b> Clase Dto para la receta autorizada. </b>
 * 
 * @author luis.maldonadoq
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: luis.maldonadoq $, $Date: 19 oct. 2022 $]
 *          </p>
 */
public class OrdenAutorizadaDto implements Serializable {
	private static final long serialVersionUID = 8630017051525373430L;

	private String oid;

	private Long codigo_autorizacion;

	private List<OrdenDetalleAutorizadaDto> recetaDetalle;

	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Long getCodigo_autorizacion() {
		return this.codigo_autorizacion;
	}

	public void setCodigo_autorizacion(Long codigo_autorizacion) {
		this.codigo_autorizacion = codigo_autorizacion;
	}

	public List<OrdenDetalleAutorizadaDto> getRecetaDetalle() {
		return this.recetaDetalle;
	}

	public void setRecetaDetalle(List<OrdenDetalleAutorizadaDto> recetaDetalle) {
		this.recetaDetalle = recetaDetalle;
	}
}
