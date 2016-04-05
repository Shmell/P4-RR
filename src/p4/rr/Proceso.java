package p4.rr;

import javax.swing.plaf.SliderUI;


public class Proceso extends Thread
{
 //Thread hilo;
 
 private int numero;
 int duracion;//Lo que debe durar el procesos
 int dura;//Lo que le falta de operacion
 int inicio;
 
	
 public Proceso(int numero,int tiempo)
 {
  this.numero=numero;
  duracion=tiempo;
  //Thread hilo=new Thread(this);
  inicio=1;
  dura=duracion;
 }
 
 ///////////////////////////////////////////////////////////////
 
 public void run() 
 {
 /*
  imprimeListo();
  
  try
	 {
	 sleep(1000);
	 }
  catch (InterruptedException e1)
	 {
	 e1.printStackTrace();
	 }
  */
  
  try
	 {
	  imprimeEjecucion();
	 }
  catch (InterruptedException e)
	 {
	  e.printStackTrace();
	 } 	
	
  
  
  this.interrupt();
  
  
  
 }
 
 ///////////////////////////////////////////////////////////////
 
 public void imprimeEjecucion() throws InterruptedException 
 {

 String pos=Integer.toString(numero);
 String vieja,nueva,aux="",aux2="";
 

 
 
 
 
 if(numero<=9)
 	  pos="0"+Integer.toString(numero);

 
    if(inicio==1)
	  vieja="Proceso "+pos+"\t"+"Listo y en espera";
    else
   	 vieja="Proceso "+pos+"\t"+"En ejecucion"+"\t"+(dura+1);
   	 
	  nueva="Proceso "+pos+"\t"+"En ejecucion"+"\t"+dura;
	 
	 
	  while(dura!=duracion-(Ventana.rr*inicio) && dura!=-1)
		 {
		 aux=Ventana.texto.getText();
		 aux2=aux.replaceFirst(vieja, nueva);
		 
		 Ventana.texto.setText(aux2);
		  
		  
		  vieja=nueva;
		  dura--;
		  nueva="Proceso "+pos+"\t"+"En ejecucion"+"\t"+dura;
		  sleep(1000);
		 }
	 /*
	  if(dura==duracion-Interfaz.rr)
		 {
		  vieja="Proceso "+pos+"\t"+"En ejecucion"+"\t"+(dura+1);
		  nueva="Proceso "+pos+"\t"+"Finalizado";
		  
		  
		  aux=Interfaz.texto.getText();
		  aux2=aux.replaceFirst(vieja, nueva);
		  Interfaz.texto.setText(aux2);
		 }
	*/
	 
	 
  
 
	  inicio++;
 
 
 }
 
 /////////////////////////////////////////////////////////////////
 
 public void imprimeListo()
 {
  String pos=Integer.toString(numero);
  String status="Listo y en espera";

  if(numero<=9)
 	 {
 	  pos="0"+Integer.toString(numero);
 	 }
  
  if(numero==1)
	  Ventana.texto.append("Proceso "+pos+"\t"+status);
  else
	  Ventana.texto.append("\n"+"Proceso "+pos+"\t"+status);
 	  
 }
 
 /////////////////////////////////////////////////////////////////
 /*
 public void imprimeBloqueado()
 {
  String pos=Integer.toString(numero);
  String status="Bloqueado";

  if(numero<=9)
 	 {
 	  pos="0"+Integer.toString(numero);
 	 }
  
  if(numero==1)
	  Interfaz.texto.append("Proceso "+pos+"\t"+status);
  else
	  Interfaz.texto.append("\n"+"Proceso "+pos+"\t"+status);
 	  
 }
 */
}
