import java.io.*;

public class Metodos {
    private String cadea;
    private String dirName;
    private String fileName;


    public String eDirectorio(String cadea) {
        File archivo = new File(cadea);

        if (archivo.isDirectory()) {
            return "é directorio";
        } else {
            return "non é directorio";
        }
    }

    /**
     * public static String eDirectorio(String cadea){
     * File arquivo = new File(cadea);
     * return arquivo.isDirectory() ? "Si": "non";
     * }
     **/

    public String eFicheiro(String cadea) {
        File archivo = new File(cadea);

        if (archivo.isFile()) {
            return "é directorio";
        } else {
            return "non é directorio";
        }
    }

    public String creaDirectorio(String fileName) {
        String resultado = eDirectorio(fileName);

        if (resultado == "non é directorio") {
            File archivo = new File(fileName);
            if (archivo.mkdir()) {
                return "Se creo correctamente";
            } else {
                return "Algo falla 1";
            }
        } else {
            return "Algo falla 2";
        }
    }

    public String creaFicheiro(String dirName, String fileName) {
        File directorio = new File(dirName);
        if (directorio.exists() == false) {
            directorio.mkdirs();
        }

        File archivo = new File(directorio, fileName);

        try {
            if (archivo.createNewFile()) {
                return "Se creo correctamente";
            } else {
                return "O ficheiro xa existe";
            }
        } catch (IOException e) {
            return "Algo falla 1: " + e.getMessage();
        }
    }

    public void modoAcceso(String dirName, String fileName) {
        File archivo = new File(dirName, fileName);

        if (archivo.canWrite()) {
            System.out.println("escritura si");
        } else {
            System.out.println("escritura non");
        }

        if (archivo.canRead()) {
            System.out.println("lectura si");
        } else {
            System.out.println("lectura non");
        }
    }

    public long calculaLonxitude(String dirName, String fileName) {
        File archivo = new File(dirName, fileName);
        return archivo.length();
    }

    public void mLectura(String dirName, String fileName) {
        File archivo = new File(dirName, fileName);
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }


    public void mEscritura(String dirName, String fileName) {
        File archivo = new File(dirName, fileName);
        try (FileWriter escritor = new FileWriter(archivo)) {
            escritor.write("Hola Mundo. ");
            escritor.write("Esto sigue en la misma línea.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir el archivo: " + e.getMessage());
        }
    }

    public String borraFicheiro(String dirName, String fileName) {
        File directorio = new File(dirName);
        if (directorio.exists() == false) {
            directorio.mkdirs();
        }

        File archivo = new File(directorio, fileName);

        if (archivo.delete()) {
            return "Se borro correctamente";
        } else {
            return "O ficheiro non existe";
        }
    }

    public String borrarDirectorio(String fileName) {
        String resultado = eDirectorio(fileName);

        if (resultado == "non é directorio") {
            File archivo = new File(fileName);
            if (archivo.delete()) {
                return "Se borro correctamente";
            } else {
                return "Algo falla 1";
            }
        } else {
            return "Algo falla 2";
        }
    }

    public void mContido(String dirName) {
        File dir = new File(dirName);
        if (dir.exists() && dir.isDirectory()) {
            File[] elementos = dir.listFiles();
            if (elementos != null) {
                for (File elem : elementos) {
                    String tipo = elem.isDirectory() ? "[DIR] " : "[ARQ] ";
                    System.out.println(tipo + elem.getName());
                }
            }
        } else {
            System.out.println("A ruta non existe ou non é un directorio válido.");
        }
    }

    public void recur(File dir) {
        if (dir != null && dir.exists() && dir.isDirectory()) {
            File[] elementos = dir.listFiles();
            if (elementos != null) {
                for (File elem : elementos) {
                    if (elem.isDirectory()) {
                        System.out.println("[DIR]  " + elem.getAbsolutePath());
                        recur(elem);
                    } else {
                        System.out.println("[ARQ]  " + elem.getAbsolutePath());
                    }
                }
            }
        }
    }

}

