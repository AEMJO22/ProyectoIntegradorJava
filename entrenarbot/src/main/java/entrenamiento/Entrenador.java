package entrenamiento;
import opennlp.tools.doccat.*;
import java.io.*;

import java.util.ArrayList;
import java.util.List;

import java.nio.charset.StandardCharsets;


public class Entrenador {
public static void main(String[] args) {
        try {
            // Obtener datos de entrenamiento
            List<DocumentSample> trainingData = getTrainingData();

            // Entrenar el modelo
            DoccatModel model = trainModel(trainingData);

            // Guardar el modelo en un archivo
            saveModel(model, "doccat-model.bin");

            System.out.println("Modelo de categorización de documentos entrenado y guardado con éxito.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<DocumentSample> getTrainingData() {
        // Cargar datos de entrenamiento desde un archivo
        List<DocumentSample> trainingData = new ArrayList<>();
        trainingData.add(c:/archivoEntrenamiento)
        
        // Ejemplo de lectura de un archivo
        // Adaptar esta parte según el formato de tu conjunto de datos
        /*trainingData.add(new DocumentSample("GREETING", "Hola, ¿cómo estás?"));
        trainingData.add(new DocumentSample("QUESTION", "¿Cuál es la capital de Francia?"));
        trainingData.add(new DocumentSample("GOODBYE", "Hasta luego, ¡gracias por tu ayuda!"));*/



        return trainingData;
    }

    private static DoccatModel trainModel(List<DocumentSample> trainingData) throws IOException {
        // Configurar el entrenamiento del modelo
        DoccatFactory factory = new DoccatFactory();
        TrainingParameters params = ModelUtil.createDefaultTrainingParameters();
        params.put(TrainingParameters.ITERATIONS_PARAM, 100);
        params.put(TrainingParameters.CUTOFF_PARAM, 0);

        // Entrenar el modelo
        DoccatModel model = DocumentCategorizerME.train("es", new DocumentSampleStream(trainingData), params, factory);

        return model;
    }

    private static void saveModel(DoccatModel model, String filePath) throws IOException {
        // Guardar el modelo en un archivo binario
        try (OutputStream modelOut = new FileOutputStream(filePath)) {
            model.serialize(modelOut);
        }
    }
}
