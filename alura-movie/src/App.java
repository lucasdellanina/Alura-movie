import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		// fazer uma conexao http e buscar os top 250 filmes
		String url = "https://imdb-api.com/en/API/Top250Movies/k_bd46ur8c";
		URI endereco = URI.create(url);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();

		
		// pegar somente os dados desejados (titulo, poster, nota, ano)
		var parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);
		
		
		//exibir e manipular os dados
		for (Map<String, String> filme : listaDeFilmes) {
				System.out.println(filme.get("title"));
				System.out.println(filme.get("image"));
				System.out.println(filme.get("imDbRating"));
				System.out.println();
			
		}
		

	}

}