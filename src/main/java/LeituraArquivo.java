import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LeituraArquivo {
	
	public static void main(String[] args) {
		
		try {
			
			System.out.println("iniciando leitura");
			
			final List<String> linhas = new ArrayList<String>();
			
			BufferedReader br = new BufferedReader(new FileReader("/home/iago/Desktop/teste-fopag.txt"));
		    StringBuilder sb = new StringBuilder();
		    
		    String line = br.readLine();
		    
		    while (line != null) {
		    	linhas.add(line);    	
		    	line = br.readLine();
		    }
		    
		    br.close();
		    
		    final List<Cnab> cnabs = new ArrayList<Cnab>();
		    
		    Cnab cnab = null;
		    
		    for (Integer contador = 0; contador <= linhas.size(); contador++) {
		    	
		    	if (contador < 2 || contador > (linhas.size() - 2)) {
		    		continue;
		    	}
		    	
		    	if (contador % 2 == 0) {
		    		cnab = new Cnab();
		    		cnab.setNomeColaborador(linhas.get(contador).substring(105, 132));
		    		cnab.setTipoRetorno(linhas.get(contador).substring(230, 232));
		    		continue;
		    	}
		    	
		    	cnab.setDigitoVerificador(linhas.get(contador).substring(229, 230));
		    	cnab.setNumeroConta(linhas.get(contador).substring(217, 229));		    	
		    	
		    	cnabs.add(cnab);
		    	
		    	System.out.println(cnab);
		    }
		}
		catch(Exception e) {
		   System.out.println("ERRO");
		   System.out.println(e);
		}
		
	}
	

}
