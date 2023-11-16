package ar.edu.unlam.pb2.segundoParcial;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class AliciaEnElPaisDeLasMaravillasTest {
    
	@Test
    public void QueAlComprarUnAlimentoSeDescuenteElDineroDisponible() throws DineroExcedidoException {
    	String nombre="Alicia"; 
    	Integer edad=9; 
    	Double altura=180.0; 
    	Double peso=45.0; 
    	Double DineroDisponible=1000.0;
    	String nombreAlimento="Alfajor Terrabusi";
    	Double precio=250.0;
    	TipoDeAlimento tipo=TipoDeAlimento.ALFAJORES;
    	Double precioEsperado=750.0;
    	
    	Alicia alicia = new Alicia(nombre, edad, altura,peso,DineroDisponible);
    	Alimento alfajor = new AlimentoAchicador(nombreAlimento,precio,tipo);
        
    	Boolean seCompro=alicia.comprarAlimento(alfajor);
        assertTrue(seCompro);
        assertEquals(precioEsperado, alicia.getDineroDisponible(), 0.01);
        
    }

    @Test(expected = DineroExcedidoException.class)
    public void QueNoSeExcedaDelDineroDisponible() throws DineroExcedidoException{
    	String nombre="Alicia"; 
    	Integer edad=9; 
    	Double altura=180.0; 
    	Double peso=45.0; 
    	Double DineroDisponible=500.0;
    	String nombreAlimento="Alfajor Terrabusi";
    	Double precio=250.0;
    	TipoDeAlimento tipo=TipoDeAlimento.ALFAJORES;
    	
    	Alicia alicia = new Alicia(nombre, edad, altura,peso,DineroDisponible);
    	Alimento alfajor = new AlimentoAchicador(nombreAlimento,precio,tipo);
    	Alimento alfajor1 = new AlimentoAchicador("Alfajor jorgito",300.0,tipo);
        
    	alicia.comprarAlimento(alfajor);
        alicia.comprarAlimento(alfajor1);
        
    }

    @Test
    public void QueAlConsumirUnAlimentoVerificarQueSeAgrande() throws AlturaExcedidaException, DineroExcedidoException {
    	String nombre="Alicia"; 
    	Integer edad=9; 
    	Double altura=180.0; 
    	Double peso=45.0; 
    	Double DineroDisponible=500.0;
    	String nombreAlimento="Gomita";
    	Double precio=200.0;
    	TipoDeAlimento tipo=TipoDeAlimento.GOMITAS;
    	Double alturaEsperada=220.0;
    	
    	Alicia alicia = new Alicia(nombre, edad, altura,peso,DineroDisponible);
    	Alimento gomita = new AlimentoAgrandador(nombreAlimento,precio,tipo);
        alicia.comprarAlimento(gomita);
        
        alicia.consumirAlimentos(nombreAlimento);
        assertEquals(alturaEsperada, alicia.getAltura(), 0.01);
    }

   @Test
    public void QueAlConsumirUnAlimentoVerificarQueSeEncoja() throws AlturaExcedidaException, DineroExcedidoException {
	   	String nombre="Alicia"; 
	   	Integer edad=9; 
	   	Double altura=180.0; 
	   	Double peso=45.0; 
	   	Double DineroDisponible=500.0;
	   	String nombreAlimento="Alfajor Terrabusi";
	   	Double precio=250.0;
	   	TipoDeAlimento tipo=TipoDeAlimento.ALFAJORES;
	   	Double alturaEsperada=130.0;
	   	
	   	Alicia alicia = new Alicia(nombre, edad, altura,peso,DineroDisponible);
	   	Alimento alfajor = new AlimentoAchicador(nombreAlimento,precio,tipo);
        alicia.comprarAlimento(alfajor);
        
        alicia.consumirAlimentos(nombreAlimento);
        assertEquals(alturaEsperada, alicia.getAltura(), 0.01);
    }

    @Test (expected = AlturaExcedidaException.class)
    public void QueAlConsumirUnAlimentoVerificarQueNoSePuedaAgrandarMasDe280cm() throws AlturaExcedidaException, DineroExcedidoException {
    	String nombre="Alicia"; 
    	Integer edad=9; 
    	Double altura=180.0; 
    	Double peso=45.0; 
    	Double DineroDisponible=500.0;
    	String nombreAlimento="Gomita";
    	Double precio=200.0;
    	TipoDeAlimento tipo=TipoDeAlimento.GOMITAS;
    	
    	Alicia alicia = new Alicia(nombre, edad, altura,peso,DineroDisponible);
    	Alimento gomita = new AlimentoAgrandador(nombreAlimento,precio,tipo);
        alicia.comprarAlimento(gomita);
        Alimento caramelos = new AlimentoAgrandador("Caramelos", 25.0,TipoDeAlimento.CARAMELOS);
        alicia.comprarAlimento(caramelos);
        Alimento bocaditosChocolate = new AlimentoAgrandador("Bocaditos de Chocolate", 25.0,TipoDeAlimento.BOCADITOS_DE_CHOCOLATES);
        alicia.comprarAlimento(bocaditosChocolate);
        
        alicia.consumirAlimentos(nombreAlimento);
        alicia.consumirAlimentos("Caramelos");
        alicia.consumirAlimentos("Bocaditos de Chocolate");
        
    }

    @Test (expected = AlturaExcedidaException.class)
    public void QueAlConsumirUnAlimentoVerificarQuenoSePuedaAchicarMenosDe50cm() throws AlturaExcedidaException, DineroExcedidoException {
    	String nombre="Alicia"; 
    	Integer edad=9; 
    	Double altura=180.0; 
    	Double peso=45.0; 
    	Double DineroDisponible=2000.0;
    	String nombreAlimento="Alfajor Terrabusi";
    	Double precio=250.0;
    	TipoDeAlimento tipo=TipoDeAlimento.ALFAJORES;
    	
    	Alicia alicia = new Alicia(nombre, edad, altura,peso,DineroDisponible);
    	Alimento alfajor = new AlimentoAchicador(nombreAlimento,precio,tipo);     
        alicia.comprarAlimento(alfajor);
        Alimento masitas = new AlimentoAchicador("Masitas", 250.0,TipoDeAlimento.MASITAS);
        alicia.comprarAlimento(masitas);
        Alimento bagels = new AlimentoAchicador("Bagels", 180.0,TipoDeAlimento.BAGELS);
        alicia.comprarAlimento(bagels);
        
        alicia.consumirAlimentos(nombreAlimento);
        alicia.consumirAlimentos("Masitas");
        alicia.consumirAlimentos("Bagels");
        
    }

    @Test
    public void VerificarQueLaColeccionDeAlimentosQuedeOrdenadaPorNombreDeManeraDescendente() throws DineroExcedidoException, AlturaExcedidaException {
    	String nombre="Alicia"; 
    	Integer edad=9; 
    	Double altura=180.0; 
    	Double peso=45.0; 
    	Double DineroDisponible=1500.0;
    	String nombreAlimento="Alfajor Terrabusi";
    	Double precio=250.0;
    	TipoDeAlimento tipo=TipoDeAlimento.ALFAJORES;
    	Integer cantidaDeAlimentosEsperado=3;
    	
    	Alicia alicia = new Alicia(nombre, edad, altura,peso,DineroDisponible);
    	Alimento alfajor = new AlimentoAchicador(nombreAlimento,precio,tipo);
        alicia.comprarAlimento(alfajor);
    	Alimento masitas = new AlimentoAchicador("Masitas", 50.0,TipoDeAlimento.MASITAS);
        alicia.comprarAlimento(masitas); 
        Alimento bagels = new AlimentoAchicador("Bagels", 50.0,TipoDeAlimento.BAGELS);
        alicia.comprarAlimento(bagels);

        ArrayList<Alimento>alimentos =alicia.getAlimentosComprados();
        alicia.OrdenarLosAlimentosDeManeraDescendente();

        assertEquals(masitas, alimentos.get(0));
        assertEquals(bagels, alimentos.get(1));
        assertEquals(alfajor, alimentos.get(2));
        assertEquals(cantidaDeAlimentosEsperado, alicia.getCantidadComprado());
        
    }
    
    @Test
    public void VerificarQueLaColeccionDeAlimentosQuedeOrdenadaPorNombreDeManeraNaturalAscendente() throws DineroExcedidoException, AlturaExcedidaException {
    	String nombre="Alicia"; 
    	Integer edad=9; 
    	Double altura=180.0; 
    	Double peso=45.0; 
    	Double DineroDisponible=1500.0;
    	String nombreAlimento="Alfajor Terrabusi";
    	Double precio=250.0;
    	TipoDeAlimento tipo=TipoDeAlimento.ALFAJORES;
    	Integer cantidaDeAlimentosEsperado=3;
    	
    	Alicia alicia = new Alicia(nombre, edad, altura,peso,DineroDisponible);
    	Alimento alfajor = new AlimentoAchicador(nombreAlimento,precio,tipo);
        alicia.comprarAlimento(alfajor);
    	Alimento masitas = new AlimentoAchicador("Masitas", 50.0,TipoDeAlimento.MASITAS);
        alicia.comprarAlimento(masitas); 
        Alimento bagels = new AlimentoAchicador("Bagels", 50.0,TipoDeAlimento.BAGELS);
        alicia.comprarAlimento(bagels);

        ArrayList<Alimento>alimentos =alicia.getAlimentosComprados();
        alicia.OrdenarLosAlimentosDeManeraNaturalAscendente();

        assertEquals(alfajor, alimentos.get(0));
        assertEquals(bagels, alimentos.get(1));
        assertEquals(masitas, alimentos.get(2));
        assertEquals(cantidaDeAlimentosEsperado, alicia.getCantidadComprado());
        
    }
    
	@Test
	public void quePermitaSaberCuantosAlimentosDeCadaTipoComproAlicia() throws DineroExcedidoException {
		String nombre="Alicia"; 
    	Integer edad=9; 
    	Double altura=180.0; 
    	Double peso=45.0; 
    	Double DineroDisponible=1500.0;
    	String nombreAlimento="Alfajor Terrabusi";
    	Double precio=250.0;
    	TipoDeAlimento tipo1=TipoDeAlimento.ALFAJORES;
    	TipoDeAlimento tipo2=TipoDeAlimento.MASITAS;
    	TipoDeAlimento tipo3=TipoDeAlimento.CARAMELOS;
    	TipoDeAlimento tipo4=TipoDeAlimento.BOCADITOS_DE_CHOCOLATES;

    	
    	Alicia alicia = new Alicia(nombre, edad, altura,peso,DineroDisponible);
    	Alimento alfajor = new AlimentoAchicador(nombreAlimento,precio,tipo1);
        alicia.comprarAlimento(alfajor);
    	Alimento masitas = new AlimentoAchicador("Masitas", 50.0,tipo2);
        alicia.comprarAlimento(masitas); 
        Alimento caramelos = new AlimentoAgrandador("Caramelos", 25.0,tipo3);
        alicia.comprarAlimento(caramelos);
        Alimento bocaditosChocolate = new AlimentoAgrandador("Bocaditos de Chocolate", 25.0,tipo4);
        alicia.comprarAlimento(bocaditosChocolate);
    	Alimento alfajor1 = new AlimentoAchicador(nombreAlimento,precio,tipo1);
        alicia.comprarAlimento(alfajor1);

        Map<TipoDeAlimento,Integer> alimentosPorTipoEsperado = alicia.cantidadDeAlimentosPorTipoCompradosPorAlicia();
		Map<TipoDeAlimento,Integer> alimentosPorTipoObtenido = new HashMap<>();
		alimentosPorTipoObtenido.put(tipo1, 2);
		alimentosPorTipoObtenido.put(tipo2, 1);
		alimentosPorTipoObtenido.put(tipo3, 1);
		alimentosPorTipoObtenido.put(tipo4, 1);
		
		assertEquals(alimentosPorTipoEsperado.get(tipo1),alimentosPorTipoObtenido.get(tipo1));
		assertEquals(alimentosPorTipoEsperado.get(tipo2),alimentosPorTipoObtenido.get(tipo2));
		assertEquals(alimentosPorTipoEsperado.get(tipo3),alimentosPorTipoObtenido.get(tipo3));
		assertEquals(alimentosPorTipoEsperado.get(tipo4),alimentosPorTipoObtenido.get(tipo4));
  
	}
	
	   @Test
	    public void QueAlConsumirUnAlimentoVerificarQueFueConsumidoYEliminadoDeLosElementosComprados() throws AlturaExcedidaException, DineroExcedidoException {
		   	String nombre="Alicia"; 
		   	Integer edad=9; 
		   	Double altura=180.0; 
		   	Double peso=45.0; 
		   	Double DineroDisponible=500.0;
		   	String nombreAlimento="Alfajor Terrabusi";
		   	Double precio=250.0;
		   	TipoDeAlimento tipo=TipoDeAlimento.ALFAJORES;
		   	Double alturaEsperada=130.0;
		   	
		   	Alicia alicia = new Alicia(nombre, edad, altura,peso,DineroDisponible);
		   	Alimento alfajor = new AlimentoAchicador(nombreAlimento,precio,tipo);
	        alicia.comprarAlimento(alfajor);
	        
	        alicia.consumirAlimentos(nombreAlimento);
	        assertEquals(alturaEsperada, alicia.getAltura(), 0.01);
	        assertTrue(alicia.getAlimentosComprados().isEmpty());
	    }
	   
	   @Test
	    public void QueVerificarLosAlimentosConsumidos() throws AlturaExcedidaException, DineroExcedidoException {
		   	String nombre="Alicia"; 
		   	Integer edad=9; 
		   	Double altura=180.0; 
		   	Double peso=45.0; 
		   	Double DineroDisponible=500.0;
		   	String nombreAlimento="Alfajor Terrabusi";
		   	Double precio=250.0;
		   	TipoDeAlimento tipo=TipoDeAlimento.ALFAJORES;
		   	
		   	Alicia alicia = new Alicia(nombre, edad, altura,peso,DineroDisponible);
		   	Alimento alfajor = new AlimentoAchicador(nombreAlimento,precio,tipo);
	        alicia.comprarAlimento(alfajor);
	        
	        alicia.consumirAlimentos(nombreAlimento);
	        ArrayList<Alimento>alimentosConsumido =alicia.getConsumido();
	        assertEquals(alfajor,alimentosConsumido.get(0));
	        
	    }
    	
}
