import java.io.FilterInputStream;
import java.io.InputStream;

public class HTMLtoAscii extends FilterInputStream {
       
        private InputStream AInSt;
        private boolean AInStTag = false;
       
        public HTMLtoAscii(InputStream AInSt) {
                super(AInSt);
                this.AInSt = AInSt;
        }
       
        @Override
        public int read(byte [] array)
        {
                try
                {
                        boolean tagEndNow = false;
                        // Primera lectura y bucle hasta el final
                        int leido = this.AInSt.read(array);
                        //System.out.println(leido);
                        int i = 0;
                        while(i < leido) {
                           //System.out.println(i);
                           if ((char)array[i] == '<'){
                        	   //System.out.println((char)array[i]);
                        	   this.AInStTag = true; // Estem a una etiqueta
                           }
                           if ((char)array[i] == '>'){
                        	   //System.out.println((char)array[i]);
                        	   this.AInStTag = false; // Finalitzem la etiqueta
                        	   tagEndNow = true; // Indiquem que acabem de finalitzar l'etiqueta
                           }
                           if (this.AInStTag || tagEndNow){// Si estem a la etiqueta o si l'acabem de finalitzar.
                        	   //System.out.println((char)array[i]);
                               array[i] = ' ';
                               //System.out.println((char)array[i]);
                           }
                           i++;
                           tagEndNow = false;
                        }
                        return leido;
                }
                catch (Exception e)
                {
                	e.printStackTrace();
                	return 0;
                }
        }

}

