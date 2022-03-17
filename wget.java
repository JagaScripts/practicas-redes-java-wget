
import java.io.*;



public class wget {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String fileURLName = "fitxerURLs.txt";
			for(int i = 0;i < args.length;i++){
				if(args[i].compareTo("-f") == 0){
					fileURLName = args[i+1];
					System.out.printf("arg[%d] = %s = %s\n", i,args[i].toString(),args[i+1].toString());
				}
			}
			File file = new File(fileURLName);
			// Si el archivo no existe es creado
			if (!file.exists()) {
				String contenido = "http://www.google.com";
				file.createNewFile();
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(contenido);
				bw.close();
			}
			//Abrimos el archivo
            FileInputStream FileStream = new FileInputStream(fileURLName);
            // Creamos el objeto de entrada
            DataInputStream DatStream = new DataInputStream(FileStream);
            // Creamos el Buffer de Lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(DatStream));
            String strLinea;
            // Leer el archivo linea por linea
            int CountTrhead = 0;
            while ((strLinea = buffer.readLine()) != null)   {
            	String[] AStringArray = strLinea.split("//");
    			AStringArray = AStringArray[1].split("/");
    			String Namefile = AStringArray[AStringArray.length-1];
    			int CountDot = 0;
    			for(int i = 0; i<Namefile.length(); i++){ 
    				if( Namefile.charAt(i) == '.') {
    					CountDot++;
    				}
    			}
    			CountTrhead++;
    			if(CountDot>1){
    				Namefile = "index"+ CountTrhead +".html";
    			}
    			else{
    				String[] FilePart = Namefile.split("\\.");
    				Namefile = FilePart[0] + CountTrhead + "." + FilePart[1];
    			}
                DownFile thread = new DownFile(strLinea,Namefile, args); //Aqui llamamos a DownFile, le pasamos cada url y el nombre del fichero
                thread.start();   //Ejecutamos el thread
            }
            // Cerramos el archivo
            DatStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
