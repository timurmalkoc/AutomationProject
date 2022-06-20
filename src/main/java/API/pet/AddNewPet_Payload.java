package API.pet;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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

    public static AddNewPet updatePet(int id, String name){
        AddNewPet newPet = new AddNewPet();
        newPet.setId(id);

        AddNewPet.Categories categories = new AddNewPet.Categories();
        categories.setId(0);
        categories.setName("string");
        newPet.setCategory(categories);

        newPet.setName(name);
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

    public static Map<String,Object> addNewPet(int id, String petName, String status) {
        Map<String, Object> addPet = new LinkedHashMap<>();
        addPet.put("id",id);
        AddNewPet.Categories categories = addNewPet().getCategory();
        categories.setId(1);
        categories.setName("Animals");
        addPet.put("category",categories);

        addPet.put("name",petName);

        List<String> urls = new ArrayList<>();
        urls.add("www.example.com");
        addPet.put("photoUrls",urls);

        List<AddNewPet.Tags> tags = new ArrayList<>();
        AddNewPet.Tags tag = new AddNewPet.Tags();
        tag.setId(1);
        tag.setName("cute doggies");
        tags.add(tag);
        addPet.put("tags",tags);

        addPet.put("status",status);

        return addPet;
    }
}
