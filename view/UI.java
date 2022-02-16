package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entities.Note;

public class UI {
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat();
	
	public static void mainScreen() {
		
		List<Note> list = new ArrayList<>();
		Note note = new Note("S", "Altera", "");
		Note note2 = new Note("S", "Cupom travado PDV 17", "");
		Note note3 = new Note("S", "Cupom travado PDV 18", "");
		
		list.add(note);
		list.add(note2);
		list.add(note3);
		
		System.out.println("Bom dia/tarde/noite - dd/MM/yyyy");
		System.out.println();
		System.out.println("------ Lista do que já foi feito hoje (dd/MM/yyyy) ------");
		System.out.println();
		System.out.println();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println((i +1) + ". " + list.get(i).toString());
		}
		
		System.out.println("----- Escolha uma opção: ------");
		System.out.println();
		System.out.println();
		System.out.println("----- novo procedimento: -----");
	}
	
}
