package p4.rr;

public class Automatico extends Thread
{
	static int limite=0;
	
	
	
	
	
	
	public void run()
	{
		
		//while(limite++ < 7)
                while(true)
		{
			if(Ventana.contador==0)
	  	   	 {
			Ventana.crea();
			Ventana.Creador.start();
	  	   	 }
	  	    else
	  	    	Ventana.crea();
			
			
			
			try {
				this.sleep(2500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	 
		
		
		
		
	}

}
