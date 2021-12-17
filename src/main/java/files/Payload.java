package files;

public class Payload {
    private String placeId = "0";
    private String place = "{\n" +
            "    \"location\":{\n" +
            "        \"lat\":-38.383494,\n" +
            "        \"lng\":33.427362\n" +
            "    },\n" +
            "    \"accuracy\": 50,\n" +
            "    \"name\":\"Frontline house\",\n" +
            "    \"phone_number\":\"(+91) 983 893 3937\",\n" +
            "    \"address\":\"29, side layout, cohen 09\",\n" +
            "    \"types\":[\n" +
            "        \"shoe park\",\n" +
            "        \"shop\"\n" +
            "    ],\n" +
            "    \"website\":\"http://google.com\",\n" +
            "    \"language\":\"French-IN\"\n" +
            "}";
    public String updatePlace(String street){
        return "{\n" +
                "    \"place_id\":\""+this.placeId+"\",\n" +
                "    \"address\":\""+street+"\",\n" +
                "    \"key\":\"qaclick123\"\n" +
                "}";
    }

    public String getPlace(){return place;};
    public void setPlaceId(String placeId){ this.placeId = placeId;};
    public String getPlaceId(){return this.placeId;}
}
