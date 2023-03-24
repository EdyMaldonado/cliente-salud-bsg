/**
 * Copyright 2022 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */

package demo.dto;

import java.io.Serializable;

/**
 * 
 * <b> Clase Dto para el detalle de la receta autorizada. </b>
 * 
 * @author luis.maldonadoq
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: luis.maldonadoq $, $Date: 19 oct. 2022 $]
 *          </p>
 */
public class OrdenDetalleAutorizadaDto implements Serializable {
	private static final long serialVersionUID = 8630017051525373430L;

	private int medicamento_id;

	private int cantidad_prescrita;

	private double precio_farmacia;

	public int getMedicamento_id() {
		return this.medicamento_id;
	}

	public void setMedicamento_id(int medicamento_id) {
		this.medicamento_id = medicamento_id;
	}

	public int getCantidad_prescrita() {
		return this.cantidad_prescrita;
	}

	public void setCantidad_prescrita(int cantidad_prescrita) {
		this.cantidad_prescrita = cantidad_prescrita;
	}

	public double getPrecio_farmacia() {
		return this.precio_farmacia;
	}

	public void setPrecio_farmacia(double precio_farmacia) {
		this.precio_farmacia = precio_farmacia;
	}
}
