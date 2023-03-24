/**
 * Copyright 2022 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */

package demo.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * <b> Clase Dto para la receta farmacia. </b>
 * 
 * @author luis.maldonadoq
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: luis.maldonadoq $, $Date: 19 oct. 2022 $]
 *          </p>
 */
public class OrdenFarmaciaDto implements Serializable {
	private static final long serialVersionUID = -7376217742800563531L;

	private String oid;
	private int farmacia_id;
	private List<OrdenDetalleFarmaciaDto> recetaDetalle;

	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public int getFarmacia_id() {
		return this.farmacia_id;
	}

	public void setFarmacia_id(int farmacia_id) {
		this.farmacia_id = farmacia_id;
	}

	public List<OrdenDetalleFarmaciaDto> getRecetaDetalle() {
		return this.recetaDetalle;
	}

	public void setRecetaDetalle(List<OrdenDetalleFarmaciaDto> recetaDetalle) {
		this.recetaDetalle = recetaDetalle;
	}
}
