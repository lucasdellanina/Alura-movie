import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;



public class App {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		// fazer uma conexao http e buscar os top 250 filmes
		//String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
		String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
		var http = new ClientHttp();
		String json = http.buscaDados(url);
		
		
		//exibir e manipular os dados
		//ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
		ExtratorDeConteudo  extrator = new ExtratorDeConteudoDaNasa();
		List <Conteudo> conteudos = extrator.extraiConteudos(json);
		
		var geradora = new GeradoraDeFigurinhas();
		
		for (int i = 0; i < 3; i++) {
			
			Conteudo conteudo = conteudos.get(i);

			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeArquivo = conteudo.getTitulo().replace(":", "-")  + ".png";
			
			
			geradora.cria(inputStream, nomeArquivo);
			
			
				System.out.println(conteudo.getTitulo());
				System.out.println(conteudo.getUrlImagem());
				System.out.println();
			
		}
		

	}

}