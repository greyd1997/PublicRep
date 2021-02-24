package com.greyd.rest;

import java.util.List;
import java.util.Optional;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;

import org.hibernate.query.criteria.internal.expression.function.CurrentTimeFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greyd.dao.FacturaDAO;
import com.greyd.dao.ProductoDAO;
import com.greyd.model.Cliente;
import com.greyd.model.Factura;
import com.greyd.model.Producto;

@RestController
@RequestMapping("bills")
public class FacturaRest {
	
	@Autowired
	private FacturaDAO facturaDAO; 
	private ProductoDAO productoDAO;


	
	
	
	//SERVER REQUEST
	
	//HISTORIA DE USUARIO 1
	@PostMapping("/save") 
	public void save(@RequestBody Factura factura)
	{
		factura = new Factura();
		factura.setId(5);
		long now = System.currentTimeMillis();
		factura.setTime(new Time(now));
		factura.setClientId("12345");
		Producto productos[] = new Producto[2];
		productos[0] = new Producto();
		productos[0].setId(6);
		productos[0].setName("Roda Puerta");
		productos[0].setPrice(25000.00);
		productos[1] = new Producto();
		productos[1].setId(2);
		productos[1].setName("Alimentador");
		productos[1].setPrice(30000.00);
		double acum = 0;
		String lista ="";
		for (int i = 0; i < productos.length; i++) 
		{
			lista = lista +", "+ productos[i].getName();
			acum = acum + productos[i].getPrice();
			
		}
		factura.setProductsList(lista);
		factura.setPriceNoIva(acum);
		double iva =0.19;
		double MontoIva=0;

		if(70000 < factura.getPriceNoIva() && factura.getPriceNoIva()<= 100000)
		{
			factura.setShipping(5000.00);
			MontoIva = factura.getPriceNoIva()*iva;
			
		}
		
		else if(factura.getPriceNoIva()>100000)
		{
			factura.setShipping(0.0);
			MontoIva = factura.getPriceNoIva()*iva;
		}
		
		else
		{
			factura.setShipping(0.0);
			MontoIva=0.0;
		}
		factura.setPriceIva(factura.getPriceNoIva()+MontoIva+factura.getShipping());
		facturaDAO.save(factura);
	}
	@GetMapping("/list")
	public List<Factura> list()
	{
		return facturaDAO.findAll();
	}
	
	//HISTORIA DE USUARIO 3
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id)
	{
		
		Factura factura = new Factura();
		factura.setId(2);
		factura.setClientId("12345");
		factura.setPriceIva(100200.00);
		factura.setPriceNoIva(80000.00);
		factura.setShipping(5000.00);
		factura.setProductsList("Botonera, Tablero, Puerta");
		
		int diferencia = calcularHoras(02, 23, 2021);
		if(diferencia < 12 )
		{
			facturaDAO.delete(factura);
		
		}
		else
		{
			
			factura.setPriceIva(factura.getPriceIva()*0.10);
			System.out.println("excedio el tiempo correspondiente de 12 horas se le generara un cargo del 10% de su factura y se procedera a cancelar su pedido");
		}
		
	}

	
	//HISTORIA DE USUARIO 2
	@PutMapping("/update")
	public void update(@RequestBody Factura factura)
	{
		Factura facturaNueva = new Factura();
		facturaNueva.setId(1);
		facturaNueva.setClientId("12345");
		facturaNueva.setPriceNoIva(95000.00);
		facturaNueva.setProductsList("Fotocelula, Botonera");
		
		
		int diferencia = calcularHoras(24, 02, 2021);

		if((diferencia < 5) && (facturaNueva.getPriceNoIva()>=factura.getPriceNoIva()) )
		{
			if(facturaNueva.getPriceNoIva()<=100000.00 && facturaNueva.getPriceNoIva() > 70000)
			{
				facturaNueva.setShipping(5000.0);
			}
			else if(facturaNueva.getPriceNoIva()>100000)
			{
				facturaNueva.setShipping(0.0);
			}
			facturaDAO.save(facturaNueva);
		}
		else
		{
		
			facturaDAO.save(factura);
			
		}
	}
	
	//METODO DE CALCULA LA DISFERENCIA EN HORAS ENTRE 2 FECHAS

	public int calcularHoras(int dia, int mes,int anio)
	{
		Calendar start = Calendar.getInstance();
		start.set(anio, mes-1, dia);
		start.set(Calendar.HOUR_OF_DAY, 06);
		start.set(Calendar.MINUTE, 10);
		start.set(Calendar.SECOND,22);
		
		
		Calendar actual = Calendar.getInstance();

		actual.set(Calendar.HOUR_OF_DAY, 06);
		actual.set(Calendar.MINUTE, 43);
		actual.set(Calendar.SECOND,20);
		
		long fin = actual.getTimeInMillis();
		long antes = start.getTimeInMillis();
		
		int horas =(int) ((Math.abs(fin-antes)) / (1000 * 60));
		return horas;
	}
	

}
