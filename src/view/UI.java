package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Note;

public class UI {
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	public static void mainScreen() {
		
		Locale.setDefault(Locale.US);
		Scanner sc = null;
		
		System.out.println("                          Bom dia/tarde/noite - " + sdf.format(new Date()));
		System.out.println();
		System.out.println("------------------- Lista do que já foi feito hoje (" + sdf.format(new Date()) + ") ---------------------------------------------------------------");
		System.out.println();
		
		try {
			sc = new Scanner(new File("src\\procedimento-" + sdf.format(new Date()) +".txt"));

			if (!sc.hasNext()) {
				System.out.println("                        Nenhum procedimento foi feito ainda");
			}
			
			while (sc.hasNext()) {
				System.out.println(sc.nextLine());				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
	
		System.out.println("Legenda:");
		System.out.println("(S) = Solucionado ");
		System.out.println("(P) = Pendente ");
		System.out.println("(I) = Informacional ");
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
		System.out.println();
		
		System.out.println("Escolha uma opção: ");
		System.out.println("(A) -> adicionar novo procedimento");
		System.out.println("(Q) -> sair");
		System.out.print("Opção: ");
		
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
				
				FileWriter filew = new FileWriter("src\\procedimento-" + sdf.format(new Date()) +".txt");
				
				filew.write(note.toString());
				filew.close();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}
	
}
