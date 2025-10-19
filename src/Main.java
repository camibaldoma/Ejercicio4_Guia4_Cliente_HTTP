//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String url = "http://localhost:8080/index.html";
        Cliente_HTTP cliente = new Cliente_HTTP();
        System.out.printf("Cliente iniciado.");
        //Inciso a
        cliente.getDocumentSocket(url);
        //Inciso b
        cliente.getDocument_URL(url);
    }
}