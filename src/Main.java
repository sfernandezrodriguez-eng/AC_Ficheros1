void main() {

    Metodos app = new Metodos();


    String resultado1 = app.eDirectorio( "PruebaD");
    System.out.println("Resultado Prueba 1: " + resultado1);

    String resultado2 = app.eFicheiro( "PruebaF");
    System.out.println("Resultado Prueba 2: " + resultado2);

    String resultado3 = app.creaDirectorio( "PruebaD");
    System.out.println("Resultado Prueba 3: " + resultado3);

    String resultado4 = app.creaFicheiro( "PruebaD","PruebaF");
    System.out.println("Resultado Prueba 4: " + resultado4);

    String resultado5 = app.modoAcceso( "PruebaD","PruebaF");
    System.out.println("Resultado Prueba 5: " + resultado5);

    String resultado8 = app.mEscritura( "PruebaD","PruebaF");
    System.out.println("Resultado Prueba 8: " + resultado8);

    String resultado7 = app.mLectura( "PruebaD","PruebaF");
    System.out.println("Resultado Prueba 7: " + resultado7);

    String resultado6 = app.calculaLonxitude( "PruebaD","PruebaF");
    System.out.println("Resultado Prueba 6: " + resultado6);

    String resultado11 = app.mContido( "PruebaD");
    System.out.println("Resultado Prueba 11: " + resultado11);

    String resultado9 = app.borraFicheiro( "PruebaD","PruebaF");
    System.out.println("Resultado Prueba 9: " + resultado9);

    String resultado10 = app.borrarDirectorio( "PruebaD");
    System.out.println("Resultado Prueba 10: " + resultado10);

}
