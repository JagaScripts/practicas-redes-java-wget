import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class DownFile extends  Thread{
	
	private String url;
	private String Namefile;
	private InputStream AInStrm;
	private OutputStream AOuStrm;
	private int nByte;
	private ZipEntry AZipE;
	private boolean aFilter = false;
	private boolean zipFilter = false;
	private boolean GzipFilter = false;
	
	public DownFile(String strLinea, String strFile, String[] args){
		try {
			this.url = new String(strLinea);
			this.Namefile = new String(strFile);
			for(int i = 0;i < args.length;i++){
				if(args[i].compareTo("-a") == 0){
					this.aFilter = true;
					System.out.printf("arg[%d] = %s = %s\n", i,args[i].toString(),this.aFilter);
				}
				if(args[i].compareTo("-z") == 0){
					this.zipFilter = true;
					System.out.printf("arg[%d] = %s = %s\n", i,args[i].toString(),this.zipFilter);
				}
				if(args[i].compareTo("-gz") == 0){
					this.GzipFilter = true;
					System.out.printf("arg[%d] = %s = %s\n", i,args[i].toString(),this.GzipFilter);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run(){
		try {
			byte[] Abuffer = new byte[1000]; // buffer temporal de lectura.
			URL Aurl = new URL(this.url);
			// establecemos conexion
			URLConnection AurlCon = Aurl.openConnection();
			this.AInStrm = AurlCon.getInputStream();
			if((this.aFilter == true) && (AurlCon.getContentType().substring(0, "text/html".length()).compareTo("text/html") == 0)){
				this.AInStrm = new HTMLtoAscii(AurlCon.getInputStream());
				this.Namefile = this.Namefile.concat(".asc");
				
			}
			if(this.zipFilter == true){
				this.AZipE = new ZipEntry(this.Namefile);
				this.Namefile = this.Namefile.concat(".zip");
			}
			if(this.GzipFilter == true){
				this.Namefile = this.Namefile.concat(".gz");
				
			}
			this.AOuStrm = new FileOutputStream(this.Namefile);
			if(this.GzipFilter == true && this.zipFilter == true){
				this.AOuStrm = new ZipOutputStream(new GZIPOutputStream(this.AOuStrm));
				((ZipOutputStream) this.AOuStrm).putNextEntry(this.AZipE);
			}
			if(this.zipFilter == true && this.GzipFilter == false){
				this.AOuStrm = new ZipOutputStream(this.AOuStrm);
				((ZipOutputStream) this.AOuStrm).putNextEntry(this.AZipE);
			}
			if(this.GzipFilter == true && this.zipFilter == false){
				this.AOuStrm = new GZIPOutputStream(this.AOuStrm);
				
			}
			while((this.nByte = this.AInStrm.read(Abuffer)) > 0){
				this.AOuStrm.write(Abuffer, 0, this.nByte);
			}
			//this.leido = this.AInSt.read(Abuffer);
			//Lectura del archivo y escritura en fichero local
			//cierre de conexion y fichero.
			System.out.println("Fichero descargado");
			this.AInStrm.close();
			this.AOuStrm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
