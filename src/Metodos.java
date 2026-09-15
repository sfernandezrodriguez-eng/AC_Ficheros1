import java.io.*;
import java.util.Objects;

public class Metodos {
    private String cadea;
    private String dirName;
    private String fileName;


    public String eDirectorio(String cadea) {
        File archivo = new File(cadea);

        if (archivo.isDirectory()) {
            return"é directorio";
        } else {
            return"non é directorio";
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
            return"é ficheiro";
        } else {
            return "non é ficheiro";
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

    public String modoAcceso(String dirName, String fileName) {
        File archivo = new File(dirName, fileName);

        if (archivo.canRead() && archivo.canWrite()) {
            return "Lectura y escritura permitidas";
        } else if (archivo.canRead()) {
            return "lectura si";
        } else if (archivo.canWrite()) {
            return "escritura si";
        } else {
            return "Algo ha fallado en la lectura-escritura";
        }
    }

    public String calculaLonxitude(String dirName, String fileName) {
        File archivo = new File(dirName, fileName);
        if (archivo.exists() && archivo.isFile()) {
            return "A lonxitude de " + fileName + " é: " + archivo.length() + " bytes.";
        } else {
            return "O arquivo non existe ou non é un ficheiro válido.";
        }
    }

    public String mLectura(String dirName, String fileName) {
        File archivo = new File(dirName, fileName);
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea = "";
            String texto = "";
            while ((linea = lector.readLine()) != null) {
                texto = texto + linea;
                return texto;
            }
        } catch (IOException e) {
            return "Ocurrió un error al leer el archivo: " + e.getMessage();
        }
        return "Algo ha fallado antes de leer";
    }


    public String mEscritura(String dirName, String fileName) {
        File archivo = new File(dirName, fileName);
        try (FileWriter escritor = new FileWriter(archivo)) {
            escritor.write("Hola Mundo. ");
            escritor.write("Esto sigue en la misma línea.");
            return "Se a escrito de forma correcta";
        } catch (IOException e) {
            return "Ocurrió un error al escribir el archivo: " + e.getMessage();
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

    public String borrarDirectorio(String direName) {
        String resultado = eDirectorio(direName);

        if (Objects.equals(resultado, "é directorio")) {
            File archivo = new File(direName);
            if (archivo.delete()) {
                return "Se borro correctamente";
            } else {
                return "Algo falla 1";
            }
        } else {
            return "Algo falla 2";
        }
    }

    public String mContido(String dirName) {
        File dir = new File(dirName);
        if (dir.exists() && dir.isDirectory()) {
            File[] elementos = dir.listFiles();
            if (elementos != null) {
                StringBuilder resultado = new StringBuilder();
                for (File elem : elementos) {
                     String tipo = elem.isDirectory() ? "[DIR] " : "[ARQ] ";
                     resultado.append(tipo).append(elem.getName()).append("\n");
                }
                return resultado.toString();
            }
        } else {
            return"A ruta non existe ou non é un directorio válido.";
        }
        return"Algo ha fallado antes de ver el contido";
    }

    public String recur(File dir) {
        if (dir != null && dir.exists() && dir.isDirectory()) {
            File[] elementos = dir.listFiles();
            if (elementos != null) {
                for (File elem : elementos) {
                    if (elem.isDirectory()) {
                        String total = "[DIR]  " + elem.getAbsolutePath();
                        recur(elem);
                        return total;
                    } else {
                        return"[ARQ]  " + elem.getAbsolutePath();
                    }
                }
            }
        } return"No es directorioi o no existe";
    }
}

