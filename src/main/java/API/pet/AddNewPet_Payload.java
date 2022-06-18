package API.pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddNewPet_Payload {
    public static AddNewPet addNewPet(){
        AddNewPet newPet = new AddNewPet();
        newPet.setId(1235);

        AddNewPet.Categories categories = new AddNewPet.Categories();
        categories.setId(0);
        categories.setName("string");
        newPet.setCategory(categories);

        newPet.setName("Friko");
        List<String> photo = new ArrayList<>();
                photo.add("https://depositphotos.com/10415184/stock-photo-golden-retriever-dog-sitting-on.html");
        newPet.setPhotoUrls(photo);

        AddNewPet.Tags tags = new AddNewPet.Tags();
        tags.setId(0);
        tags.setName("string");
        newPet.setStatus("available");
        List<AddNewPet.Tags> tagsList = new ArrayList<>();
        tagsList.add(tags);
        newPet.setTags(tagsList);

        return newPet;
    }

    public static Map<String,Object> addNewPetWrong(){
        Map<String, Object> payload = new HashMap<>();
        String[] category = new String[] {"1","name"};
        payload.put("id",1234);
        payload.put("category",category);
        payload.put("name","dog");
        String[] photoUrls = new String[] {"god.jpeg.com"};
        payload.put("photoUrls",photoUrls);
        String[] tags = new String[] {"id","name"};
        payload.put("status","sold");
        return payload;
    }

}
