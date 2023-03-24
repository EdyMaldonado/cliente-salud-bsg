package test;

import java.io.Serializable;
import java.util.ArrayList;

import org.junit.Test;

import demo.cliente.ClienteBsg;
import demo.dto.OrdenDetalleFarmaciaDto;
import demo.dto.OrdenFarmaciaDto;

public class Validacion implements Serializable {

	private static final long serialVersionUID = -4464415864815854645L;

	@Test
	public void validarCliente() {
		ClienteBsg client = new ClienteBsg();
		System.out.println(client.consultarMsp("0151103710"));
		System.out.println(client.consultarIssfa("0401061767", "01-01-2022"));
		OrdenFarmaciaDto ord = new OrdenFarmaciaDto();
		OrdenDetalleFarmaciaDto det = new OrdenDetalleFarmaciaDto();
		det.setId(821);
		det.setMedicamento_id(48);
		det.setCantidad_prescrita(1);
		det.setPrecio_farmacia(1.009860);
		ord.setRecetaDetalle(new ArrayList<OrdenDetalleFarmaciaDto>());
		ord.getRecetaDetalle().add(det);
		ord.setOid("2.001793.00012717");
		ord.setFarmacia_id(123);
		System.out.println("****************:" + client.autorizar(ord));
	}
}
