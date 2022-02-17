package view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Note;

public class UI {
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	public static void mainScreen() {
		
		Locale.setDefault(Locale.US);
		
		System.out.println();
		System.out.println("                                          Bom dia/tarde/noite - " + sdf.format(new Date()));
		System.out.println();
		System.out.println("----------------------------------- Lista do que ja foi feito hoje (" + sdf.format(new Date()) + ") ----------------------------------------");
		System.out.println();
		
		File path = new File("procedimento-" + sdf.format(new Date()) +".txt");
		
		Scanner sc = null;
		
		try (Scanner sc1 = new Scanner(path)) {
			
			if (!sc1.hasNext()) {
				System.out.println("                                        Nenhum procedimento foi feito ainda");
				System.out.println();
			}
			
			int n = 1;
			while (sc1.hasNext()) {
				
				System.out.println(n + ". " + sc1.nextLine());
				n++;
			}
			
		} catch (FileNotFoundException e) {
			
			System.out.println("O arquivo não foi encontrado na pasta");

			try {
				FileWriter filew = new FileWriter("procedimento-" + sdf.format(new Date()) +".txt", true);
				BufferedWriter bf = new BufferedWriter(filew);
				bf.close();
				
				System.out.println("O arquivo de hoje foi criado com sucesso!");
				
				UI.mainScreen();
				
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
			
		}
		
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
	
		System.out.println("Legenda:");
		
		System.out.println();
		
		System.out.println("(S) = Solucionado ");
		System.out.println("(P) = Pendente ");
		System.out.println("(I) = Informacional ");
		
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		System.out.println();
		
		System.out.println("Escolha uma opcao: ");
		System.out.println();
		
		System.out.println("(A) -> adicionar novo procedimento");
		System.out.println("(Q) -> sair");
		
		System.out.println();
		System.out.print("Opcao: ");
		
		try {
			sc = new Scanner(System.in);
			char choice = sc.next().charAt(0);
			if (choice == 'A') {
				
				System.out.println("----- novo procedimento feito: -----");

				System.out.print("Qual o status do procedimento? S/P (Solucionado/Pendente): ");
				char status = sc.next().charAt(0);
	
				while (status != 'S' && status != 'P') {
					System.out.print("Digite S ou P: ");
					status = sc.next().charAt(0);
				}
				
				System.out.print("Digite o procedimento: ");
				sc.nextLine();
				String txt = sc.nextLine();
				
				Note note = new Note(status, txt, "");
				
				FileWriter filew = new FileWriter("procedimento-" + sdf.format(new Date()) +".txt", true);
				BufferedWriter bf = new BufferedWriter(filew);
				filew.append(note.toString());
				bf.newLine();
				bf.close();
				
				UI.mainScreen();
				
			}
			
		} catch (IOException e) {
			System.out.println("Não foi possível escrever no arquivo!");
			e.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}
	
}
