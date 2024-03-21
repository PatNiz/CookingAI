package pl.niziolekp.app.cookingai.service;

import org.springframework.stereotype.Service;
import pl.niziolekp.app.cookingai.service.chatgpt.ChatGPTService;

import java.util.List;
@Service
public class CookingIdeaServiceImpl implements CookingIdeaService {
    private final ChatGPTService chatGPTHelper;
    private final ProductService productService;

    public CookingIdeaServiceImpl(ChatGPTService chatGPTHelper, ProductService productService) {
        this.chatGPTHelper = chatGPTHelper;
        this.productService = productService;
    }

    @Override
    public String getBreakfastIdeas(List<String> products) {
        String allProducts = String.join(",", products);
        String question = "I have in fridge" + allProducts + ".What can I do for breakfast? Give me 3 ideas.";
        StringBuilder stringBuilder = new StringBuilder();
        chatGPTHelper.getChatGPTOutput(question, stringBuilder);
        return stringBuilder.toString();
    }
}
