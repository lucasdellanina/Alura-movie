import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {
	
	public List<Conteudo> extraiConteudos (String json){
		
		// pegar somente os dados desejados (titulo, poster, nota, ano)
		var parser = new JsonParser();
		List<Map<String, String>> listaDeAtributos = parser.parse(json);
		
		List <Conteudo> conteudos = new ArrayList <>();
		
		//popular a lista de conteudos
		for (Map<String, String> atributos : listaDeAtributos) {
			
			String urlImagem = atributos.get("url");
			String titulo = atributos.get("title");
			
			var conteudo = new Conteudo (titulo, urlImagem);
			conteudos.add(conteudo);
		}
		return conteudos;
	}

}
