package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Note;

public class UI {
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void mainScreen() {
		
		Locale.setDefault(Locale.US);
		Scanner sc = null;
		List<Note> list = new ArrayList<>();
		
		System.out.println("Bom dia/tarde/noite - " + sdf.format(new Date()));
		System.out.println();
		System.out.println("------ Lista do que já foi feito hoje (" + sdf.format(new Date()) + ") ------");
		System.out.println();
		
		try {
			sc = new Scanner(new File("C:\\Users\\joao305904\\Downloads\\Eclipse-default-workspace\\CPD-Notes\\file.txt"));

			while (sc.hasNext()) {
				System.out.println(sc.nextLine());				
			}
		} catch (FileNotFoundException e1) {
			System.out.println("Erro: Arquivo de leitura não encontrado!");
			e1.printStackTrace();
		} finally {
			sc.close();
		}
		
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
				list.add(note);	
				
				UI.mainScreen();
			}
			
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}
	
}
