import java.util.Scanner;

public class Main {


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite a operação desejada: \n");
		int operacaoDesejada = sc.nextInt();

		Leitor.gerar(operacaoDesejada);

	}

}
