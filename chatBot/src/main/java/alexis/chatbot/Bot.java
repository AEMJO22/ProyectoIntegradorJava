package alexis.chatbot;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.MarkableFileInputStreamFactory;
import opennlp.tools.util.model.ModelUtil;

public class Bot {
    
    private DocumentCategorizerME categorizer;

    public void SimpleChatbot() throws IOException {
        // Cargar el modelo de categorización de documentos (entrenado previamente)
        InputStream modelInputStream = getClass().getResourceAsStream("/path/to/your/doccat-model.bin");
        InputStreamFactory modelInputStreamFactory = new MarkableFileInputStreamFactory(new File("/path/to/your/doccat-model.bin"));
        DoccatModel model = new DoccatModel(modelInputStreamFactory, ModelUtil.createDefaultTrainingParameters(), 0);

        // Inicializar el categorizador de documentos
        categorizer = new DocumentCategorizerME(model);
    }

    public String getResponse(String userInput) {
        // Categorizar la entrada del usuario
        double[] outcomes = categorizer.categorize(userInput);

        // Obtener la categoría más probable
        String category = categorizer.getBestCategory(outcomes);

        // Implementa la lógica de respuestas basada en la categoría
        return getResponseByCategory(category);
    }

    private String getResponseByCategory(String category) {
        // Define las respuestas para cada categoría
        Map<String, String> responses = new HashMap<>();
        responses.put("GREETING", "Hola, ¿cómo puedo ayudarte?");
        responses.put("QUESTION", "Esa es una pregunta interesante, pero no tengo la respuesta.");
        responses.put("GOODBYE", "Hasta luego, ¡que tengas un buen día!");

        // Devuelve la respuesta correspondiente a la categoría
        return responses.getOrDefault(category, "Lo siento, no entendí esa pregunta.");
    }
}
