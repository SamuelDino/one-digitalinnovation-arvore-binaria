package one.digitalinovation;

public class Main {

    public static void main(String[] args) {
        Arvore<Integer> minhaArvore = new Arvore<>();

        minhaArvore.addNo(50);
        minhaArvore.addNo(30);
        minhaArvore.addNo(20);
        minhaArvore.addNo(33);
        minhaArvore.addNo(30);
        minhaArvore.addNo(23);
        minhaArvore.addNo(40);
        minhaArvore.addNo(70);
        minhaArvore.addNo(80);
        System.out.println(minhaArvore);
        minhaArvore.removeNo(20);
        System.out.println(minhaArvore);

    }
}
