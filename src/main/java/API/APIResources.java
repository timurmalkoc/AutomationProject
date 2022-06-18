package API;

public enum APIResources {
    findByStatus("/pet/findByStatus"),
    findPetById("/pet/"),
    addPet("/pet");

    private String source;
    APIResources(String source) {
        this.source =source;
    }

    public String getSource(){
        return source;
    }
}
