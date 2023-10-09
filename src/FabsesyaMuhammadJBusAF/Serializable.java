package FabsesyaMuhammadJBusAF;


import java.util.HashMap;
public class Serializable
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();
    protected Serializable(){
        if (mapCounter.containsKey(getClass())) {
            mapCounter.put(getClass(), mapCounter.get(getClass()) + 1);
            this.id = mapCounter.get(getClass());
        }
        else {
            mapCounter.put(getClass(), 0);
            this.id = 0;
        }
    }
    public static <T extends Serializable> Integer setLastAssignedId(Class<T> tClass, int id) {
        return mapCounter.put(tClass, id);
    }

    public static <T extends Serializable> Integer getLastAssignedId(Class<T> tClass) {
        return mapCounter.get(tClass);
    }


    public int compareTo(Serializable i) {
        if (id == i.id) {
            return 0;
        }
        else if (id > i.id) {
            return 1;
        }
        else{
            return -1;
        }
    }
    public boolean equals(Object object) {
        if (object instanceof Serializable) {
            Serializable i = (Serializable) object;
            return id == i.id;
        }
        else {
            return false;
        }
    }
    public boolean equals(Serializable i) {
        return id == i.id;
    }


    
}
