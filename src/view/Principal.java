package view;

import javax.swing.JOptionPane;

import controller.NPRController;
import model.Pilha;

public class Principal {

	public static void main(String[] args) throws Exception {
		NPRController nprController = new NPRController();
		Pilha pilha = new Pilha();
		String entrada = String.valueOf(JOptionPane.showInputDialog(null, "Digite um numero ou operação \n (Digite SAIR para sair da aplicação"));
		boolean saida = true;
		
		while (saida) {
			if(entrada.equals("SAIR")) {
				saida = false;
				break;
			}
			if (entrada != null && entrada.matches("[0-9.]+")) {
				nprController.insereValor(pilha, entrada);
				entrada = String.valueOf(JOptionPane.showInputDialog(null, "Digite um numero ou operação"));
			} else{
				nprController.npr(pilha, entrada);
				entrada = String.valueOf(JOptionPane.showInputDialog(null, "Digite um numero ou operação"));
			}
		}

	}
}
