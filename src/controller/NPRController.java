package controller;

import model.Pilha;

public class NPRController {

	private Pilha pilhaInt;

	public NPRController() {
		pilhaInt = new Pilha();
	}

	public void insereValor(Pilha p, String op) throws Exception {
		p.push(Integer.parseInt(op));
		int tamanho = p.size()+1;
		while (!p.isEmpty()) {
			pilhaInt.push(p.pop());
		}
		while (!pilhaInt.isEmpty()) {
			tamanho--;	
			p.push(pilhaInt.pop());
			System.out.println(tamanho + ". "+ p.top());
		}

	}

	public int npr(Pilha p, String op) throws Exception {
		int valorNovoTopo = 0;

		if (op.equals("/") || op.equals("*") || op.equals("+") || op.equals("-")) {
			if (p.size() >= 2) {
				int contador = 2;
				int primeiroPOP =0;
				int segundoPOP =0;
				while (!p.isEmpty()) {
					if(contador == 2) primeiroPOP = p.pop();
					else if(contador == 1)segundoPOP = p.pop();
					else pilhaInt.push(p.pop());
					contador--;
				}
				if(op.equals("+")) valorNovoTopo = primeiroPOP + segundoPOP;
				if(op.equals("-")) valorNovoTopo = primeiroPOP - segundoPOP;
				if(op.equals("*")) valorNovoTopo = primeiroPOP * segundoPOP;
				if(op.equals("/")) valorNovoTopo = primeiroPOP / segundoPOP;
				
				if(pilhaInt.size() == 0)p.push(valorNovoTopo);
				while (!pilhaInt.isEmpty()) {
					p.push(pilhaInt.pop());
				}
				p.push(valorNovoTopo);
				int tamanho = p.size()+1;
				while (!p.isEmpty()) {
					pilhaInt.push(p.pop());
				}
				while (!pilhaInt.isEmpty()) {
					tamanho--;	
					p.push(pilhaInt.pop());
					System.out.println(tamanho + ". "+ p.top());
				}

			} else
				throw new Exception("Valores Insuficientes");
		} else {
			throw new Exception("Favor digite um numero ou operação");
		}

		return valorNovoTopo;
	}

}
