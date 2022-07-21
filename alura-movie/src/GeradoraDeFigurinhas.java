import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
//import java.net.URL;




public class GeradoraDeFigurinhas {
	
	
	void cria(InputStream inputStream, String nomeArquivo) throws IOException {
		//leitura da imagem
		//InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_3.jpg").openStream();
		BufferedImage imagemOriginal = 	ImageIO.read(inputStream);
		
		
		//cria nova imagem em memoória com transparência e com tamanho novo
		 int largura = imagemOriginal.getWidth();
		 int altura = imagemOriginal.getHeight();
		 
		 int novaAltura = altura + 200;
		 
		 BufferedImage novaImagem = new BufferedImage (largura, novaAltura, BufferedImage.TRANSLUCENT);
		 
	
		//copiar a imagem original para nova imagem (em memória)
		 Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		 graphics.drawImage(imagemOriginal, 0, 0, null);
		
		//escrever uma frase na imagem
		 var fonte = new Font(Font.SERIF, Font.BOLD, 78);
		 
		 graphics.setFont(fonte);
		 graphics.setColor(Color.RED);
		 graphics.drawString("TOPZERA",(largura/2)-10, novaAltura-100);
		
		//escrever nova imagem em arquivo
		 ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));
	}
	

}
