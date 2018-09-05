import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;


public class Leitor {

	static File arquivo1 = new File("arquivo1.txt");
	static File arquivo2 = new File("arquivo2.txt");
	String linha1;
	String linha2;
	static double numero1;
	static double numero2;
	private static final Map <Operacoes, BiFunction <Double, Double, Double>> OPCAO;

	static {

		OPCAO = new HashMap();
		OPCAO.put(Operacoes.SOMA, (numero1, numero2) -> (numero1 + numero2));
		OPCAO.put(Operacoes.SUBTRACAO, (numero1, numero2) -> (numero1 - numero2));
		OPCAO.put(Operacoes.MULTIPLICACAO, (numero1, numero2) -> (numero1 * numero2));
		OPCAO.put(Operacoes.DIVISAO, (numero1, numero2) -> (numero1 / numero2));
		OPCAO.put(Operacoes.VERIFICA_QUAL_MAIOR_NUMERO, (numero1, numero2) -> { 
			if(numero1 > numero2) {
				return numero1;
			}
			return numero2;
		});

		OPCAO.put(Operacoes.VIRIFICAO_QUAL_MENOR_NUMERO, (numero1, numero2) -> {
			if(numero1 > numero2) {
				return numero1;
			} 
			return numero2;
		});



	}

	public void pegar() {
		try {
			FileReader arq1 = new FileReader(arquivo1);
			FileReader arq2 = new FileReader(arquivo2);
			BufferedReader lerArq1 = new BufferedReader(arq1);
			BufferedReader lerArq2 = new BufferedReader(arq2);


			linha1 = lerArq1.readLine();
			linha2 = lerArq2.readLine();

			numero1 = Integer.parseInt(linha1);
			numero2 = Integer.parseInt(linha2);



			arq1.close();
			arq2.close();
		}catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}

		System.out.println();
	}




	public static void gerar(int opcao) {
		File arquivoResultado = new File("resultado.txt");

		Scanner leitor = null;
		PrintWriter escritor = null;



		try {
			leitor = new Scanner(arquivoResultado);
			escritor = new PrintWriter(arquivoResultado);

			while (leitor.hasNextLine()) {

				String linha = leitor.nextLine();



				escritor.println(OPCAO.get(opcao).apply(numero1, numero2));
			}

		} catch (IOException e) {
			/* DO NOTHING */
		} finally {
			if (leitor != null) {
				leitor.close();
			}
			if (escritor != null) {
				escritor.close();
			}
		}
	}
}
