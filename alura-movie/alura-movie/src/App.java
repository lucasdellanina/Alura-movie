import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		// fazer uma conexao http e buscar os top 250 filmes
		String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
		URI endereco = URI.create(url);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();

		
		// pegar somente os dados desejados (titulo, poster, nota, ano)
		var parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);
		
		var geradora = new GeradoraDeFigurinhas();
		
		//exibir e manipular os dados
		for (Map<String, String> filme : listaDeFilmes) {
			String urlImagem = filme.get("image");
			String titulo = filme.get("title");
			
			InputStream inputStream = new URL(urlImagem).openStream();
			
			
			String nomeArquivo = titulo.replace(":", "-")  + ".png";
			
			
			geradora.cria(inputStream, nomeArquivo);
			
			
				System.out.println(titulo);
				System.out.println(filme.get("image"));
				System.out.println(filme.get("imDbRating"));
				System.out.println();
			
		}
		

	}

}